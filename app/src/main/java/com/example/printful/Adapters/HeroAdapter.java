package com.example.printful.Adapters;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.printful.DetailActivity;
import com.example.printful.Models.Hero;
import com.example.printful.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    private List<Hero> heroList;
    private Context context;

    public HeroAdapter(List<Hero> heroList, Context context) {
        this.heroList = heroList;
        this.context = context;
    }


    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new HeroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);
        holder.textViewName.setText(hero.getName());
        holder.textViewYear.setText(hero.getFirstAppearance());
        Glide.with(context).load(hero.getImageUrl()).into(holder.imageView);

//      item click
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("name", hero.getName());
                intent.putExtra("bio", hero.getBio());
                intent.putExtra("imageUrl", hero.getImageUrl());
                intent.putExtra("year", hero.getFirstAppearance());
                intent.putExtra("createdBy", hero.getCreatedBy());
                intent.putExtra("publisher", hero.getPublisher());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    static class HeroViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewYear;
        ImageView imageView;
        ConstraintLayout mainLayout;

        HeroViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewYear = itemView.findViewById(R.id.tvFirstappearance);
            imageView = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
