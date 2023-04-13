package com.example.gofishgui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gofishgui.R;
import com.example.gofishgui.fish.FishActionObject;
import com.example.gofishgui.fish.FishCard;
import com.example.gofishgui.fish.FishDeck;
import com.example.gofishgui.fish.FishDumbAI;
import com.example.gofishgui.fish.FishSmartAI;
import com.example.gofishgui.fish.fishGameState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public GameLoop gameLoop;
    private Thread gameThread;
    ArrayList<FishCard> userHand; // arraylist for the hand
    ArrayList<FishCard> computerHand; // arraylist for the hand
    ArrayList<FishCard> deck; // arraylist for the deck
    private fishGameState fish = fishGameState.getInstance(); //instance of fish game state
    private int pos;
    int valueChosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userHand = new ArrayList<>();
        computerHand = new ArrayList<>();
        deck = new ArrayList<>();
        int value = 0;

            // (TEST), initializes a game, will put the following into startGame method later!!
            // image views for human cards array
            ArrayList<ImageView> pc = new ArrayList<>();
            ArrayList<Button> b = new ArrayList<>();
            // ask button array
            //Button[] b = new Button[pc.length];
            Button z = findViewById(R.id.askButton);
        //show score for both players
            TextView player = findViewById(R.id.playerPoints);
            TextView opponent = findViewById(R.id.opponentPoints);
            player.setText("Player Score: " + fish.getPlayerScore());
            opponent.setText("Opponent Score: " + fish.getOpponentScore());

            //show the card the AI asks
        TextView cardAsked = findViewById(R.id.cardAsked);
        cardAsked.setText("AI asked for a: " + value);

            // populates button and imageview
            //pc[0] = findViewById(R.id.player_card1);
//        pc[1] = findViewById(R.id.player_card2);
//        pc[2] = findViewById(R.id.player_card3);
//        pc[3] = findViewById(R.id.player_card4);
//        pc[4] = findViewById(R.id.player_card5);
//        pc[5] = findViewById(R.id.player_card6);
//        pc[6] = findViewById(R.id.player_card7);
//        b[0] = findViewById(R.id.askbutton1);
//        b[1] = findViewById(R.id.askbutton2);
//        b[2] = findViewById(R.id.askbutton3);
//        b[3] = findViewById(R.id.askbutton4);
//        b[4] = findViewById(R.id.askbutton5);
//        b[5] = findViewById(R.id.askbutton6);
//        b[6] = findViewById(R.id.askbutton7);
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
            fish.setHumanHand(humanHand); //updates the humanHand in fishGameState
            // gets computer hand
            ArrayList<FishCard> computerHand = deck.getComputerHand();
            fish.setComputerHand(computerHand);
            ; //updates the computerHand in fishGameState
            //gets the deck or go fish pile
            ArrayList<FishCard> myDeck = deck.getDeck();
            fish.setDeck(myDeck); //updates the deck in fishGameState
            //update the score
            fish.setPlayerScore(fish.getPlayerScore());
            fish.setOpponentScore(fish.getOpponentScore());

            // updates images for human hand (not required for computer hand cuz it is hidden the whole game
            //updateHandImages(humanHand, pc);
            // creates FishHand for the human and also makes the buttons show
//        FishHand humanPlayerHand = new FishHand(this, pc, b, humanHand, computerHand, myDeck);
//        LinearLayout layout = findViewById(R.id.layout_main);
//        layout.addView(humanPlayerHand);
            TextView cardZ = (TextView) findViewById(R.id.textView);
            String cardSet = "";
            for (int i = 0; i < fish.humanHand.size(); ++i) {
                cardSet = cardSet + fish.humanHand.get(i).getValue() + ", ";
                System.out.println("Added Card to Textview)");
            }
            cardZ.setText(cardSet);

            Spinner dropdown = findViewById(R.id.spinner2);
            String[] spannerNumbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spannerNumbers);
            dropdown.setAdapter(adapter);


            dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                    switch (position) {
                        case 0:
                            // Assign Dummy AI here, SOP for testing purposes
                            pos = position + 1;
                            System.out.println("1");
                            break;
                        case 1:
                            // Assign Smart AI here, SOP for testing purposes
                            pos = position + 1;
                            System.out.println("2");
                            break;
                        case 2:
                            pos = position + 1;
                            System.out.println("3");
                            break;
                        case 3:
                            pos = position + 1;
                            System.out.println("4");
                            break;
                        case 4:
                            pos = position + 1;
                            System.out.println("5");
                            break;
                        case 5:
                            pos = position + 1;
                            System.out.println("6");
                            break;
                        case 6:
                            pos = position + 1;
                            System.out.println("7");
                            break;
                        case 7:
                            pos = position + 1;
                            System.out.println("8");
                            break;
                        case 8:
                            pos = position + 1;
                            System.out.println("9");
                            break;
                        case 9:
                            pos = position + 1;
                            System.out.println("10");
                            break;
                        case 10:
                            pos = position + 1;
                            System.out.println("11");
                            break;
                        case 11:
                            pos = position + 1;
                            System.out.println("12");
                            break;
                        case 12:
                            pos = position + 1;
                            System.out.println("13");
                            break;

                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

            });
                z.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // (TEST) SOP hands before asking for card
                        System.out.print("Current hand before ask: ");
                        for (FishCard card : humanHand) {
                            System.out.print(card.getValue() + " ");
                        }
                        System.out.println(" ");
                        System.out.print("Other hand before ask: ");
                        for (FishCard card : computerHand) {
                            System.out.print(card.getValue() + " ");
                        }
                        System.out.println(" ");

                        System.out.println("Player index onCLick: " + fish.getCurrentPlayer());
                        // ask button only works when it is the user's turn
                        if (fish.getCurrentPlayer() != 0) {
                            System.out.println("Cannot go, not your turn!");
                            return;
                        }
                        //get the card value
                        int value = pos;
                        // call askForCard() method on fishActionObject
                        FishActionObject fishActionObject = new FishActionObject(humanHand, computerHand, myDeck);
                        fishActionObject.askForCard(value, 0);
                        //call checkForFour
                        fishActionObject.checkForFour(fish.humanHand, fish.computerHand, value);
                        //call isGameOver method
                        fish.isGameOver();
                        //update the score textView
                        int humanScore = fish.getPlayerScore();
                        int computerScore = fish.getOpponentScore();
                        player.setText("Player Score: " + humanScore);
                        opponent.setText("Opponent Score: " + computerScore);

                // (TEST) SOP hands after asking for a card
                System.out.print("Current hand after ask: ");
                for (FishCard card : humanHand) {
                    System.out.print(card.getValue() + " ");
                }
                System.out.println(" ");
                System.out.print("Other hand after ask: ");
                for (FishCard card : computerHand) {
                    System.out.print(card.getValue() + " ");
                }
                System.out.println(" ");
                System.out.print("Deck after ask: ");
                for (FishCard card : myDeck) {
                    System.out.print(card.getValue() + " ");
                }
                System.out.println(" ");
                fish.setHumanHand(humanHand); //updates the humanHand in fishGameState
                fish.setComputerHand(computerHand);; //updates the computerHand in fishGameState
                fish.setDeck(myDeck); //updates the deck in fishGameState
                fish.setPlayerScore(fish.getPlayerScore());
                fish.setOpponentScore(fish.getOpponentScore());
                TextView cardZ = (TextView) findViewById(R.id.textView);
                String cardSet = "";
                for(int i = 0; i < fish.humanHand.size(); ++i) {
                    cardSet = cardSet + fish.humanHand.get(i).getValue() + ", ";
                }
                cardZ.setText(cardSet);
            }
        });
        // Find the endgamebutton view
        Button endgamebutton = findViewById(R.id.endGameButton);

                // Set OnClickListener to endgamebutton
                endgamebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // End the game
                        endGame();
                    }
                });
            }
    //end of onCreate

    // End the game and switch to EndActivity using the endGame button
    private void endGame() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
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

    public class GameLoop implements Runnable {

        private boolean isRunning;
        private Context context;
        FishDumbAI dumbAI = new FishDumbAI(userHand, computerHand, deck);
        FishSmartAI smartAI = new FishSmartAI(userHand, computerHand, deck);
        @Override
        public void run() {
            isRunning = true;

            while (isRunning) {

                if (fish.getCurrentPlayer() == 1) {
                    dumbAI.dumbAsk();
                    // Run on the UI thread to update the text view
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView cardAsked = findViewById(R.id.cardAsked);
                            valueChosen = fish.getComputerAsk();
                            cardAsked.setText("AI asked for a: " + valueChosen);
                            TextView cardZ = (TextView) findViewById(R.id.textView);
                            String cardSet = "";
                            for(int i = 0; i < fish.humanHand.size(); ++i) {
                                cardSet = cardSet + fish.humanHand.get(i).getValue() + ", ";
                            }
                            cardZ.setText(cardSet);
                        }

                    });
                }
                else if(fish.getCurrentPlayer() == 2){
                    smartAI.smartAsk();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView cardAsked = findViewById(R.id.cardAsked);
                            valueChosen = fish.getComputerAsk();
                            cardAsked.setText("AI asked for a: " + valueChosen);
                            TextView cardZ = (TextView) findViewById(R.id.textView);
                            String cardSet = "";
                            for(int i = 0; i < fish.humanHand.size(); ++i) {
                                cardSet = cardSet + fish.humanHand.get(i).getValue() + ", ";
                            }
                            cardZ.setText(cardSet);
                        }
                    });
                }


                //create intent for EndActivity (automatically)
                if (fish.isGameOver() == true) {
                    Intent intent = new Intent(MainActivity.this, EndActivity.class);
                    // pass necessary data to EndActivity if required
                    // intent.putExtra(key, value);
                    startActivity(intent);
                    finish();
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
//        public void update() {
//            //fish.update();
//            FishActionObject fishActionObject = new FishActionObject(userHand, computerHand, deck);
//            fishActionObject.isGameOver();
//            if(fishActionObject.isGameOver()) {
//                Intent intent = new Intent(MainActivity.this, EndActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        }

    }

    // Helper method that updates the images on the cards
//    public void updateHandImages(ArrayList<FishCard> hand, ImageView[] imageViews) {
//        int numCards = hand.size();
//        for (int i = 0; i < imageViews.length; i++) {
//            if (i < numCards) {
//                FishCard card = hand.get(i);
//                String fileName = "";
//                switch (card.getValue()) {
//                    case 1: fileName += "ace"; break;
//                    case 2: fileName += "two"; break;
//                    case 3: fileName += "three"; break;
//                    case 4: fileName += "four"; break;
//                    case 5: fileName += "five"; break;
//                    case 6: fileName += "six"; break;
//                    case 7: fileName +=  "seven"; break;
//                    case 8: fileName += "eight"; break;
//                    case 9: fileName += "nine"; break;
//                    case 10: fileName += "ten"; break;
//                    case 11: fileName += "jack"; break;
//                    case 12: fileName += "queen"; break;
//                    case 13: fileName += "king"; break;
//                }
//                fileName += "_of_";
//                switch (card.getRank()) {
//                    case "hearts": fileName += "hearts"; break;
//                    case "diamonds": fileName += "diamonds"; break;
//                    case "clubs": fileName += "clubs"; break;
//                    case "spades": fileName += "spades"; break;
//                }
//
//                // sets the ImageViews on each card to the corresponding filename
//                int imageResource = getResources().getIdentifier(fileName, "drawable", getPackageName());
//                imageViews[i].setImageResource(imageResource);
//                imageViews[i].setVisibility(View.VISIBLE);
//            }
//            else {
//                // hide the card if there is no card to display
//                imageViews[i].setVisibility(View.INVISIBLE);
//            }
//        }
//    }

}


