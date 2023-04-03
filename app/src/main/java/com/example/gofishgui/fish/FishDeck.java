package com.example.gofishgui.fish;

import java.util.Random;

public class FishDeck {
    // Instances
    private FishCard[] deck;
    private FishCard[] humanHand;
    private FishCard[] computerHand;

    // Constructor
    public FishDeck(FishCard[] deck) {
        String[] suits = {"diamonds", "hearts", "spades", "clubs"};

        // fills card array with cards (unshuffled)
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < 13; j++) {
                int cardValue = j + 1;
                String cardRank = suits[i];
                FishCard card = new FishCard(cardRank, cardValue);
                deck[i * 13 + j] = card;
            }
        }
        this.deck = deck;
    }

    // Shuffle deck method
    public void shuffle() {
        // random object
        Random rand = new Random();

        // shuffles elements of the deck
        for(int i = 0; i < deck.length; i++) {
            int randomIndexToSwap = rand.nextInt(deck.length);
            FishCard temp = deck[randomIndexToSwap];
            deck[randomIndexToSwap] = deck[i];
            deck[i] = temp;
        }
    }

    // Deals cards to players
    public void dealCards() {
        // deal cards to two hands
        humanHand = new FishCard[7];
        computerHand = new FishCard[7];
        for (int i = 0; i < 7; i++) {
            humanHand[i] = this.deck[i * 2];
            computerHand[i] = this.deck[i * 2 + 1];
        }
        // leave the rest of the cards in the deck
        int remainingCards = this.deck.length - 14;
        FishCard[] remainingDeck = new FishCard[remainingCards];
        for (int i = 0; i < remainingCards; i++) {
            remainingDeck[i] = this.deck[14 + i];
        }
        this.deck = remainingDeck;
    }

    // Getters
    public FishCard[] getHumanHand() {
        return humanHand;
    }
    public FishCard[] getComputerHand() {
        return computerHand;
    }
}
