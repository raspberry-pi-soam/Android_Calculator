package com.example.submenuapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // THIS METHOD MAKES THE MENU APPEAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // This 'main_menu' refers to your res/menu/main_menu.xml file
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // THIS METHOD HANDLES THE SUB-MENU CLICKS
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Matching IDs from your main_menu.xml screenshot
        if (id == R.id.sub_english) {
            Toast.makeText(this, "English Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.sub_hindi) {
            Toast.makeText(this, "Hindi Selected", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.sub_marathi) {
            Toast.makeText(this, "Marathi Selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}