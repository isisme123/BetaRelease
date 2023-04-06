package com.example.gofishgui.fish;

import com.example.gofishgui.activities.MainActivity;

import java.util.ArrayList;
import java.util.Random;

public class FishDumbAI {

    private ArrayList<FishCard> humanHand;
    private ArrayList<FishCard> computerHand;
    private ArrayList<FishCard> deck;
    int value;
    FishActionObject fishActionObject;
    private fishGameState fish = fishGameState.getInstance();
    private MainActivity mainActivity;

    public FishDumbAI(ArrayList<FishCard> humanHand, ArrayList<FishCard> computerHand, ArrayList<FishCard> deck,
                      MainActivity mainActivity) {
        this.humanHand = fish.humanHand;
        this.computerHand = fish.computerHand;
        this.deck = fish.deck;
        this.fishActionObject = new FishActionObject(fish.computerHand, fish.humanHand, fish.deck, mainActivity);
        //this.fish = new fishGameState();

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

        System.out.print("User hand after ask: ");
        for (FishCard card : humanHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
        System.out.print("Computer hand after ask: ");
        for (FishCard card : computerHand) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");
        System.out.print("Deck after ask: ");
        for (FishCard card : deck) {
            System.out.print(card.getValue() + " ");
        }
        System.out.println(" ");

        fish.setHumanHand(humanHand); //updates the humanHand in fishGameState
        fish.setComputerHand(computerHand);; //updates the computerHand in fishGameState
        fish.setDeck(deck); //updates the deck in fishGameState

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
