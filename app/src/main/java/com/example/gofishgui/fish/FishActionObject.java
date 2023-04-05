package com.example.gofishgui.fish;

import java.util.ArrayList;

public class FishActionObject {
    // instance variables
    private ArrayList<FishCard> currHand;
    private ArrayList<FishCard> otherHand;
    private ArrayList<FishCard> deck;

    //private FishDumbAI computer;



    // constructor
    public FishActionObject(ArrayList<FishCard> currHand, ArrayList<FishCard> otherHand, ArrayList<FishCard> deck) {
        this.currHand = currHand;
        this.otherHand = otherHand;
        this.deck = deck;
        //computer = new FishDumbAI(currHand, otherHand, deck);
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

            //if(playerIdx == 0) {
            //    computer.dumbAsk();
            //}
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
            currHand.add(card);
        } else {
            otherHand.add(card);
        }
        return card;
    }

}

