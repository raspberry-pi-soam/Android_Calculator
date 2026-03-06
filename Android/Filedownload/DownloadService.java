package com.example.filedownload;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class DownloadService extends Service {

    private static final String CHANNEL_ID = "download_channel";
    private static final int NOTIFICATION_ID = 1;

    private NotificationManager notificationManager;
    private NotificationCompat.Builder builder;

    @Override
    public void onCreate() {
        super.onCreate();

        notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Create Notification Channel (Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "File Downloads",
                    NotificationManager.IMPORTANCE_LOW
            );
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.stat_sys_download)
                .setContentTitle("Downloading File")
                .setContentText("In progress...")
                .setOngoing(true)
                .setProgress(100, 0, false);

        // Start as Foreground Service
        startForeground(NOTIFICATION_ID, builder.build());

        // Simulate background download
        new Thread(() -> {
            for (int i = 0; i <= 100; i += 10) {
                try {
                    Thread.sleep(1000);

                    builder.setProgress(100, i, false)
                            .setContentText("Downloaded: " + i + "%");

                    notificationManager.notify(NOTIFICATION_ID, builder.build());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Update Notification on Completion
            builder.setContentText("Download Complete")
                    .setProgress(0, 0, false)
                    .setOngoing(false)
                    .setSmallIcon(android.R.drawable.stat_sys_download_done);

            notificationManager.notify(NOTIFICATION_ID, builder.build());

            stopForeground(false);
            stopSelf();

        }).start();

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}