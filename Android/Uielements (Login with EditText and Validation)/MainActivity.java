package com.example.uielements;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setting up Toolbar as AppBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Reference UI elements
        EditText et_user_name = findViewById(R.id.et_user_name);
        EditText et_password = findViewById(R.id.et_password);
        Button btnReset = findViewById(R.id.btn_reset);
        Button btnSubmit = findViewById(R.id.btn_submit);
        // Reset Button functionality
        btnReset.setOnClickListener(v -> {
            et_user_name.setText("");
            et_password.setText("");
        });
        // Submit Button functionality
        btnSubmit.setOnClickListener(v -> {
            // 1. Get the text and trim spaces
            String uname = et_user_name.getText().toString().trim();
            String pwd = et_password.getText().toString().trim();

            // 2. Validation: Check if Username is empty
            if (uname.isEmpty()) {
                et_user_name.setError("Username is required");
                et_user_name.requestFocus();
                return; // Stop code here
            }

            // 3. Validation: Check if Password is empty
            if (pwd.isEmpty()) {
                et_password.setError("Password is required");
                et_password.requestFocus();
                return; // Stop code here
            }

            // 4. If validation passes
            Toast.makeText(MainActivity.this, "Welcome " + uname, Toast.LENGTH_LONG).show();
        });
//        // Load Fragment dynamically
//        if (savedInstanceState == null) {
//            FragmentExample fragment = new FragmentExample();
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.fragment_container, fragment);
//            transaction.commit();
//        }
    }
}