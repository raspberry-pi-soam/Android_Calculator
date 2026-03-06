package com.example.lifecyclelogger; // TODO: Check your package name

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Tag for filtering logs in Android Studio
    private static final String TAG = "LifecycleEvent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() called: Activity Initialized");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called: Activity is becoming visible");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called: Activity is interactive (Top of stack)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called: User is leaving (or app partially obscured)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called: Activity is no longer visible");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called: Activity returning from stopped state");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called: Activity is being destroyed");
    }
}