package com.example.restcountries;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {


    public MyRecyclerAdapter(Context context, List<String> miArreglo) {
        mInflater = LayoutInflater.from(context);
        this.miArreglo = miArreglo;
    }

    public List<String> getMiArreglo() {
        return miArreglo;
    }

    public MyRecyclerAdapter setMiArreglo(List<String> miArreglo) {
        this.miArreglo = miArreglo;
        return this;
    }

    private List<String> miArreglo = new ArrayList<>();
    private LayoutInflater mInflater;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String name = miArreglo.get(i);
        viewHolder.myTextView.setText(name);

    }

    @Override
    public int getItemCount() {
        return miArreglo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.countryName);
        }

    }
}
