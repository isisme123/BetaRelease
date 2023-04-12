package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gofishgui.R;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        // Get the scores from the previous activity
        Intent intent = getIntent();
        int player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0);
        int player2Score = intent.getIntExtra("PLAYER_2_SCORE", 1);

        // Determine the winner
        String winner;
        if (player1Score > player2Score) {
            winner = "Player 1";
        } else if (player2Score > player1Score) {
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