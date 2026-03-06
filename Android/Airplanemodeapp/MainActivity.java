package com.example.airplanemodeapp; // TODO: Check your package name
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AirplaneModeReceiver airplaneModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the receiver
        airplaneModeReceiver = new AirplaneModeReceiver();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 1. Create an IntentFilter for Airplane Mode
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        // 2. Register the receiver dynamically
        // This is required for Android 8.0 (Oreo) and above
        registerReceiver(airplaneModeReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 3. Unregister the receiver to save battery and prevent crashes
        if (airplaneModeReceiver != null) {
            unregisterReceiver(airplaneModeReceiver);
        }
    }
}