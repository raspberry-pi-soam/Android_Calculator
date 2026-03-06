package com.example.animallistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    // 10 Animals
    String[] animals = {
            "Dog", "Cat", "Elephant", "Lion", "Tiger",
            "Horse", "Cow", "Monkey", "Deer", "Rabbit"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewAnimals);


        // Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                animals
        );

        listView.setAdapter(adapter);

        // Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedAnimal = animals[position];
                Toast.makeText(MainActivity.this,
                        "You selected: " + selectedAnimal,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
