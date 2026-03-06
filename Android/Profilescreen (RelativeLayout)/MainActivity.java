package com.example.profilescreen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivProfile = findViewById(R.id.ivProfile);
        TextView tvName = findViewById(R.id.tvProfileName);
        Button btnEdit = findViewById(R.id.btnEditProfile);

        btnEdit.setOnClickListener(v -> {
            Toast.makeText(this, "Opening Profile Editor...", Toast.LENGTH_SHORT).show();
        });
    }
}
