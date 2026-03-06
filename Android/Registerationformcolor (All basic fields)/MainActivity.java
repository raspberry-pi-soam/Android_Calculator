package com.example.registerationformcolor;

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

        // 1. MUST Initialize Views (Link Java to XML)
        rootLayout = findViewById(R.id.main_layout_id);
        etUsername = findViewById(R.id.etFullName); // Use the ID you set in XML
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        // 2. Call the method to apply colors
        applyCustomColors();

        // 3. Handle the Submit Action
        btnSubmit.setOnClickListener(v -> {
            String successMsg = getString(R.string.btn_submit) + " Successful!";
            Toast.makeText(this, successMsg, Toast.LENGTH_SHORT).show();
        });
    }

    /**
     * Applies the light background and contrasting button color.
     */
    private void applyCustomColors() {
        // Double-check: Ensure these IDs exist in colors.xml
        int lightColor = ContextCompat.getColor(this, R.color.form_background_light);
        rootLayout.setBackgroundColor(lightColor);

        int contrastColor = ContextCompat.getColor(this, R.color.submit_button_primary);
        btnSubmit.setBackgroundColor(contrastColor);
        btnSubmit.setTextColor(Color.WHITE);
    }
}