package com.example.gofishgui.fish;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gofishgui.R;
import com.example.gofishgui.activities.MainActivity;

import java.util.ArrayList;

public class FishHand extends LinearLayout implements View.OnClickListener {
    private Context c; // context
    private ArrayList<ImageView> pc; // image views for human cards
    private ArrayList<Button> b; // button array
    private int value; // card value that was asked for
    private String rank; // card rank that was asked for
    private Button lastClickedButton;
    MainActivity mainActivity;
    ArrayList<FishCard> currHand; // arraylist for the hand
    ArrayList<FishCard> otherHand; // arraylist for the hand
    ArrayList<FishCard> deck; // arraylist for the deck
    FishActionObject fishActionObject; // instance of FishActionObject
    private fishGameState fish = fishGameState.getInstance();; // instance of fishGameState
    private int position;
    Button ask = findViewById(R.id.askButton);
    private TextView humanScoreTextView;
    private TextView AIScoreTextView;



    // FishHand constructor
    public FishHand(Context c, ArrayList<ImageView> pc, ArrayList<Button> b, ArrayList<FishCard> currHand, ArrayList<FishCard> otherHand, ArrayList<FishCard> deck) {
        super(c);
        this.c = c;
        this.pc = pc;
        this.b = b;
        this.currHand = currHand; // current player's hand
        this.otherHand = otherHand; // other player's hand
        this.deck = deck; // the deck or go fish pile
        this.fishActionObject = new FishActionObject(currHand, otherHand, deck); // create instance of FishActionObject
        this.humanScoreTextView = humanScoreTextView;
        this.AIScoreTextView = AIScoreTextView;
        //this.fish = new fishGameState(); // create instance of game state
        for (int i = 0; i < pc.size(); i++) {
            ImageView cardPicture = pc.get(i);
            Button button = b.get(i);
            cardPicture.setOnClickListener(this);
            button.setOnClickListener(this);
            button.setVisibility(INVISIBLE);
        }
        setOnClickListener(this);

        // (TEST) SOP hands before asking for card
        System.out.print("Current hand before ask: ");
        for (FishCard card : currHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
        System.out.print("Other hand before ask: ");
        for (FishCard card : otherHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
    }

    // OnClickListener method
    @Override
    public void onClick(View v) {
        System.out.println("Player index onCLick: " + fish.getCurrentPlayer());
        // ask button only works when it is the user's turn
        if (fish.getCurrentPlayer() != 0) {
            System.out.println("Cannot go, not your turn!");
            return;
        }
             //get the card value
                            value = position;
                            // call askForCard() method in fishActionObject
                            fishActionObject.askForCard(value, 0);

                            //call checkForFour() method
                            fishActionObject.checkForFour(fish.humanHand, fish.computerHand, value);

                            //call isGame over method
                            fish.isGameOver();

                            // (TEST) SOP hands after asking for a card
                            System.out.print("Current hand after ask: ");
                            for (FishCard card : currHand) {
                                System.out.print(card.getValue() + " ");
                            }
                            System.out.println(" ");
                            System.out.print("Other hand after ask: ");
                            for (FishCard card : otherHand) {
                                System.out.print(card.getValue() + " ");
                            }
                            System.out.println(" ");
                            System.out.print("Deck after ask: ");
                            for (FishCard card : deck) {
                                System.out.print(card.getValue() + " ");
                            }
                            System.out.println(" ");
                            fish.setHumanHand(currHand); //updates the humanHand in fishGameState
                            fish.setComputerHand(otherHand);; //updates the computerHand in fishGameState
                            fish.setDeck(deck); //updates the deck in fishGameState
        }

//        } else if (v instanceof ImageView) { // if card is clicked
//            for (int i = 0; i < pc.size(); i++) {
//                ImageView cardPicture = pc.get(i);
//                Button button = b.get(i);
//                if (v == cardPicture) {
//                    button.setVisibility(VISIBLE); // show a button
//                    lastClickedButton = button;
//                } else {
//                    button.setVisibility(INVISIBLE);
//                }
//            }
//        } else if (v instanceof Button) { // if the button is clicked
//            for (int i = 0; i < b.size(); i++) {
//                ImageView cardPicture = pc.get(i);
//                Button button = b.get(i);
//                if (v == button) { // go through button array and find card value that was asked for
//                    switch(i) {
//                        case 0:
//                        case 1:
//                        case 2:
//                        case 3:
//                        case 4:
//                        case 5:
//                        case 6:
//                            // get the card value
//                            value = currHand.get(i).getValue();
//                            // call askForCard() method on fishActionObject
//                            fishActionObject.askForCard(value, 0);
//
//                            // (TEST) SOP hands after asking for a card
//                            System.out.print("Current hand after ask: ");
//                            for (FishCard card : currHand) {
//                                System.out.print(card.getValue() + " ");
//                            }
//                            System.out.println(" ");
//                            System.out.print("Other hand after ask: ");
//                            for (FishCard card : otherHand) {
//                                System.out.print(card.getValue() + " ");
//                            }
//                            System.out.println(" ");
//                            System.out.print("Deck after ask: ");
//                            for (FishCard card : deck) {
//                                System.out.print(card.getValue() + " ");
//                            }
//                            System.out.println(" ");
//                            fish.setHumanHand(currHand); //updates the humanHand in fishGameState
//                            fish.setComputerHand(otherHand);; //updates the computerHand in fishGameState
//                            fish.setDeck(deck); //updates the deck in fishGameState
//
////                             mainActivity.updateHandImages(currHand, currHand, otherHand, pc);
//
//                            break;
//                    }
//                }
//            }
//            lastClickedButton.setVisibility(INVISIBLE);
//            lastClickedButton = null;
//        } else { // if card is not clicked
//            for (int i = 0; i < b.size(); i++) {
//                ImageView cardPicture = pc.get(i);
//                Button button = b.get(i);
//                button.setVisibility(INVISIBLE);
//            }
//            if (lastClickedButton != null) {
//                lastClickedButton.setVisibility(INVISIBLE);
//                lastClickedButton = null;
//            }
//        }

    public int setPosition(int pos) {
        position = pos;
        return position;
    }
}





