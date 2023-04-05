package com.example.gofishgui.fish;

import java.util.ArrayList;

public class FishSmartAI {

    private ArrayList<FishCard> humanHand;
    private ArrayList<FishCard> computerHand;
    private ArrayList<FishCard> deck;
    int value;
    FishActionObject fishActionObject;

    public FishSmartAI(ArrayList<FishCard> humanHand, ArrayList<FishCard> computerHand, ArrayList<FishCard> deck) {
        this.humanHand = humanHand;
        this.computerHand = computerHand;
        this.deck = deck;
        this.fishActionObject = new FishActionObject(humanHand, computerHand, deck);

    }
    public boolean dumbAsk() {
        value = 1; //Implement later
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

}
