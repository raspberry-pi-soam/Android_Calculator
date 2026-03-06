package com.example.genderform; // Ensure this matches your package name

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup genderRadioGroup;
    private Button btnSubmit;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Views
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        btnSubmit = findViewById(R.id.btnSubmitGender);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(v -> {
            // 1. Get the ID of the selected RadioButton
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                // No radio button was checked
                Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            } else {
                // 2. Find the RadioButton by the ID
                RadioButton selectedRadioButton = findViewById(selectedId);

                // 3. Get the text of that RadioButton
                String gender = selectedRadioButton.getText().toString();

                // 4. Update the TextView
                tvResult.setText("Selected Gender: " + gender);
            }
        });
    }
}