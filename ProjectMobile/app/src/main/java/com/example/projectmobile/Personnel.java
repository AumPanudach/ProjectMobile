package com.example.projectmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Personnel extends AppCompatActivity {
    RecyclerView recyclerView;
    PerDataClass perDataClass;
    MyAdaterPer adaterPer;
    List<PerDataClass> perDataClassList;
    int []image_src = { R.drawable.personnel101,R.drawable.personnel102,
                        R.drawable.personnel103,R.drawable.personnel104,
                        R.drawable.personnel105,R.drawable.personnel106,
                        R.drawable.personnel107,R.drawable.personnel108,
                        R.drawable.personnel109,R.drawable.personnel110,
                        R.drawable.personnel111,R.drawable.personnel112,
                        R.drawable.personnel113,R.drawable.personnel114,
                        R.drawable.personnel115,R.drawable.personnel116,
                        R.drawable.personnel117,R.drawable.personnel118,
                        R.drawable.personnel119,R.drawable.personnel120,
                        R.drawable.personnel121,R.drawable.personnel122,
                        R.drawable.personnel123,R.drawable.personnel124,
                        R.drawable.personnel125,R.drawable.personnel126,
                        R.drawable.personnel127
    };
    BottomNavigationView bottomNavigationView;
    String[] name = {"ผศ.ดร.ขนิษฐา นามี" ,"ผศ.ดร.วันทนี ประจวบศุภกิจ" ,"ผศ.ดร.พาฝัน ดวงไพศาล" ,"ผศ.สิวาลัย จินเจอ" ,"ผศ.ดร.สุภาพรณ์ ซิ้นเจริญ" ,"ผศ.พีระศักดิ์ เสรีกุล" ,"ผศ.สุปิติ กุลจันทร์" ,"ผศ.ดร.นัฎฐพันธ์ นาคพงษ์" ,"ผศ.ดร.บีสุดา ดาวเรือง" ,"ผศ.ดร.อนิราช มิ่งขวัญ" ,"ผศ.สมชัย เชียงพงศ์พันธุ์" ,
            "ผศ.ดร.ยุพิน สรรพคุณ" ,"ผศ.อรบุษป์ วุฒิกมลชัย" ,"อ.ดร.ประดิษฐ์ พิทักษ์เสถียรกุล" ,"ผศ.นิมิต ศรีคำทา" ,"ผศ.นพดล บูรณ์กุศล" ,"อ.ดร.วัชรชัย คงศิริวัฒนา" ,"ผศ.นิติการ นาคเจือทอง" ,"ผศ.นพเก้า ทองใบ" ,"อ.ดร.ศรายุธ ธเนศกุลวัฒนา" ,"อ.ดร.ศิรินทรา แว่วศรี" ,"อ.ดร.กาญจน์ ณ ศรีธะ" ,"นายไกรมิตร พงษ์นิยะกูล" ,
            "นายกฤษณ์ เผือกงาม" ,"นางลัดดา ตั้งเกียรติศิริ" ,"นางอุไรวรรณ วัตรยิ่ง" ,"นายวิวัช รุ่งสว่าง" };

    String[] rank = {"หัวหน้าภาควิชา" ,"อาจารย์ทำหน้าที่ธุรการ ด้านวิจัย" ,"อาจารย์ทำหน้าที่ธุรการ ด้านวิชาการ" ,"อาจารย์ทำหน้าที่ธุรการ ด้านกิจการนักศึกษา" ,"อาจารย์ทำหน้าที่ธุรการ ด้านงานประกัน คุณภาพการศึกษา" ,"รองอธิการบดี วิทยาเขตปราจีนบุรี" ,"รองคณบดี ฝ่ายสื่อสารองค์กรและ อุตสาหกรรมสัมพันธ์" ,
            "รองคณบดี ฝ่ายกิจการพิเศษ" ,"ผู้ช่วยผู้อำนวยการ ฝ่ายเทคโนโลยีสารสนเทศ วิทยาเขตปราจีนบุรี" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,
            "อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"อาจารย์ในภาควิชา" ,"เจ้าหน้าที่ในภาควิชา" ,"เจ้าหน้าที่ในภาควิชา" ,"เจ้าหน้าที่ในภาควิชา" ,"เจ้าหน้าที่ในภาควิชา"  ,"เจ้าหน้าที่ในภาควิชา"  };

    String[] email = {"khanista.n@itm.kmutnb.ac.th" ,"wanthanee.p@itm.kmutnb.ac.th" ,"pafan.d@itm.kmutnb.ac.th" ,"siwalai.s@itm.kmutnb.ac.th" ,"supaporn.s@itm.kmutnb.ac.th" ,"peerasak.s@itm.kmutnb.ac.th" ,"supeeti.k@itm.kmutnb.ac.th",
            "nuttapun.n@itm.kmutnb.ac.th" ,"beesuda.d@itm.kmutnb.ac.th" ,"anirach.m@itm.kmutnb.ac.th" ,"somchai.c@itm.kmutnb.ac.th" ,"yupin.s@itm.kmutnb.ac.th" ,"oraboot.w@itm.kmutnb.ac.th" ,"pradit.p@itm.kmutnb.ac.th" ,"nimit.s@itm.kmutnb.ac.th" ,
            "noppadon.b@itm.kmutnb.ac.th" ,"watcharachai.k@itm.kmutnb.ac.th" ,"nitigan.n@itm.kmutnb.ac.th" ,"nopphagaw.t@itm.kmutnb.ac.th" ,"sarayoot.t@itm.kmutnb.ac.th" ,"sirintra.v@itm.kmutnb.ac.th" ,"karn.n@itm.kmutnb.ac.th" ,
            "kaimit.p@itm.kmutnb.ac.th"  ,"krit.p@itm.kmutnb.ac.th"  ,"ladda.t@itm.kmutnb.ac.th"  ,"uraiwan.w@itm.kmutnb.ac.th" ,"wivach.r@itm.kmutnb.ac.th" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel);
        recyclerView = findViewById(R.id.recycl_per);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Personnel.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        perDataClassList = new ArrayList<PerDataClass>();
        for (int i = 0 ; i < name.length ; i++){
            perDataClass = new PerDataClass(name[i],rank[i],email[i],image_src[i]);
            perDataClassList.add(perDataClass);
        }
        adaterPer = new MyAdaterPer(Personnel.this,perDataClassList);
        recyclerView.setAdapter(adaterPer);
        bottomNavigationView = findViewById(R.id.bottomNavigativeView);
        bottomNavigationView.setSelected(false);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home){
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                finish();
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