package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.gofishgui.R;
import com.example.gofishgui.fish.FishCard;
import com.example.gofishgui.fish.FishDeck;
import com.example.gofishgui.fish.FishDumbAI;
import com.example.gofishgui.fish.FishHand;
import com.example.gofishgui.fish.fishGameState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GameLoop gameLoop;
    private Thread gameThread;
    ArrayList<FishCard> userHand; // arraylist for the hand
    ArrayList<FishCard> computerHand; // arraylist for the hand
    ArrayList<FishCard> deck; // arraylist for the deck
    private fishGameState fish = fishGameState.getInstance(); //instance of fish game state
    private MainActivity mainActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // (TEST), initializes a game, will put the following into startGame method later!!
        // image views for human cards array
        ArrayList<ImageView> pc = new ArrayList<>();
        // ask button array
        ArrayList<Button> b = new ArrayList<>();
        // populates button and imageview
        pc.add(findViewById(R.id.player_card1));
        pc.add(findViewById(R.id.player_card2));
        pc.add(findViewById(R.id.player_card3));
        pc.add(findViewById(R.id.player_card4));
        pc.add(findViewById(R.id.player_card5));
        pc.add(findViewById(R.id.player_card6));
        pc.add(findViewById(R.id.player_card7));
        b.add(findViewById(R.id.askbutton1));
        b.add(findViewById(R.id.askbutton2));
        b.add(findViewById(R.id.askbutton3));
        b.add(findViewById(R.id.askbutton4));
        b.add(findViewById(R.id.askbutton5));
        b.add(findViewById(R.id.askbutton6));
        b.add(findViewById(R.id.askbutton7));

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
        //updates the humanHand in fishGameState
        fish.setHumanHand(humanHand);
        // gets computer hand
        ArrayList<FishCard> computerHand = deck.getComputerHand();
        fish.setComputerHand(computerHand);; //updates the computerHand in fishGameState
        //gets the deck or go fish pile
        ArrayList<FishCard> myDeck = deck.getDeck();
        fish.setDeck(myDeck); //updates the deck in fishGameState
        // sets images for human hand
        setHandImages(humanHand, pc);
        // creates FishHand for the human and also makes the buttons show
        FishHand hand = new FishHand(this, pc, b, humanHand, computerHand, myDeck, this);
        LinearLayout layout = findViewById(R.id.layout_main);
        layout.addView(hand);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Start the game loop
        gameLoop = new GameLoop();
        gameThread = new Thread(gameLoop);
        gameThread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Stop the game loop
        gameLoop.stop();
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class GameLoop implements Runnable {

        private boolean isRunning;
        FishDumbAI dumbAI = new FishDumbAI(userHand, computerHand, deck, mainActivity);

        @Override
        public void run() {
            isRunning = true;

            while (isRunning) {

                if (fish.getCurrentPlayer() != 0) {
                    dumbAI.dumbAsk();
                }

                // Sleep for a short amount of time to limit the frame rate
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stop() {
            isRunning = false;
        }
    }

    // Helper method that updates the images on the cards
    public void setHandImages(ArrayList<FishCard> hand, ArrayList<ImageView> imageViews) {
        int numCards = hand.size();
        for (int i = 0; i < imageViews.size(); i++) {
            FishCard card = hand.get(i);
            ImageView image = imageViews.get(i);
            if (i < numCards) {
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
                image.setImageResource(imageResource);
                image.setVisibility(View.VISIBLE);
            }
            else {
                // hide the card if there is no card to display
                image.setVisibility(View.INVISIBLE);
            }
        }
    }

//    public void updateHandImages(ArrayList<FishCard> hand, ArrayList<FishCard> humanHand,
//                                 ArrayList<FishCard> computerHand, ArrayList<ImageView> handImages) {
//        int handSize = hand.size();
//        int imageViewsSize = handImages.size();
//
//        if (handSize < imageViewsSize) {
//            // Remove extra image views
//            for (int i = imageViewsSize - 1; i >= handSize; i--) {
//                ImageView imageView = handImages.get(i);
//                imageView.setVisibility(View.GONE);
//                handImages.remove(i);
//            }
//        } else if (handSize > imageViewsSize) {
//            // Add new image views
//            for (int i = imageViewsSize; i < handSize; i++) {
//                ImageView imageView = new ImageView(this);
//                imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                setHandImages(hand, handImages);
//                handImages.add(imageView);
//                // Add the image view to the appropriate layout
//                if (hand == humanHand) {
//                    LinearLayout playerHand = findViewById(R.id.player_hand);
//                    playerHand.addView(imageView); }
////                } else {
////                    computerHandLayout.addView(imageView);
////                }
//            }
//        }
//
//        // Set the appropriate image for each card
//        for (int i = 0; i < handSize; i++) {
//            ImageView imageView = handImages.get(i);
//            FishCard card = hand.get(i);
//            setHandImages(hand, handImages);
//            imageView.setVisibility(View.VISIBLE);
//        }
//    }
}


