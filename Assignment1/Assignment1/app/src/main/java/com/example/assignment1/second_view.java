package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class second_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);

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
                Toast.makeText(second_view.this,"Today is "+ today, Toast.LENGTH_SHORT).show();
            }
        });

        //按下頂端工具欄右邊圖示會轉去資訊頁面
        ImageView aboutIcon = findViewById(R.id.about_icon);
        aboutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_view.this,about.class);
                startActivity(intent);
            }
        });

        /*接收從第一頁所傳遞的資料
        顯示顧客選擇的套餐及定義價錢*/
        ImageView image = findViewById(R.id.imageViewBurger3);
        TextView textViewSelect = findViewById(R.id.textViewSelect3);
        TextView textViewPrice = findViewById(R.id.textViewPrice);
        TextView textViewDiscount2 = findViewById(R.id.textViewDiscount2);
        Bundle bundle = getIntent().getExtras();
        int select = bundle.getInt("burger");
        double price = 0.0;
        double discount = bundle.getDouble("discount");

        String[] burger = getResources().getStringArray(R.array.burger);
        textViewSelect.setText("You have selected：" + burger[select]);
        switch (select) {
            case 0:
                image.setImageResource(R.drawable.set1);
                price = 15.5;
                break;
            case 1:
                image.setImageResource(R.drawable.set2);
                price = 17.5;
                break;
            case 2:
                image.setImageResource(R.drawable.set3);
                price = 20.0;
                break;
            case 3:
                image.setImageResource(R.drawable.set4);
                price = 23.5;
                break;
            case 4:
                image.setImageResource(R.drawable.set5);
                price = 25.0;
                break;

        }


        //按下確認按鈕後會轉去感謝感謝顧客購買的頁面
        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_view.this,confirm_page.class);
                startActivity(intent);
            }
        });

        //顯示顧客所得的折扣及扣除折扣後的價錢
        textViewDiscount2.setText("You get " + String.format("%.0f",((1-discount))*100) + "%OFF");
        textViewPrice.setText("Total: " + String.format("%.1f", discount*price));

        //按下返回按鈕後會回到第一頁讓顧客重新選擇套餐或輸入優惠碼
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_view.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

}