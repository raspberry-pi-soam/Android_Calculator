package com.example.datapassingapp; // TODO: Check your package name

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    private EditText etInput;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Bind Views (These IDs match activity_main.xml)
        etInput = findViewById(R.id.etInput);
        btnSend = findViewById(R.id.btnSend);

        // 2. Set Button Click Listener
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the string from the EditText
                String message = etInput.getText().toString();

                // Create the Intent object (From Here -> To SecondActivity)
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Pass the data (Key: "USER_MESSAGE", Value: message)
                intent.putExtra("USER_MESSAGE", message);

                // Start the new activity
                startActivity(intent);
            }
        });
    }
}