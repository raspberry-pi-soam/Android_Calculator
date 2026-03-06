package com.example.airplanemodeapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {

            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            String message = isAirplaneModeOn ? "Airplane Mode is ON " : "Airplane Mode is OFF ";

            // Call our custom helper method for a 10-second Toast
            showCustomDurationToast(context, message, 10000);
        }
    }

    // Helper method to keep a Toast visible for a specific duration (in milliseconds)
    private void showCustomDurationToast(Context context, String message, int
            durationInMillis) {
        final Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);

        // Create a timer that updates the toast every 1 second (1000ms)
        new CountDownTimer(durationInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                // Keep showing the toast to prevent it from fading out
                toast.show();
            }

            public void onFinish() {
                // Ensure the toast disappears when time is up
                toast.cancel();
            }
        }.start();
    }
}