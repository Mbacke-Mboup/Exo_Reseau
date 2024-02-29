package com.example.retrofitlistes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class AdapterOne extends RecyclerView.Adapter<AdapterOne.MyViewHolder> {

    public ArrayList<String> taskItems;
    private Context context;

    public AdapterOne() {
        this.taskItems = new ArrayList<>();

    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView result;

        public MyViewHolder(LinearLayout v){
            super(v);
            result = v.findViewById(R.id.result);


        }


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ressource, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String taskCourante = taskItems.get(position);
        holder.result.setText(taskCourante);

    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }
}