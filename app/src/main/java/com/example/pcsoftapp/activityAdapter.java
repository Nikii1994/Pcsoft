package com.example.pcsoftapp;



import android.annotation.SuppressLint;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pcsoftapp.model.Activities;

import java.util.ArrayList;



public class activityAdapter  extends RecyclerView.Adapter<activityAdapter.MyCustomeView>   {


    private ArrayList<Activities> items;

    Context context;


    public activityAdapter(ArrayList<Activities> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyCustomeView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.activity_layout, parent, false);

        return new MyCustomeView(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull final MyCustomeView holder, int position) {

        String pos= String.valueOf(position+1);





            holder.activitytitle.setText("Avtivity"+pos);








    }

    @Override
    public int getItemCount() {


        return items.size();
    }


    public class MyCustomeView extends RecyclerView.ViewHolder
    {
        TextView activitytitle;
          Button btnout;
        public MyCustomeView(@NonNull final View itemView)
        {
            super(itemView);

            activitytitle = itemView.findViewById(R.id.activityname);
            btnout = itemView.findViewById(R.id.btn_out);

        }
    }
}
