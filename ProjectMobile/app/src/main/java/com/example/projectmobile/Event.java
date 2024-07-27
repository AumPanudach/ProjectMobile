package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Event extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ImageSlider imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> slideModels = new  ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.event_slider_1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.event_slider_2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.event_slider_3, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        ImageSlider imageSlider2 = findViewById(R.id.image_slider_2);
        ArrayList<SlideModel> slideModels2 = new ArrayList<>();
        slideModels2.add(new SlideModel(R.drawable.event_4, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable.event_5, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable.event_6, ScaleTypes.FIT));
        imageSlider2.setImageList(slideModels2,ScaleTypes.FIT);
        bottomNavigationView = findViewById(R.id.bottomNavigativeView_event);
        bottomNavigationView.setSelectedItemId(R.id.event);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
                return true;
            }else if (item.getItemId() == R.id.event){
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