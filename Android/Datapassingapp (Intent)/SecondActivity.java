package com.example.datapassingapp; // TODO: Check your package name

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 1. Bind View (Matches activity_second.xml)
        tvResult = findViewById(R.id.tvResult);

        // 2. Get the Intent that started this activity
        Intent intent = getIntent();

        // 3. Extract the string using the same Key "USER_MESSAGE"
        if (intent != null) {
            String receivedText = intent.getStringExtra("USER_MESSAGE");

            // Set the text to the TextView
            tvResult.setText(receivedText);
        }
    }
}