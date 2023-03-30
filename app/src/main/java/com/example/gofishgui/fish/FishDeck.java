package com.example.gofishgui.fish;

import java.util.Random;

public class FishDeck {
    // Instances
    private FishCard[] deck;
    private FishCard[] humanHand;
    private FishCard[] computerHand;

    // Constructor
    public FishDeck(FishCard[] deck) {
        this.deck = deck;
    }

    // Shuffle deck method
    public void shuffle() {
        // Random object
        Random rand = new Random();

        // Shuffles elements of the deck
        for(int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            FishCard temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
    }

    // Deals cards to players and keeps the rest for the deck
    public void dealCards() {
        // Deals to human hand
        for(int i = 0; i < 7; i++) {
            humanHand[i] = deck[i];
        }

        // Deals to computer hand
        for(int i = 6; i < 14; i++) {
            computerHand[i] = deck[i];
        }
    }

    // Create deck
    public void createDeck() {
        shuffle();
    }

    // Getters
    public FishCard[] getHumanHand() {
        return humanHand;
    }
    public FishCard[] getComputerHand() {
        return computerHand;
    }


}
