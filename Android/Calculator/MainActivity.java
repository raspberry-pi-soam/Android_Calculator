package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String currentInput = "";
    private double firstValue = 0.0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        // --- Setup Operator Buttons ---
        setOperatorListener(R.id.btnAdd, "+");
        setOperatorListener(R.id.btnSub, "-");
        setOperatorListener(R.id.btnMul, "*");
        setOperatorListener(R.id.btnDiv, "/");
        setOperatorListener(R.id.btnMod, "%");

        // --- Setup Functional Buttons ---
        // Clear Button (C)
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            currentInput = "";
            firstValue = 0.0;
            operator = "";
            tvResult.setText("0");
        });

        // Delete Button (DEL)
        findViewById(R.id.btnDel).setOnClickListener(v -> {
            if (currentInput.length() > 0) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                tvResult.setText(currentInput.isEmpty() ? "0" : currentInput);
            }
        });

        // Equals Button (=)
        findViewById(R.id.btnEqual).setOnClickListener(v -> calculateResult());
    }

    // Helper method to handle Number clicks (linked via XML 'onClick')
    public void onDigitClick(View view) {
        Button btn = (Button) view;
        currentInput += btn.getText().toString();
        tvResult.setText(currentInput);
    }

    // Helper to set listeners for math operators
    private void setOperatorListener(int btnId, String op) {
        findViewById(btnId).setOnClickListener(v -> {
            if (!currentInput.isEmpty()) {
                firstValue = Double.parseDouble(currentInput);
                operator = op;
                currentInput = ""; // Clear input for the second number
            }
        });
    }

    private void calculateResult() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondValue = Double.parseDouble(currentInput);
            double result = 0.0;

            switch (operator) {
                case "+": result = firstValue + secondValue; break;
                case "-": result = firstValue - secondValue; break;
                case "*": result = firstValue * secondValue; break;
                case "/": result = firstValue / secondValue; break;
                case "%": result = firstValue % secondValue; break;
            }

            // Update display and reset for next operation
            tvResult.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }
}