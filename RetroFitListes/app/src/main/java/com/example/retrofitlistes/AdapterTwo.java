package com.example.retrofitlistes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTwo extends RecyclerView.Adapter<AdapterTwo.MyViewHolder> {

    public ArrayList<Transfer> taskItems;

    public AdapterTwo() {
        this.taskItems = new ArrayList<>();
    }


    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView one;
        public TextView two;
        public TextView three;

        public MyViewHolder(LinearLayout v){
            super(v);
            one = v.findViewById(R.id.one);

            two = v.findViewById(R.id.two);

            three = v.findViewById(R.id.three);

        }


    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.comple_item_ressource, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Transfer taskCourante = taskItems.get(position);
        holder.one.setText(taskCourante.a.toString());
        holder.two.setText(taskCourante.b);
        holder.three.setText(""+taskCourante.c.size());

    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }
}