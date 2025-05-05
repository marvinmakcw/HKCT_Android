package com.example.assignment2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class mcq extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private ImageView fifty;
    private ImageView phone;
    private TextView textQuestionScore;
    private boolean usedfifty = false;
    private boolean usedphone = false;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    final Handler handler = new Handler();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcq);



        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        textQuestionScore = (TextView)findViewById(R.id.textQuestionScore);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        fifty = (ImageView) findViewById(R.id.img_fifty);
        phone = (ImageView) findViewById(R.id.img_phone);






        updateQuestion(); //讀取題目及更新題目

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //答對題目按鈕會變為綠色
                if (mButtonChoice1.getText() == mAnswer){
                    mButtonChoice1.setBackgroundResource(R.drawable.textview_green);
                    addScore(mScore);  //答對獎金
                }else {
                    //答錯題目按鈕會變為紅色
                    correctAnswer();
                    mButtonChoice1.setBackgroundResource(R.drawable.textview_red);
                    minusScore(mScore); //扣減獎金
                }

                //答題後有2秒時間禁用答題及錦囊的按鈕
                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                fifty.setEnabled(false);
                phone.setEnabled(false);
                delay();
            }
        });


        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //答對題目按鈕會變為綠色
                if (mButtonChoice2.getText() == mAnswer){
                    mButtonChoice2.setBackgroundResource(R.drawable.textview_green);
                    addScore(mScore); //增加獎金
                }else {
                    //答錯題目按鈕會變為紅色
                    correctAnswer();
                    mButtonChoice2.setBackgroundResource(R.drawable.textview_red);
                    minusScore(mScore); //扣減獎金
                }

                //答題後有2秒時間禁用答題及錦囊的按鈕
                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                fifty.setEnabled(false);
                phone.setEnabled(false);
                delay();
            }
        });


        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //答對題目按鈕會變為綠色
                if (mButtonChoice3.getText() == mAnswer){
                    mButtonChoice3.setBackgroundResource(R.drawable.textview_green);
                    addScore(mScore); //增加獎金

                }else {
                    //答錯題目按鈕會變為紅色
                    correctAnswer();
                    mButtonChoice3.setBackgroundResource(R.drawable.textview_red);
                    minusScore(mScore); //扣減獎金
                }
                //答題後有2秒時間禁用答題及錦囊的按鈕
                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                fifty.setEnabled(false);
                phone.setEnabled(false);
                delay();
            }
        });


        mButtonChoice4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //答對題目按鈕會變為綠色
                if (mButtonChoice4.getText() == mAnswer){
                    mButtonChoice4.setBackgroundResource(R.drawable.textview_green);
                    addScore(mScore);//增加獎金
                }else {
                    //答錯題目按鈕會變為紅色
                    correctAnswer();
                    mButtonChoice4.setBackgroundResource(R.drawable.textview_red);
                    minusScore(mScore); //扣減獎金
                }
                //答題後有2秒時間禁用答題及錦囊的按鈕
                mButtonChoice1.setEnabled(false);
                mButtonChoice2.setEnabled(false);
                mButtonChoice3.setEnabled(false);
                mButtonChoice4.setEnabled(false);
                fifty.setEnabled(false);
                phone.setEnabled(false);
                delay();
            }
        });


        //5050錦囊
        fifty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                int randomWrongAnswer = new Random().nextInt(3); //隨機數字0-2
                usedfifty = true;
                //將兩個錯誤的答案隱藏
                if (mButtonChoice1.getText() == mAnswer){
                    switch (randomWrongAnswer){
                        case 0:
                            mButtonChoice2.setVisibility(View.INVISIBLE);
                            mButtonChoice3.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            mButtonChoice2.setVisibility(View.INVISIBLE);
                            mButtonChoice4.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            mButtonChoice3.setVisibility(View.INVISIBLE);
                            mButtonChoice4.setVisibility(View.INVISIBLE);
                            break;
                    }
                }else if (mButtonChoice2.getText() == mAnswer){
                    switch (randomWrongAnswer) {
                        case 0:
                            mButtonChoice1.setVisibility(View.INVISIBLE);
                            mButtonChoice3.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            mButtonChoice1.setVisibility(View.INVISIBLE);
                            mButtonChoice4.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            mButtonChoice3.setVisibility(View.INVISIBLE);
                            mButtonChoice4.setVisibility(View.INVISIBLE);
                            break;
                    }
                }else if (mButtonChoice3.getText() == mAnswer) {
                    switch (randomWrongAnswer) {
                        case 0:
                            mButtonChoice1.setVisibility(View.INVISIBLE);
                            mButtonChoice2.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            mButtonChoice1.setVisibility(View.INVISIBLE);
                            mButtonChoice4.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            mButtonChoice2.setVisibility(View.INVISIBLE);
                            mButtonChoice4.setVisibility(View.INVISIBLE);
                            break;
                    }
                }else {
                    switch (randomWrongAnswer) {
                        case 0:
                            mButtonChoice1.setVisibility(View.INVISIBLE);
                            mButtonChoice2.setVisibility(View.INVISIBLE);
                            break;
                        case 1:
                            mButtonChoice1.setVisibility(View.INVISIBLE);
                            mButtonChoice3.setVisibility(View.INVISIBLE);
                            break;
                        case 2:
                            mButtonChoice2.setVisibility(View.INVISIBLE);
                            mButtonChoice3.setVisibility(View.INVISIBLE);
                            break;
                    }
                }
                //將錦囊圖片變為已使用及禁用該按鈕
                fifty.setImageDrawable(getResources().getDrawable(R.drawable.fiftyused));
                fifty.setEnabled(false);
            }
        });

        //打電話錦囊
        phone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                usedphone = true;
                Uri number = Uri.parse("tel:67561838");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
                //將錦囊圖片變為已使用及禁用該按鈕
                phone.setImageDrawable(getResources().getDrawable(R.drawable.phoneused));
                phone.setEnabled(false);
            }
        });
    }


    private void updateQuestion(){
        if (mQuestionNumber < mQuestionLibrary.mQuestions.length) {
            //每次更新題目時會將答案顯示, 避免上一題使用錦囊後也只得兩個答案選擇
            mButtonChoice1.setVisibility(View.VISIBLE);
            mButtonChoice2.setVisibility(View.VISIBLE);
            mButtonChoice3.setVisibility(View.VISIBLE);
            mButtonChoice4.setVisibility(View.VISIBLE);

            //從問題庫中更新問題
            mQuestionView.setText("\n" + Integer.toString(mQuestionNumber+1) + ".  " + mQuestionLibrary.getQuestion(mQuestionNumber));  //從顯庫中更新問題
            //每題問題的加減獎金
            switch (mQuestionNumber){
                case 0:
                    textQuestionScore.setText("正確 +$100 錯誤 -$10");
                    break;
                case 1:
                    textQuestionScore.setText("正確 +$200 錯誤 -$20");
                    break;
                case 2:
                    textQuestionScore.setText("正確 +$300 錯誤 -$30");
                    break;
                case 3:
                    textQuestionScore.setText("正確 +$500 錯誤 -$50");
                    break;
                case 4:
                    textQuestionScore.setText("正確 +$1000 錯誤 -$100");
                    break;
            }
            //從四個選擇的答案中更新至答題按鈕
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));  //從顯庫中更新第一個選項的答案
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));  //從顯庫中更新第二個選項的答案
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));  //從顯庫中更新第三個選項的答案
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));  //從顯庫中更新第四個選項的答案

            //讀取正確的答案
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);  //從顯庫中獲得正確的答案
            mQuestionNumber++;

            //新增MediaPlayer元件，將它連結到想播放的音效檔
            MediaPlayer mp = MediaPlayer.create(this, R.raw.question);
            //播放音效
            mp.start();
        }
        else {
            //當問題已全部作答
            mQuestionView.setText("\n" + "恭喜！ 請進入老虎機將獎金翻倍");    //顯示所有題目已作答
            textQuestionScore.setVisibility(View.INVISIBLE);
            mButtonChoice1.setVisibility(View.INVISIBLE);  //選項一的按鈕隱藏
            mButtonChoice2.setVisibility(View.INVISIBLE);  //選項二的按鈕隱藏
            fifty.setVisibility(View.INVISIBLE); //隱藏錦囊
            phone.setVisibility(View.INVISIBLE);
            mButtonChoice3.setBackgroundResource(R.drawable.textview_black);
            mButtonChoice4.setBackgroundResource(R.drawable.textview_black);
            mButtonChoice3.setText("回首頁"); //變更按鈕為回到首頁
            mButtonChoice3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    startActivity(new Intent(com.example.assignment2.mcq.this, MainActivity.class));     //為回首頁按鈕設定轉頁動作
                }
            });
            mButtonChoice4.setText("進入老虎機"); //變更按鈕為進入老虎機
            mButtonChoice4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //將獎金儲存到money1並傳送及轉頁到老虎機畫面
                    Intent intent = new Intent(com.example.assignment2.mcq.this,SLActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("money1", mScore);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

        }

    }


    private void addScore(int point) {
        //根據題目而更改獲得的獎金
        switch (mQuestionNumber){
            case 1:
                mScore = mScore + 100;//100
                break;
            case 2:
                mScore = mScore + 200; //200
                break;
            case 3:
                mScore = mScore + 300; //300
                break;
            case 4:
                mScore = mScore + 500;//500
                break;
            case 5:
                mScore = mScore + 1000;//1000
                break;
        }
        mScoreView.setText("$" + mScore);//更新介面上顯示的分數

    }

    private void minusScore(int point) {
        //根據題目而更改扣減的獎金
        switch (mQuestionNumber){
            case 1:
                mScore = mScore - 10;//10
                break;
            case 2:
                mScore = mScore - 20; //20
                break;
            case 3:
                mScore = mScore - 30; //30
                break;
            case 4:
                mScore = mScore - 50;//50
                break;
            case 5:
                mScore = mScore - 100;//100
                break;
        }
        //獎金不會扣減至負數
        if (mScore < 0){
            mScore = 0;
        }
        mScoreView.setText("$" + mScore);//更新獎金


    }
    private void delay(){
        handler.postDelayed(new Runnable() {
            @SuppressLint("ResourceType")
            @Override
            public void run() {
                //更新問題並重啟答題按鈕
                updateQuestion();
                mButtonChoice1.setEnabled(true);
                mButtonChoice2.setEnabled(true);
                mButtonChoice3.setEnabled(true);
                mButtonChoice4.setEnabled(true);

                //將色彩變更為透明
                mButtonChoice1.setBackgroundColor(Color.TRANSPARENT);
                mButtonChoice2.setBackgroundColor(Color.TRANSPARENT);
                mButtonChoice3.setBackgroundColor(Color.TRANSPARENT);
                mButtonChoice4.setBackgroundColor(Color.TRANSPARENT);


                mButtonChoice1.setBackgroundResource(R.drawable.textview_black);
                mButtonChoice2.setBackgroundResource(R.drawable.textview_black);
                mButtonChoice3.setBackgroundResource(R.drawable.textview_black);
                mButtonChoice4.setBackgroundResource(R.drawable.textview_black);

                //如未使用錦囊, 廷遲2秒後將會重啟按鈕
                if (usedfifty == false){
                    fifty.setEnabled(true);
                }
                if (usedphone == false){
                    phone.setEnabled(true);
                }
                }
        }, 2000); //廷遲2秒
    }
    private void correctAnswer(){
        //答題後將正確答案按鈕變為綠色
        if (mButtonChoice1.getText() == mAnswer) {
            mButtonChoice1.setBackgroundResource(R.drawable.textview_green);
        }else if (mButtonChoice2.getText() == mAnswer){
            mButtonChoice2.setBackgroundResource(R.drawable.textview_green);
        }else if (mButtonChoice3.getText() == mAnswer){
            mButtonChoice3.setBackgroundResource(R.drawable.textview_green);
        }else mButtonChoice4.setBackgroundResource(R.drawable.textview_green);
    }
}

