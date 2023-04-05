package com.example.gofishgui.fish;

import java.util.ArrayList;

public class FishDumbAI {
    private ArrayList<FishCard> hand;

    public FishDumbAI(ArrayList<FishCard> hand) {
        this.hand = hand;
    }

    public FishActionObject askForCard(int value, String rank, ArrayList<FishCard> otherHand) {
        FishActionObject actionObject = new FishActionObject(new ArrayList<>());
        if (otherHand != null) {
            boolean hasCard = actionObject.askForCard(value, rank, otherHand);
            if (hasCard) {
                // Remove the matching card from the hand of the other player
                otherHand.removeIf(card -> card.getValue() == value && card.getRank().equals(rank));
            } else {
                // If the other player does not have the card, draw a card from the deck
                FishDeck deck = FishDeck.getInstance();
                FishCard drawnCard = deck.drawCard("computer");
                if (drawnCard != null) {
                    hand.add(drawnCard);
                }
            }
        }
        return actionObject;
    }

    public boolean checkForFour(int value) {
        return new FishActionObject(hand).checkForFour(value);
    }

    public void removeCard(int value, String rank) {
        new FishActionObject(hand).removeCard(value, rank);
    }

    public ArrayList<FishCard> getHand() {
        return hand;
    }
}
