package com.example.listviewapp; // Ensure this matches your project package

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Data Source
    String[] names = {"Artem", "John", "Jane", "Alice", "Bob", "Charlie", "David"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize the ListView
        ListView listView = findViewById(R.id.nameListView);
// 2. Initialize the Adapter
// Parameters: Context, Layout for each row, Data source
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
// 3. Set the adapter to the ListView
        listView.setAdapter(adapter);
// 4. Handle item clicks (Optional but recommended)
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedName = names[position];
            Toast.makeText(this, "Clicked: " + selectedName, Toast.LENGTH_SHORT).show();
        });
    }
}