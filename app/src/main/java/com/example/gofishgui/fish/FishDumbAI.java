package com.example.gofishgui.fish;

import java.util.ArrayList;
import java.util.Random;

public class FishDumbAI {

    private ArrayList<FishCard> humanHand;
    private ArrayList<FishCard> computerHand;
    private ArrayList<FishCard> deck;
    int value;
    FishActionObject fishActionObject;

    public FishDumbAI(ArrayList<FishCard> humanHand, ArrayList<FishCard> computerHand, ArrayList<FishCard> deck) {
        this.humanHand = humanHand;
        this.computerHand = computerHand;
        this.deck = deck;
        this.fishActionObject = new FishActionObject(humanHand, computerHand, deck);

    }

    //Random number generator for a value from 1-13
    public int randomVal() {
        Random rand = new Random();
        int toRtn = rand.nextInt(13) + 1;
        return toRtn;
    }

    public boolean dumbAsk() {
        value = randomVal();
        fishActionObject.askForCard(value, 1);

        System.out.print("Computer hand after ask: ");
        for (FishCard card : computerHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
        System.out.print("User hand after ask: ");
        for (FishCard card : humanHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");

        return true;
    }






    //    public FishActionObject askForCard(int value, String rank, ArrayList<FishCard> otherHand) {
//        FishActionObject actionObject = new FishActionObject(new ArrayList<>());
//        if (otherHand != null) {
//            boolean hasCard = actionObject.askForCard(value, rank, otherHand);
//            if (hasCard) {
//                // Remove the matching card from the hand of the other player
//                otherHand.removeIf(card -> card.getValue() == value && card.getRank().equals(rank));
//            } else {
//                // If the other player does not have the card, draw a card from the deck
//                FishDeck deck = FishDeck.getInstance();
//                FishCard drawnCard = deck.drawCard("computer");
//                if (drawnCard != null) {
//                    hand.add(drawnCard);
//                }
//            }
//        }
//        return actionObject;
//    }
//
//    public boolean checkForFour(int value) {
//        return new FishActionObject(hand).checkForFour(value);
//    }
//
//    public void removeCard(int value, String rank) {
//        new FishActionObject(hand).removeCard(value, rank);
//    }
//
//    public ArrayList<FishCard> getHand() {
//        return hand;
//    }
}
