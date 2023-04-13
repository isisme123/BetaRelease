package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gofishgui.R;
import com.example.gofishgui.fish.fishGameState;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        // Get the scores from the previous activity
        fishGameState fish = fishGameState.getInstance(); //instance of fish game state
        int humanScore = fish.getPlayerScore();
        int computerScore = fish.getOpponentScore();

//        Intent intent = getIntent();
//        int humanPlayerScore = intent.getIntExtra("Human player score", 0);
//        int dumbAiScore = intent.getIntExtra("Dumb AI score", 1);
//        int smartAiScore = intent.getIntExtra("Smart AI score", 2);

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
        TextView winnerMessageTextView = findViewById(R.id.whoOne);
        String winnerMessage = "The winner is: " +  winner;
        winnerMessageTextView.setText(winnerMessage);
    }
}