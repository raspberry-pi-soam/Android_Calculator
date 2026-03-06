package com.example.practical2r;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openColorActivity(View view) {
        startActivity(new Intent(this, ColorActivity.class));
    }
    public void openThemeActivity(View view) {
        startActivity(new Intent(this, ThemeActivity.class));
    }
    public void openStringActivity(View view) {
        startActivity(new Intent(this, StringActivity.class));
    }
    public void openDrawableActivity(View view) {
        startActivity(new Intent(this, DrawableActivity.class));
    }
    public void openDimensionActivity(View view) {
        startActivity(new Intent(this, DimensionActivity.class));
    }
}