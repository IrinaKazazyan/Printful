package com.example.printful;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.printful.Adapters.CustomAdapter;
import com.example.printful.Adapters.HeroAdapter;
import com.example.printful.Models.Hero;
import com.example.printful.Retrofit.RetrofitClient;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private HeroAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(getResources().getString(R.string.heroes));

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //calling the method to display the heroes
        getHeroes();
    }

    private void getHeroes() {
        Call<List<Hero>> call = RetrofitClient.getInstance().getMyApi().getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();

                adapter = new HeroAdapter(heroList, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}