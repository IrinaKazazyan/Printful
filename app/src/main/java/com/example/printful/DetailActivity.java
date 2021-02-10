package com.example.printful;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView tvName, tvBio, tvCreatedBy, tvYear, tvPublisher;
    String name, bio, imageUrl, year, publisher, createdBy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle(getResources().getString(R.string.details));

        imageView = findViewById(R.id.image);
        tvName = findViewById(R.id.tv_name);
        tvBio = findViewById(R.id.tv_bio);
        tvCreatedBy = findViewById(R.id.tv_createdBy);
        tvPublisher = findViewById(R.id.tv_publisher);
        tvYear = findViewById(R.id.tv_year);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("name") && getIntent().hasExtra("bio") && getIntent().hasExtra("imageUrl")
        && getIntent().hasExtra("year")  && getIntent().hasExtra("createdBy") && getIntent().hasExtra("publisher")) {
            name = getIntent().getStringExtra("name");
            bio = getIntent().getStringExtra("bio");
            imageUrl = getIntent().getStringExtra("imageUrl");
            year = getIntent().getStringExtra("year");
            createdBy = getIntent().getStringExtra("createdBy");
            publisher = getIntent().getStringExtra("publisher");
        } else {
            Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        tvName.setText(name);
        tvBio.setText(bio);
        tvYear.setText(year);
        tvPublisher.setText(publisher);
        tvCreatedBy.setText(createdBy);
        Glide.with(this).load(imageUrl).into(imageView);
    }
}