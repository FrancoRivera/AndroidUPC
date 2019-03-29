package com.example.restcountries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;
    private List<String> countries = new ArrayList<>();
    private List<String> codes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyRecyclerAdapter(this, countries, codes);
        RecyclerView recycler = findViewById(R.id.myRecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);


        AndroidNetworking.get("https://restcountries.eu/rest/v2/all")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i ++){
                                countries.add(response.getJSONObject(i).getString("name").toString());
                                codes.add(response.getJSONObject(i).getString("alpha2Code").toString());
                            }
                            adapter.setMiArreglo(countries);
                            adapter.setCountryCodeArreglo(codes);
                            adapter.notifyDataSetChanged();
                        }
                        catch (Exception e){

                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }
}
