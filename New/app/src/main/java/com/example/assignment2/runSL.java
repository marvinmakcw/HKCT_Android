package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class runSL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_s_l);

        Bundle bundle = getIntent().getExtras();
        int money1 = bundle.getInt("money1");

        ImageView runsl = findViewById(R.id.runsl);

        runsl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(runSL.this, SLActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("money1", money1);
                intent.putExtras(bundle);
                startActivity(intent);
                //隱藏閃爍
                overridePendingTransition(0, 0);

            }
        });
    }
}