package com.example.gofishgui.fish;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.gofishgui.activities.MainActivity;

import java.util.ArrayList;

public class FishActionObject {
    // instance variables
    private ArrayList<FishCard> currHand;
    private ArrayList<FishCard> otherHand;
    private ArrayList<FishCard> deck;
    private fishGameState fish = fishGameState.getInstance();
    private MainActivity mainActivity;



    // constructor
    public FishActionObject(ArrayList<FishCard> currHand, ArrayList<FishCard> otherHand, ArrayList<FishCard> deck,
                            MainActivity mainActivity) {
        this.currHand = currHand;
        this.otherHand = otherHand;
        this.deck = deck;
        this.mainActivity = mainActivity;
    }

    // askforcard method
    public boolean askForCard(int value, int playerIdx) {
        ArrayList<FishCard> cardsToRemove = new ArrayList<>();
        boolean hasCard = false;
        for (FishCard card : otherHand) {
            if (card.getValue() == value) {
                currHand.add(card);
                cardsToRemove.add(card);
                hasCard = true;
            }
        }
        if (hasCard == true) {
            otherHand.removeAll(cardsToRemove);
            return true;
        }
        else {
            System.out.println("Go Fish!");
            drawCard(playerIdx);
            fish.nextPlayer();
            return false;
        }
    }

    public FishCard drawCard(int playerIdx) {

        FishCard card;
        if (deck != null) {
            card = deck.remove(0);
        } else {
            return null;
        }

        if (playerIdx == 0) {
            fish.humanHand.add(card);
        } else {
            fish.computerHand.add(card);
        }
        return card;
    }

}

