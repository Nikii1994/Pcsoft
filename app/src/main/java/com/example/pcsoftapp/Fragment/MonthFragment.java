package com.example.pcsoftapp.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.pcsoftapp.R;
import com.example.pcsoftapp.activityAdapter;
import com.example.pcsoftapp.model.Activities;
import com.example.pcsoftapp.model.Company;
import com.example.pcsoftapp.network.APIClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MonthFragment extends Fragment {
    ArrayList<Activities> listofactivity;

    RecyclerView recyclerView;
    SharedPreferences preferences ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // fetchActivities();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
           fetchActivities();
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_month, container, false);
        recyclerView = view.findViewById(R.id.myActivityList);
        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
         listofactivity = new ArrayList<>();
             fetchActivities();
        return  view;
    }

    private void fetchActivities() {

        String Use_Id = preferences.getString("user_id","");

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = sdf.format(new Date());
        Call<ArrayList<Activities>> call = APIClient.getInstance()
                .getUserActivity(Use_Id,currentDate);


        call.enqueue(new Callback<ArrayList<Activities>>() {


            @Override
            public void onResponse(Call<ArrayList<Activities>> call, Response<ArrayList<Activities>> response) {
                if (response.isSuccessful()) {

                    if(response.body() != null){

                        listofactivity  = response.body();


                        activityAdapter activityListAdapter = new activityAdapter( listofactivity,getActivity());
                        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        recyclerView.setAdapter(activityListAdapter);




                    }



                }


            }

            @Override
            public void onFailure(Call<ArrayList<Activities>> call, Throwable t) {




                Toast toast = Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }

}