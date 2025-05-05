/*黎文鍵LaiManKin MOS13 20809721
今次的功課2我選擇介紹三隻遊戲
首先用MyAdapter制作好我要用到既滑動圖案
在gameinfo_item設計
然後將整個設計好的圖案放回MainActivity.java
再將每個圖案設定好position再放進bundle帶去下一頁(SecondActivity)
然後每張圖按進去都會介紹相對的遊戲
最後也加上每隻遊戲在Youtube的trailer*/

package com.example.assignment2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //執行指令
    private ActionBar actionBar;

    //介面圖像
    private ViewPager viewPager;

    //定義
    WormDotsIndicator dot3;

    private ArrayList<MyGame> gameArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //加入 actionnbar 設定
        actionBar = getSupportActionBar();

        //加入波波
        dot3 = findViewById(R.id.dot3);

        //加入頁面資料
        viewPager = findViewById(R.id.viewPager);
        loadgameInfo();

        //設置 viewPager 改變的 listener
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //改變actionbar內容為title
                String title = gameArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadgameInfo() {
        //加入列表
        gameArrayList = new ArrayList<>();

        //加資料入列表
        gameArrayList.add(new MyGame(
                "百萬富翁",
                "《百萬富翁》（英語：Who Wants to Be a Millionaire?），因贊助關係，稱為《Rejoice特約：百萬富翁》，是一個2001年起香港亞洲電視播放的綜藝節目。",
                "首播時間:2001年4月30日",
                R.drawable.wwtbamdt));
        gameArrayList.add(new MyGame(
                "獎勵列表",
                " 獲得積分後，參加者會有一個機會去轉老虎機， 從而獲得加乘分數",
                "",
                R.drawable.slotmachine));
        gameArrayList.add(new MyGame(
                "開始遊戲",
                "",
                "",
                R.drawable.wwtbamgamestart));

        //設置函數
        myAdapter = new MyAdapter(this, gameArrayList);
        //設置函數去頁面資料
        viewPager.setAdapter(myAdapter);
        //設置默認padding從左/右
        viewPager.setPadding(100,0,100,0);
        //設置點
        dot3.setViewPager(viewPager);

    }
}