package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
        updateHandImages(humanHand, pc); // updates images for human hand
    }

    // Helper method that changes the images on the cards
    public void updateHandImages(FishCard[] hand, ImageView[] imageViews) {
        for (int i = 0; i < hand.length; i++) {
            FishCard card = hand[i];
            String valueWord = "";
            switch (card.getValue()) {
                case 1: valueWord = "ace"; break;
                case 2: valueWord = "two"; break;
                case 3: valueWord = "three"; break;
                case 4: valueWord = "four"; break;
                case 5: valueWord = "five"; break;
                case 6: valueWord = "six"; break;
                case 7: valueWord = "seven"; break;
                case 8: valueWord = "eight"; break;
                case 9: valueWord = "nine"; break;
                case 10: valueWord = "ten"; break;
                case 11: valueWord = "jack"; break;
                case 12: valueWord = "queen"; break;
                case 13: valueWord = "king"; break;
                default: valueWord = "unknown"; break;
            }
            String fileName = valueWord + "_of_" + card.getRank().toLowerCase();
            int resourceId = getResources().getIdentifier(fileName, "drawable", getPackageName());
            imageViews[i].setImageResource(resourceId);
        }
    }
}


