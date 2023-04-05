package com.example.gofishgui.fish;

import java.util.ArrayList;

public class FishActionObject {
    // instance variables
    private ArrayList<FishCard> currHand;
    private ArrayList<FishCard> otherHand;

    // constructor
    public FishActionObject(ArrayList<FishCard> currHand, ArrayList<FishCard> otherHand) {
        this.currHand = currHand;
        this.otherHand = otherHand;
    }

    // askforcard method
    public void askForCard(int value) {
        ArrayList<FishCard> cardsToRemove = new ArrayList<>();
        for (FishCard card : otherHand) {
            if (card.getValue() == value) {
                currHand.add(card);
                cardsToRemove.add(card);
            }
        }
        otherHand.removeAll(cardsToRemove);
    }
}

