package com.example.imagechanger; // TODO: Check your package name

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare View variables
    private TextView tvStatus;
    private ImageView ivDisplay;
    private Button btnChange;

    // Flag to track which image is currently showing
    private boolean isImageOne = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize Views
        tvStatus = findViewById(R.id.tvStatus);
        ivDisplay = findViewById(R.id.ivDisplay);
        btnChange = findViewById(R.id.btnChange);

        // 2. Set Button Click Listener
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isImageOne) {
                    // Switch to second image
                    ivDisplay.setImageResource(R.drawable.image_two);
                    tvStatus.setText("Current Image: Two");
                    isImageOne = false; // Update flag
                } else {
                    // Switch back to first image
                    ivDisplay.setImageResource(R.drawable.image_one);
                    tvStatus.setText("Current Image: One");
                    isImageOne = true; // Update flag
                }
            }
        });
    }
}