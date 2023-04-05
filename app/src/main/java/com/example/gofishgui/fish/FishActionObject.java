package com.example.gofishgui.fish;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class FishActionObject {
    private ArrayList<FishCard> hand; //the hand of the player being asked

    public FishActionObject(ArrayList<FishCard> hand) {
        this.hand = hand;
    }

    public boolean askForCard(int value, String rank, ArrayList<FishCard> playerHand) {
        boolean hasCard = false;
        //search through playerHand to find match and remove in player hand
        //but add to hand.
        ArrayList<FishCard> cardsToRemove = new ArrayList<FishCard>();
        for (FishCard card : playerHand) {
            if (card.getValue() == value && card.getRank().equals(rank)) {
                cardsToRemove.add(card);
                hand.add(card);
                hasCard = true;
            }
        }
        playerHand.removeAll(cardsToRemove);
        return hasCard;
    }

    public boolean checkForFour(int value) {
        int count = 0;
        for (FishCard card : hand) {
            if (card.getValue() == value) {
                count++;
            }
        }
        return count == 4;
    }

    public void removeCard(int value, String rank) {
        ArrayList<FishCard> cardsToRemove = new ArrayList<>();
        for (FishCard card : hand) {
            if (card.getValue() == value && card.getRank().equals(rank)) {
                cardsToRemove.add(card);
            }
        }
        hand.removeAll(cardsToRemove);
    }

    public String getCards() {
        return null;
    }
}

