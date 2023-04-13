package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gofishgui.R;
import com.example.gofishgui.fish.fishGameState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EndActivity extends AppCompatActivity {

    private Handler handler;
    private TextView winnerMessageTextView;
    private int currentColorIndex;
    private List<Integer> colorList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Get the scores from the previous activity
        fishGameState fish = fishGameState.getInstance(); //instance of fish game state
        int humanScore = fish.getPlayerScore();
        int computerScore = fish.getOpponentScore();

        // Determine the winner
        String winner;
        if (humanScore > computerScore) {
            winner = "You";
        } else if (computerScore > humanScore){
            winner = "AI";
        } else {
            winner = "It's a tie!";
        }

        // Display the winner message
        winnerMessageTextView = findViewById(R.id.winner);
        String winnerMessage = "The winner is: " +  winner;
        winnerMessageTextView.setText(winnerMessage);

        // Set up the handler to change the text color every 500ms
        colorList = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA));
        currentColorIndex = 0;
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int newColorIndex = (currentColorIndex + 1) % colorList.size();
                winnerMessageTextView.setTextColor(colorList.get(newColorIndex));
                currentColorIndex = newColorIndex;
                handler.postDelayed(this, 500);
            }
        }, 500);

        //create reset button
        Button resetButton2 = findViewById(R.id.resetButton2);
        resetButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fish.setPlayerScore(0);
                fish.setOpponentScore(0);
                Intent intent = new Intent(EndActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove any scheduled tasks from the handler to prevent memory leaks
        handler.removeCallbacksAndMessages(null);
    }
}

