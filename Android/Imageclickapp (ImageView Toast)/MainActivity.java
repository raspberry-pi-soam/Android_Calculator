package com.example.imageclickapp; // Double-check this matches your package name

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize the ImageView
        ImageView imageView = findViewById(R.id.myImageView);

        // 2. Set the Click Listener
        imageView.setOnClickListener(v -> {
            // 3. Display the Toast message
            Toast.makeText(MainActivity.this, "Image clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}