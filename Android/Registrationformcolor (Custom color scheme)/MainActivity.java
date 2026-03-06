package com.example.registrationformcolor;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnSubmit;
    private LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        rootLayout = findViewById(R.id.main_layout_id); // Ensure this ID exists in yourXML root
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        // OPTIONAL: Set colors programmatically
        // (Use this if you want to override XML values dynamically)
        applyCustomColors();

        // Handle the Submit Action
        btnSubmit.setOnClickListener(v -> {
            String name = etUsername.getText().toString();
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Registration Successful for " + name,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Demonstrates how to apply the light background and
     * contrasting button color using Java code.
     */
    private void applyCustomColors() {
        // Setting the light background (Off-white)
        int lightColor = ContextCompat.getColor(this, R.color.form_background_light);
        rootLayout.setBackgroundColor(lightColor);

        // Setting the contrasting button color
        int contrastColor = ContextCompat.getColor(this, R.color.submit_button_primary);
        btnSubmit.setBackgroundColor(contrastColor);
        btnSubmit.setTextColor(Color.WHITE);
    }
}