package com.example.backgroundmusic; // TODO: Check your package name

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MusicService extends Service {

    private MediaPlayer player;

    @Override
    @Nullable
    public IBinder onBind(Intent intent) {
        // We are not binding to an activity, so return null
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 1. Create the MediaPlayer logic
        if (player == null) {
            // Use the default system ringtone
            player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            player.setLooping(true); // Loop the music
        }

        // 2. Start the player if it's not already playing
        if (!player.isPlaying()) {
            player.start();
            Toast.makeText(this, "Music Service Started", Toast.LENGTH_SHORT).show();
        }

        // START_STICKY ensures the service restarts if the system kills it
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 3. Cleanup: Stop and release the player when service is stopped
        if (player != null) {
            if (player.isPlaying()) {
                player.stop();
            }
            player.release();
            player = null;
        }
        Toast.makeText(this, "Music Service Stopped", Toast.LENGTH_SHORT).show();
    }
}