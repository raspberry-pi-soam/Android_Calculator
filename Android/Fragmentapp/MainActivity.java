package com.example.fragmentapp;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSendToFragment);

        btnSend.setOnClickListener(v -> {
            // 1. Create the Fragment instance
            DisplayFragment fragment = new DisplayFragment();

            // 2. Prepare the data in a Bundle
            Bundle bundle = new Bundle();
            bundle.putString("msg_key", "Hello from Activity!");
            fragment.setArguments(bundle);

            // 3. Perform the Fragment Transaction
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        });
    }
}