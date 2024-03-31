package com.example.covid19tracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_bihar extends AppCompatActivity {
    private ListView bihar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bihar);

        bihar = findViewById(R.id.biharlist);

        String[] biharDistricts = {"Araria", "Arwal", "Aurangabad", "Banka", "Begusarai",
                "Bhagalpur", "Bhojpur", "Buxar", "Darbhanga", "East Champaran", "Gaya", "Gopalganj",
                "Jamui", "Jehanabad", "Kaimur", "Katihar", "Khagaria", "Kishanganj", "Lakhisarai",
                "Madhepura", "Madhubani", "Munger", "Muzaffarpur", "Nalanda", "Nawada", "Patna",
                "Purnia", "Rohtas", "Saharsa", "Samastipur", "Saran", "Sheikhpura", "Sheohar",
                "Sitamarhi", "Siwan", "Supaul", "Vaishali", "West Champaran"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, biharDistricts);
        bihar.setAdapter(adapter);
    }
}
