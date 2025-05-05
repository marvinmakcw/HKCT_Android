package com.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.ArrayList;
import static androidx.core.app.ActivityCompat.startActivityForResult;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<MyGame> gameArrayList;

    //所建立的函數
    public MyAdapter(Context context, ArrayList<MyGame> gameArrayList) {
        this.context = context;
        this.gameArrayList = gameArrayList;
    }

    private int[] images = {R.drawable.nioh, R.drawable.darksouls3, R.drawable.bloodborne};


    @Override
    public int getCount() {
        return gameArrayList.size();//返回列表裡的物件大小
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //轉換 layout gameinfo.xml
        View view = LayoutInflater.from(context).inflate(R.layout.gameinfo_item, container, false);

        //加入圖片 layout gameinfo.xml
        ImageView gameTitlepage = view.findViewById(R.id.gameTitlepage);
        gameTitlepage.setImageResource(images[position]);
        container.addView(view);
        TextView gameTitle = view.findViewById(R.id.gameTitle);
        TextView gameDescription = view.findViewById(R.id.gameDescription);
        TextView issueOfdate = view.findViewById(R.id.issueOfdate);

        //取得數據
        MyGame game = gameArrayList.get(position);
        String gTitle = game.getTitle();
        String gDescription = game.getDescription();
        String date = game.getDate();
        int image = game.getImage();

        //設定數據
        gameTitlepage.setImageResource(image);
        gameTitle.setText(gTitle);
        gameDescription.setText(gDescription);
        issueOfdate.setText(date);

        //按下後搬運的數據或出現下面小灰格
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, gTitle, Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    Intent intent = new Intent(context.getApplicationContext(), SecondActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game1", 1);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(context.getApplicationContext(), PrizeList.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game2", 2);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(context.getApplicationContext(), mcq.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("game3", 3);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            }
        });

        //增加圖片
        container.addView(view, position);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
