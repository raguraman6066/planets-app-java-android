package com.example.planetsapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    private ArrayList<Planet> planetsArrayList;
    Context context;

    public MyCustomAdapter( ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list_layout,planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    //getview() -create and return view for a specific item in the list

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get planet object for current position
        Planet planets=getItem(position);
        //inflate layout
        MyViewHolder myViewHolder;
        final View result;
if(convertView==null){
    myViewHolder=new MyViewHolder();
    LayoutInflater inflater=LayoutInflater.from(getContext());
    convertView=inflater.inflate(R.layout.item_list_layout,parent,false);
//finding views
    myViewHolder.planetName=(TextView) convertView.findViewById(R.id.planet_name);
    myViewHolder.moonCount=(TextView) convertView.findViewById(R.id.moonCount);
    myViewHolder.planetImg=(ImageView) convertView.findViewById(R.id.imageView);
    result=convertView;
    convertView.setTag(myViewHolder);
}else{
    //view is recycled-reusing -getTag()
    myViewHolder=(MyViewHolder)convertView.getTag();
    result=convertView;
}
myViewHolder.planetName.setText(planets.getPlanetName());
myViewHolder.moonCount.setText(planets.getMoonCount());
myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

return result;
    }
}
