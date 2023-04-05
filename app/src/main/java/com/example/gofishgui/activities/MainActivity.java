package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.gofishgui.R;
import com.example.gofishgui.fish.FishCard;
import com.example.gofishgui.fish.FishDeck;
import com.example.gofishgui.fish.FishHand;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (TEST), initializes a game, will put the following into startGame method later!!
        // image views for human cards array
        ImageView[] pc = new ImageView[7];
        // ask button array
        Button[] b = new Button[pc.length];
        // populates button and imageview
        pc[0] = findViewById(R.id.player_card1);
        pc[1] = findViewById(R.id.player_card2);
        pc[2] = findViewById(R.id.player_card3);
        pc[3] = findViewById(R.id.player_card4);
        pc[4] = findViewById(R.id.player_card5);
        pc[5] = findViewById(R.id.player_card6);
        pc[6] = findViewById(R.id.player_card7);
        b[0] = findViewById(R.id.askbutton1);
        b[1] = findViewById(R.id.askbutton2);
        b[2] = findViewById(R.id.askbutton3);
        b[3] = findViewById(R.id.askbutton4);
        b[4] = findViewById(R.id.askbutton5);
        b[5] = findViewById(R.id.askbutton6);
        b[6] = findViewById(R.id.askbutton7);
        // generates 52 cards
        ArrayList<FishCard> cards = new ArrayList<>();
        // creates deck from cards
        FishDeck deck = new FishDeck(cards);
        // shuffles cards
        deck.shuffle();
        // deals cards
        deck.dealCards();
        // gets human hand
        ArrayList<FishCard> humanHand = deck.getHumanHand();
        // gets computer hand
        ArrayList<FishCard> computerHand = deck.getComputerHand();
        ArrayList<FishCard> myDeck = deck.getDeck();

        // updates images for human hand (not required for computer hand cuz it is hidden the whole game
        updateHandImages(humanHand, pc);
        // creates FishHand for the human and also makes the buttons show
        FishHand humanPlayerHand = new FishHand(this, pc, b, humanHand, computerHand, myDeck);
        LinearLayout layout = findViewById(R.id.layout_main);
        layout.addView(humanPlayerHand);
    }

    // Helper method that updates the images on the cards
    public void updateHandImages(ArrayList<FishCard> hand, ImageView[] imageViews) {
        int numCards = hand.size();
        for (int i = 0; i < imageViews.length; i++) {
            if (i < numCards) {
                FishCard card = hand.get(i);
                String fileName = "";
                switch (card.getValue()) {
                    case 1: fileName += "ace"; break;
                    case 2: fileName += "two"; break;
                    case 3: fileName += "three"; break;
                    case 4: fileName += "four"; break;
                    case 5: fileName += "five"; break;
                    case 6: fileName += "six"; break;
                    case 7: fileName +=  "seven"; break;
                    case 8: fileName += "eight"; break;
                    case 9: fileName += "nine"; break;
                    case 10: fileName += "ten"; break;
                    case 11: fileName += "jack"; break;
                    case 12: fileName += "queen"; break;
                    case 13: fileName += "king"; break;
                }
                fileName += "_of_";
                switch (card.getRank()) {
                    case "hearts": fileName += "hearts"; break;
                    case "diamonds": fileName += "diamonds"; break;
                    case "clubs": fileName += "clubs"; break;
                    case "spades": fileName += "spades"; break;
                }

                // sets the ImageViews on each card to the corresponding filename
                int imageResource = getResources().getIdentifier(fileName, "drawable", getPackageName());
                imageViews[i].setImageResource(imageResource);
                imageViews[i].setVisibility(View.VISIBLE);
            }
            else {
                // hide the card if there is no card to display
                imageViews[i].setVisibility(View.INVISIBLE);
            }
        }
    }
}


