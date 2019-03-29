package com.example.restcountries;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.widget.ANImageView;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<String> miArreglo = new ArrayList<>();
    private List<String> countryCodeArreglo = new ArrayList<>();
    private LayoutInflater mInflater;

    public MyRecyclerAdapter(Context context, List<String> miArreglo, List<String> countryCodeArreglo) {
        mInflater = LayoutInflater.from(context);
        this.miArreglo = miArreglo;
        this.countryCodeArreglo = countryCodeArreglo;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.recyclerview_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String name = miArreglo.get(i);
        String country_code = countryCodeArreglo.get(i);
        viewHolder.myTextView.setText(name);
        viewHolder.myImageView.setImageUrl("https://www.countryflags.io/"+country_code+"/flat/64.png");
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView myTextView;
        ANImageView myImageView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.countryName);
            myImageView = itemView.findViewById(R.id.countryFlag);
        }

    }

    @Override
    public int getItemCount() {
        return miArreglo.size();
    }

    public List<String> getCountryCodeArreglo() {
        return countryCodeArreglo;
    }

    public void setCountryCodeArreglo(List<String> countryCodeArreglo) {
        this.countryCodeArreglo = countryCodeArreglo;
    }
    public List<String> getMiArreglo() {
        return miArreglo;
    }

    public MyRecyclerAdapter setMiArreglo(List<String> miArreglo) {
        this.miArreglo = miArreglo;
        return this;
    }


}
