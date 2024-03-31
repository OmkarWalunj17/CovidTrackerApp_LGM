package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.view.View;


public class LaunchActivity extends AppCompatActivity {

    // loading time variable

    private static final int loadVar = 5000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        // Show loader
        findViewById(R.id.loader).setVisibility(View.VISIBLE);

        // Set a delay to start the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start main activity
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },loadVar);
    }
}
