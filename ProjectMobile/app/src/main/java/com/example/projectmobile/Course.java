package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Course extends AppCompatActivity {

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Course.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();
        androidData = new DataClass("หลักสูตร IT", R.string.it, "129 หน่วยกิต", R.drawable.course_it);
        dataList.add(androidData);
        androidData = new DataClass("หลักสูตร INE", R.string.ine, "135 หน่วยกิต", R.drawable.course_ine);
        dataList.add(androidData);
        androidData = new DataClass("หลักสูตร ITI", R.string.iti, "87 หน่วยกิต", R.drawable.course_iti);
        dataList.add(androidData);
        adapter = new MyAdapter(Course.this, dataList);
        recyclerView.setAdapter(adapter);
        bottomNavigationView = findViewById(R.id.bottomNavigativeView);
        bottomNavigationView.setSelectedItemId(R.id.course);
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