/*MAK CHI WANG 20819845
此程式是一個點餐程式 顧客能選擇五個套餐中的其中一個
輸入10OFF能有九折優惠 輸入今天日期能有八折優惠(1月1日 = 0101)
輸入正確優惠碼後按下單 頁面會顯示折扣後價錢
確認下單後 會有動態圖示感謝顧客購買 並在3秒後右下方會有八折優惠的提示
按頂端工具欄左邊圖示能顯示今天日期 按右邊圖示後貢面會有不同的資訊可供查詢
*/
package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Toast.makeText(MainActivity.this,"Today is "+ today, Toast.LENGTH_SHORT).show();
            }
        });

        //按下頂端工具欄右邊圖示會轉去資訊頁面
        ImageView aboutIcon = findViewById(R.id.about_icon);
        aboutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,about.class);
                startActivity(intent);
            }
        });

        //定義沒有折扣時 價錢*1
        final double[] discount = {1};
        Spinner spinner = findViewById(R.id.spinnerSelect);
        ImageView image = findViewById(R.id.imageViewBurger);

        TextView select = findViewById(R.id.textViewSelect);
        String selecttext = "Please select your BURGER";
        SpannableString ss = new SpannableString(selecttext);

        //更改文字及背景顏色
        ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
        BackgroundColorSpan bcsBlack = new BackgroundColorSpan(Color.BLACK);

        ss.setSpan(fcsRed, 19, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(bcsBlack, 19, 25, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new RelativeSizeSpan(2f),19, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        select.setText(ss);

        //當在下拉式選單選擇不同套餐時 上面圖示會跟著改變為該套餐
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        image.setImageResource(R.drawable.set1);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.set2);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.set3);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.set4);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.set5);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        /*輸入今天日期會顯示有8折, 價錢*0.8
          輸入10OFF會顯示有9折, 價錢*0.9
          輸入錯誤會顯示輸入錯誤優惠碼 */
        Button btnCode = (Button)findViewById(R.id.buttonCode);
        btnCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inputCode = (EditText)findViewById(R.id.inputCode);
                TextView textViewDiscount = findViewById(R.id.textViewDiscount);
                String Code = inputCode.getText().toString();

                if (Code.equals(today)){
                    textViewDiscount.setText("You will get 20% OFF");
                    discount[0] = 0.8;
                }else if (Code.equals("10OFF")){
                    textViewDiscount.setText("You will get 10% OFF");
                   discount[0] = 0.9;
                }else textViewDiscount.setText("Sorry, your code is invalid.");
            }
        });

        /*按下單按鈕後會轉去確認頁面並傳遞資料
        包括顧客所選擇的套餐及折扣*/
        Button btnOrder = (Button)findViewById(R.id.buttonOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = spinner.getSelectedItemPosition();
                Intent intent = new Intent(MainActivity.this,second_view.class);
                Bundle bundle = new Bundle();
                bundle.putInt("burger",i);
                bundle.putDouble("discount", discount[0]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}