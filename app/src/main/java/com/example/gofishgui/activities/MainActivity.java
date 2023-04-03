package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.gofishgui.R;
import com.example.gofishgui.fish.FishCard;
import com.example.gofishgui.fish.FishDeck;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TEST FOR PLAYER HANDS, start game
        ImageView[] pc = new ImageView[7];
        pc[0] = findViewById(R.id.player_card1);
        pc[1] = findViewById(R.id.player_card2);
        pc[2] = findViewById(R.id.player_card3);
        pc[3] = findViewById(R.id.player_card4);
        pc[4] = findViewById(R.id.player_card5);
        pc[5] = findViewById(R.id.player_card6);
        pc[6] = findViewById(R.id.player_card7);

        FishCard[] cards = new FishCard[52]; // generates 52 cards
        FishDeck deck = new FishDeck(cards); // creates deck from unshuffled cards
        deck.shuffle(); // shuffles deck
        deck.dealCards(); // deals cards
        FishCard[] humanHand = deck.getHumanHand(); // gets human hand
        FishCard[] computerHand = deck.getComputerHand(); // gets computer hand
        updateHandImages(humanHand, pc); // updates images for human hand
    }

    // Helper method that changes the images on the cards
    public void updateHandImages(FishCard[] hand, ImageView[] imageViews) {
        for (int i = 0; i < hand.length && i < imageViews.length; i++) {
            if (hand[i] != null) {
                String fileName = "";
                switch (hand[i].getValue()) {
                    case 1: fileName += "ace"; break;
                    case 2: fileName += "two"; break;
                    case 3: fileName += "three"; break;
                    case 4: fileName += "four"; break;
                    case 5: fileName += "five"; break;
                    case 6: fileName += "six"; break;
                    case 7: fileName += "seven"; break;
                    case 8: fileName += "eight"; break;
                    case 9: fileName += "nine"; break;
                    case 10: fileName += "ten"; break;
                    case 11: fileName += "jack"; break;
                    case 12: fileName += "queen"; break;
                    case 13: fileName += "king"; break;
                }

                fileName += "_of_";

                switch (hand[i].getRank()) {
                    case "hearts": fileName += "hearts"; break;
                    case "diamonds": fileName += "diamonds"; break;
                    case "clubs": fileName += "clubs"; break;
                    case "spades": fileName += "spades"; break;
                }

                int imageResource = getResources().getIdentifier(fileName, "drawable", getPackageName());
                imageViews[i].setImageResource(imageResource);
                imageViews[i].setVisibility(View.VISIBLE);
            }

            else {
                // hide the ImageView if there is no card to display
                imageViews[i].setVisibility(View.INVISIBLE);
            }
        }
    }
}


