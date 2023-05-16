package com.example.pcsoftapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pcsoftapp.DialogLoader;
import com.example.pcsoftapp.Fragment.TodayFragment;
import com.example.pcsoftapp.R;
import com.example.pcsoftapp.model.Login;
import com.example.pcsoftapp.network.APIClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    EditText user_id;


    EditText user_pass;


    Button login;
    DialogLoader dialogLoader;

    SharedPreferences preferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean status = preferences.getBoolean("IsLogin",false);
           getStatus(status);
        login=findViewById(R.id.btn_login);
        user_id=findViewById(R.id.edt_userid);
        user_pass=findViewById(R.id.edt_pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user_id.getText().toString().isEmpty() || user_pass.getText().toString().isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Enter User Id", Toast.LENGTH_SHORT).show();
                } else {




                    login(user_id.getText().toString().trim(), user_pass.getText().toString().trim(), "E", true);
                }
            }
        });

    }

    private void getStatus(boolean status) {

        if(status == true){

            Intent i =new Intent(this,MainActivity.class);
            if(Build.VERSION.SDK_INT >= 11) {
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            } else {
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
            startActivity(i);

        }
    }

    private void login(String userid, String pass, String partyst, boolean b) {


        dialogLoader = new DialogLoader(LoginActivity.this);
        dialogLoader.showProgressDialog("Please wait");
        Call<Login> call = APIClient.getInstance()
                .login(userid, pass, partyst, b);


        call.enqueue(new Callback<Login>() {


            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {

                       boolean status= response.body().getStatus();
                    if(status == true){

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("IsLogin",true);
                        String userid= user_id.getText().toString();
                        editor.putString("user_id",userid);
                        editor.apply();
                        dialogLoader.hideProgressDialog();
                        Intent i =new Intent(LoginActivity.this,MainActivity.class);
                        if(Build.VERSION.SDK_INT >= 11) {
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        } else {
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        }
                        startActivity(i);


                    }else if(status == false){

                        try {
                            dialogLoader.hideProgressDialog();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Toast toast = Toast.makeText(LoginActivity.this, "Invalid userid and password", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
                        toast.show();
                    }

                }


            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

                try {
                    dialogLoader.hideProgressDialog();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Toast toast = Toast.makeText(LoginActivity.this, "Please check your internet connection", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

    }
}

