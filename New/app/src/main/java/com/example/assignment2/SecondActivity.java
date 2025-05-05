package com.example.assignment2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class SecondActivity extends AppCompatActivity {
    private YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.gameYoutube);
        YouTubePlayerView youTubePlayerView2 = findViewById(R.id.gameYoutube2);
        getLifecycle().addObserver(youTubePlayerView);
        Button button2 = findViewById(R.id.button2);


        //將MyAdapter的三隻遊戲資料帶過來
        Bundle bundle = getIntent().getExtras();
        int game1 = bundle.getInt("game1");
        int game2 = bundle.getInt("game2");
        int game3 = bundle.getInt("game3");

        ImageView gameCover = findViewById(R.id.gameCover);

        TextView gameTtile1 = findViewById(R.id.gameTitle1);
        TextView gameInfo1 = findViewById(R.id.gameInfo1);
        TextView wwtbamTitle = findViewById(R.id.wwtbamTitle);
        TextView wwtbamId = findViewById(R.id.wwtbamId);

        //三隻遊戲帶進去不同的介紹
        if (game1 == 1) {
            gameCover.setImageResource(R.drawable.wwtbamgamestart);
            gameTtile1.setText("百萬富翁");
            gameInfo1.setText("百萬富翁 是一個源自英國獨立電視台的電視遊戲節目，。參賽者需要正確回答連續15條4選1的多項選擇題，若能全部答對，將可以獲得一筆巨額獎金，通常是100萬當地貨幣。");
            wwtbamTitle.setText("遊戲玩法");
            wwtbamId.setText("首先本遊戲中有四條問題， 每條問題有四個選項，參賽者必須回答問題挑選正確答案，從而獲得積分。 獲得積分後，參加者會有一個機會去轉老虎機， 從而獲得加乘分數");
            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(YouTubePlayer youTubePlayer) {
                    String videoID = "RlTvpLjSknI";
                    youTubePlayer.loadVideo(videoID, 0);

                }
            });
            youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(YouTubePlayer youTubePlayer) {
                    String videoID = "twPFaqrqjVs";
                    youTubePlayer.loadVideo(videoID,0);
                }
            });

        } else if (game2 == 2) {

        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}