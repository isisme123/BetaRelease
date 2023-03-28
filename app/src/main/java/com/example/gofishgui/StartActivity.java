package com.example.gofishgui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.navigation.NavigationBarView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Spinner
        Spinner dropdown = findViewById(R.id.spinner1);
        // List for spinner
        String[] items = new String[]{"Dummy AI", "Smart AI"};
        // Adaptor for spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        // For Player Selection
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                switch(position) {
                    case 0:
                        System.out.println("Dummy");
                        break;
                    case 1:
                        System.out.println("Smart");
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // Start button
        Button startButton = findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When start button is clicked, change to main activity
                Intent activityChangeIntent = new Intent(StartActivity.this, MainActivity.class);
                StartActivity.this.startActivity(activityChangeIntent);
            }
        });
    }
}