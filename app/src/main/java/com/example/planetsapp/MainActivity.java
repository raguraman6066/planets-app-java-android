package com.example.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/*
* 1. create item_list_layout
* 2. activity_main list view
* 3. create model class -Planet.java- it defines the attributes and behaviour associated with each item- holds data
* 4. create adapter using extends ArrayAdapter<Planet>
* 5. initialize listview in main activity.java and arraylist-data structure to store and manipulate data
* 6. add the planet data list to arraylist
* 7. initialize array adapter in main activity and set adapter to listview
* */
public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        planetsArrayList=new ArrayList<>();
        Planet planet3 = new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet1 = new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 Moons", R.drawable.venus);

        Planet planet4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);

        Planet planet7 = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);
        adapter=new MyCustomAdapter(planetsArrayList,getApplicationContext());
        listView.setAdapter(adapter);
          //click list items
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             Toast.makeText(MainActivity.this, "Planet Name: "+adapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();

         }
     });


    }
}