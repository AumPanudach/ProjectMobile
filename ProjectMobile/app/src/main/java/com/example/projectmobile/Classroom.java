package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Classroom extends AppCompatActivity {
    String []stdy = {"B4-21","B4-20"};
    int []images = {R.drawable.picture8_4,R.drawable.picture8_1};
    DataLab dataLab;
    List<DataLab> dataLabList;
    MyAdapterLab myAdapterLab;

    RecyclerView recyclerView;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classroom);
        recyclerView = findViewById(R.id.recycle_class);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataLabList = new ArrayList<>();
        for (int i = 0 ; i < images.length ; i++){
            dataLab = new DataLab(stdy[i],images[i]);
            dataLabList.add(dataLab);
        }
        myAdapterLab = new MyAdapterLab(getApplicationContext(),dataLabList);
        recyclerView.setAdapter(myAdapterLab);
        bottomNavigationView = findViewById(R.id.bottomNavigativeView_classroom);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
                return true;
            }else if (item.getItemId() == R.id.event){
                startActivity(new Intent(getApplicationContext(),Event.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.course) {
                startActivity(new Intent(getApplicationContext(),Map.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.logout) {
                finish();
                return true;
            }
            return false;
        });
    }
}