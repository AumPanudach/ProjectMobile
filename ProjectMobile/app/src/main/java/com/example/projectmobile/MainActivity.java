package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView map_btn,btn_course,btn_event,btn_per,lab_btn,classroom_btn;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_course = findViewById(R.id.btn_course);
        btn_per = findViewById(R.id.btn_personnel);
        lab_btn = findViewById(R.id.btn_lab);
        classroom_btn = findViewById(R.id.btn_classroom);
        classroom_btn.setOnClickListener(this);
        lab_btn.setOnClickListener(this);
        btn_per.setOnClickListener(this);
        btn_course.setOnClickListener(this);
        bottomNavigationView = findViewById(R.id.bottomNavigativeView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
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


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_course) {
            startActivity(new Intent(getApplicationContext(), Course.class));
            finish();
        } else if (v.getId() == R.id.btn_personnel) {
            startActivity(new Intent(getApplicationContext(),Personnel.class));
            finish();
        } else if (v.getId() == R.id.btn_lab) {
            startActivity(new Intent(getApplicationContext(),Lab.class));
            finish();
        } else if (v.getId() == R.id.btn_classroom) {
            startActivity(new Intent(getApplicationContext(),Classroom.class));
            finish();
        }

    }
}

