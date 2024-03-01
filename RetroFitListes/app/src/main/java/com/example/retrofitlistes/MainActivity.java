package com.example.retrofitlistes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitlistes.http.RetroFItUi;
import com.example.retrofitlistes.http.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AdapterOne adapterOne;
    AdapterTwo adapterTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Service service = RetroFItUi.get();

        service.webTwo().enqueue(new Callback<List<Transfer>>() {
            @Override
            public void onResponse(Call<List<Transfer>> call, Response<List<Transfer>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    ArrayList<Transfer> resultat = new ArrayList<>(response.body());
                    RecyclerView recyclerView = findViewById(R.id.recyclerTwo);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapterTwo = new AdapterTwo();
                    adapterTwo.taskItems = resultat;
                    recyclerView.setAdapter(adapterTwo);

                } else {
                    Toast.makeText(MainActivity.this, "Oops! Une Erreur!!!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Transfer>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }


        });


        service.webOne().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    ArrayList<String> resultat = new ArrayList<>(response.body());
                    RecyclerView recyclerView = findViewById(R.id.recyclerOne);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapterOne = new AdapterOne();
                    adapterOne.taskItems = resultat;
                    recyclerView.setAdapter(adapterOne);


                } else {
                    Toast.makeText(MainActivity.this, "Oops! Une Erreur!!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });




    }
}