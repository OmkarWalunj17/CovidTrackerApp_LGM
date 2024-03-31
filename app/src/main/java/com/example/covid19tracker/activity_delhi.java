package com.example.covid19tracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_delhi extends AppCompatActivity {

    private ListView delhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi);

        String[] delhiDistricts = {"Central Delhi", "East Delhi", "New Delhi", "North Delhi", "Northeast Delhi",
                "Northwest Delhi", "Shahdara", "South Delhi", "Southeast Delhi", "Southwest Delhi", "West Delhi"};

        delhi = findViewById(R.id.delhilist);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, delhiDistricts);
        delhi.setAdapter(adapter);
    }
}
