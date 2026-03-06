package com.example.eventlistenerapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusTextView = findViewById(R.id.statusTextView);
        Button btn = findViewById(R.id.eventButton);
        ImageView img = findViewById(R.id.eventImage);
        EditText editText = findViewById(R.id.eventEditText);

        // --- 1. Button Listeners ---
        btn.setOnClickListener(v -> statusTextView.setText("Button: Single Click Detected"));

                btn.setOnLongClickListener(v -> {
                    statusTextView.setText("Button: Long Click Detected");
                    return true; // Return true to consume the event
                });

        // --- 2. Image Touch Listener (Motion Events) ---
        img.setOnTouchListener((v, event) -> {
            int action = event.getActionMasked();

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    statusTextView.setText("Image: Action Down (Touch Started)");
                    break;
                case MotionEvent.ACTION_UP:
                    statusTextView.setText("Image: Action Up (Touch Released)");
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    statusTextView.setText("Image: Action Pointer Down (Multi-touch)");
                    break;
            }
            return true; // Consuming the touch event
        });

        // --- 3. EditText Key Listener (Enter Key) ---
        editText.setOnKeyListener((v, keyCode, event) -> {
            // We check for ACTION_DOWN so it only triggers once per press
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode ==
                    KeyEvent.KEYCODE_ENTER) {
                statusTextView.setText("EditText: Enter Key Pressed");
                return true;
            }
            return false;
        });
    }
}