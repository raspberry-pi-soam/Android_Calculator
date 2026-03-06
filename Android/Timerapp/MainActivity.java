package com.example.timerapp;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTimer;
    Button btnStart, btnStop;

    Handler handler = new Handler();
    int seconds = 0;
    boolean isRunning = false;

    Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                seconds++;
                tvTimer.setText(String.valueOf(seconds));

                handler.postDelayed(this, 1000); // 1 second
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTimer = findViewById(R.id.tvTimer);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(v -> {
            if (!isRunning) {
                isRunning = true;
                handler.post(timerRunnable);
            }
        });
        btnStop.setOnClickListener(v -> {
            isRunning = false;
        });
    }
}
