package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Lab extends AppCompatActivity {
    String []namelab = {"ห้องปฏิบัติการวิทยาการสารสนเทศประยุกต์","ห้องปฏิบัติการโครงงานพิเศษ","ห้องปฏิบัติการวิศกรรมไฟฟ้าและระบบควบคุมอัตโนมัติ","ห้องปฏิบัติการคอมพิวเตอร์ 1","ห้องปฏิบัติการคอมพิวเตอร์ 2","ห้องปฏิบัติการคอมพิวเตอร์ 3","ห้องปฏิบัติการด้านการจัดการอุตสาหกรรม 2",
            "ห้องปฏิบัติการเทคโนโลยีมัลติมีเดีย"};
    int []src_images = {R.drawable.picture1_1,R.drawable.picture2_1,R.drawable.picture3_1,R.drawable.picture4_1,R.drawable.picture5_1,R.drawable.picture6_1
                        ,R.drawable.picture7_1};
    ImageSlider imageSlider2;
    RecyclerView recyclerView;
    DataLab dataLab;
    List<DataLab> dataLabList;
    MyAdapterLab myAdapterLab;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);
        imageSlider2  = findViewById(R.id.image_slider_2);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.picture3_3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.picture8_3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.picture7_2, ScaleTypes.FIT));
        imageSlider2.setImageList(slideModels);
         recyclerView = findViewById(R.id.recycl_lab);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataLabList = new ArrayList<>();
        for (int i = 0 ; i < src_images.length; i++){
            dataLab = new DataLab(namelab[i],src_images[i]);
            dataLabList.add(dataLab);
        }
        myAdapterLab = new MyAdapterLab(getApplicationContext(),dataLabList);
        recyclerView.setAdapter(myAdapterLab);
        bottomNavigationView = findViewById(R.id.bottomNavigativeView_lab);
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