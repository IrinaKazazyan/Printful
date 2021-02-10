package com.example.printful.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.printful.Models.Hero;
import com.example.printful.R;

import java.util.List;

import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter {

//    private Context context;
//    private List<Hero> heroList;
//
//    public CustomAdapter(Context context, List<Hero> heroList) {
//        this.context = context;
//        this.heroList = heroList;
//    }
//
//    public int getCount() {
//        return heroList.size();
//    }
//
//    public Object getItem(int position) {
//        return heroList.get(position);
//    }
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//    public View getView(int position, View convertView, ViewGroup parent) {
////        ScanResult result = results.get(position);
//
//        if (convertView == null) {
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout.row_item, null);
//        }
////
//        ImageView imageView = convertView.findViewById(R.id.imageView);
//        TextView name = convertView.findViewById(R.id.textViewName);
//
//        name.setText(heroList.getName());
//
//
////        txtSSID.setText(result.SSID);
////        txtState.setText("connected");
//
//        return convertView;
//    }
//
//}
//


    private String[] names;
    private Context context;
    List<Hero> heroList;

    public CustomAdapter(Context context, String[] names,   List<Hero> heroList) {
        super(context, R.layout.row_item, names);
        this.context = context;
        this.names = names;
        this.heroList = heroList;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView = inflater.inflate(R.layout.row_item, null);
//        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null)
            view = inflater.inflate(R.layout.row_item, null, true);
        TextView name = (TextView) view.findViewById(R.id.textViewName);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);

        for (int i = 0; i < heroList.size(); i++) {
            System.out.println("TAG" + heroList.get(i).getName());
            System.out.println("TAG" + heroList.get(i).getImageUrl());
        }

        name.setText(names[position]);
        return view;
    }
}