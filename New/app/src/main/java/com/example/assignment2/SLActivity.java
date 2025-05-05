package com.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SLActivity extends AppCompatActivity {

    private TextView msg;
    private ImageView img1, img2, img3;
    private Wheel wheel1, wheel2, wheel3;
    private Button btn;
    private boolean isStarted;



    public static final Random RANDOM = new Random();

    public static long randomLong(long lower, long upper) {
        return lower + (long) (RANDOM.nextDouble() * (upper - lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sl);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);

        msg = (TextView) findViewById(R.id.msg);

        Bundle bundle = getIntent().getExtras();
        int money1 = bundle.getInt("money1");

        TextView money = findViewById(R.id.money);
        money.setText(" $ " + money1);






            btn = (Button) findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isStarted) {
                        wheel1.stopWheel();
                        wheel2.stopWheel();
                        wheel3.stopWheel();


                        if (wheel1.currentIndex == wheel2.currentIndex && wheel2.currentIndex == wheel3.currentIndex) {
                            msg.setText("恭喜！你贏得大獎！你的獎金將會 X 3    " + "\n" + " 總共獲得 $ " + money1 * 3);
                        } else if (wheel1.currentIndex == wheel2.currentIndex || wheel2.currentIndex == wheel3.currentIndex
                                || wheel1.currentIndex == wheel3.currentIndex) {
                            msg.setText("恭喜！你的獎金將會 X 2   " + "\n" + " 總共獲得 $ " + money1 * 2);
                        } else {
                            msg.setText("可惜！獎金不變" + "\n" + " 總共獲得 $ " + money1);
                        }

                        btn.setText("回首頁");

                        isStarted = false;
                        if (isStarted == false){
                            btn.setOnClickListener(new View.OnClickListener(){
                                @Override
                                public void onClick(View view){
                                    startActivity(new Intent(com.example.assignment2.SLActivity.this, MainActivity.class));
                                }
                            });
                        }

                    } else {

                        wheel1 = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        img1.setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(0, 200));

                        wheel1.start();

                        wheel2 = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        img2.setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        wheel2.start();

                        wheel3 = new Wheel(new Wheel.WheelListener() {
                            @Override
                            public void newImage(final int img) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        img3.setImageResource(img);
                                    }
                                });
                            }
                        }, 200, randomLong(150, 400));

                        wheel3.start();


                        btn.setText("停止");
                        msg.setText("");
                        isStarted = true;

                    }
                }
            });

        }

}
