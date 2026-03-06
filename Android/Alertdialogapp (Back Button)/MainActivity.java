package com.example.alertdialogapp;

import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a callback to handle the back button press
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        };

        // Add the callback to the dispatcher
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    private void showExitDialog() {
        // Build the Alert Dialog
        new AlertDialog.Builder(this)
                .setTitle("Exit Application")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false) // Prevent closing by clicking outside
                .setPositiveButton("Yes", (dialog, which) -> {
                    // User clicked Yes, so close the activity
                    finish();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    // User clicked No, so just close the dialog
                    dialog.dismiss();
                })
                .show();
    }
}