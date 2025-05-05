package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class confirm_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_page);

        //隱藏動作欄
        getSupportActionBar().hide();

        //設定今天日期 以(月月日日)作為格式
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("MMdd", Locale.getDefault());
        String today = df.format(c);

        //按下頂端工具欄左邊圖示會彈出今天日期
        ImageView todayIcon = findViewById(R.id.today_icon);
        todayIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(confirm_page.this,"Today is "+ today, Toast.LENGTH_SHORT).show();
            }
        });

        //按下頂端工具欄右邊圖示會轉去資訊頁面
        ImageView aboutIcon = findViewById(R.id.about_icon);
        aboutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirm_page.this,about.class);
                startActivity(intent);
            }
        });

        //動態圖示感謝感謝顧客購買
        TextView textViewCode20 = findViewById(R.id.textViewCode20);
        GifImageView image = findViewById(R.id.imageView);
        try {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.ty);
            image.setImageDrawable(gifDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3秒後右下方會有八折優惠的提示
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    textViewCode20.setText("20% OFF CODE : TODAY DATE (MMDD)\n 01 JAN enter *0101*");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 3000);

        //按下首頁按鈕後會回到第一頁讓顧客重新選擇套餐或輸入優惠碼
        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(confirm_page.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}