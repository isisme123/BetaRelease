package com.example.gofishgui.fish;

import java.util.ArrayList;
import java.util.Collections;

public class FishDeck {
    private static FishDeck instance = null;
    private ArrayList<FishCard> deck;
    private ArrayList<FishCard> humanHand;
    private ArrayList<FishCard> computerHand;

    public FishDeck(ArrayList<FishCard> deck) {
        this.deck = deck;
        humanHand = new ArrayList<FishCard>();
        computerHand = new ArrayList<FishCard>();
        // Add cards to the deck
        for (int i = 1; i <= 13; i++) {
            FishCard heartCard = new FishCard("hearts", i);
            FishCard diamondCard = new FishCard("diamonds", i);
            FishCard clubCard = new FishCard("clubs", i);
            FishCard spadeCard = new FishCard("spades", i);
            deck.add(heartCard);
            deck.add(diamondCard);
            deck.add(clubCard);
            deck.add(spadeCard);
        }
    }

    public static FishDeck getInstance() {
        if (instance == null) {
            instance = new FishDeck(new ArrayList<FishCard>());
            instance.shuffle();
            instance.dealCards();
        }
        return instance;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void dealCards() {
        for (int i = 0; i < 7; i++) {
            humanHand.add(deck.remove(0));
            computerHand.add(deck.remove(0));
        }
    }

    public ArrayList<FishCard> getDeck() { return deck; }

    public ArrayList<FishCard> getHumanHand() { return humanHand; }

    public ArrayList<FishCard> getComputerHand() { return computerHand; }

}
