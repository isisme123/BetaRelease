package com.example.gofishgui.fish;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class FishActionObject {
//
private ArrayList<FishCard> currHand;
    private ArrayList<FishCard> otherHand;

    public FishActionObject(ArrayList<FishCard> currHand, ArrayList<FishCard> otherHand) {
        this.currHand = currHand;
        this.otherHand = otherHand;
    }

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

