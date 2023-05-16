package com.example.pcsoftapp;



import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;

import androidx.appcompat.app.AlertDialog;


/**
 * DialogLoader will be used to show and hide Dialog with ProgressBar
 **/

public class DialogLoader {

    private Activity activity;

    private ProgressDialog progressDialog;


    public DialogLoader(Activity activity) {
        this.activity = activity;


        initDialog();
    }

    View dialogView;

    private void initDialog() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);



    }


    public void showProgressDialog(String message) {


        try {
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void hideProgressDialog() {


        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
