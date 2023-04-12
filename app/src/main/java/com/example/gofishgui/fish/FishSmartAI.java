package com.example.gofishgui.fish;

import java.util.ArrayList;

public class FishSmartAI {

    private ArrayList<FishCard> humanHand;
    private ArrayList<FishCard> computerHand;
    private ArrayList<FishCard> deck;
    int value;
    FishActionObject fishActionObject;
    private fishGameState fish = fishGameState.getInstance();

    public FishSmartAI(ArrayList<FishCard> humanHand, ArrayList<FishCard> computerHand, ArrayList<FishCard> deck) {
        this.humanHand = fish.humanHand;
        this.computerHand = fish.computerHand;
        this.deck = fish.deck;
        this.fishActionObject = new FishActionObject(fish.computerHand, fish.humanHand, fish.deck);

    }

    public void smartAsk() {

        value = getSmartVal();
        fishActionObject.askForCard(value, 1);
        fishActionObject.checkForFour(fish.humanHand, fish.computerHand, value);
        //fish.isGameOver(); //call isGameOver
        System.out.println("Computer asked for a " + value);
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

        return;
    }

    public int getSmartVal() {

        System.out.print("Priority array: ");
        for (Integer value : fish.priority) {
            System.out.print(value + " ");
        }
        System.out.println(" ");
        System.out.print("doNotAsk array: ");
        for (Integer value : fish.doNotAsk) {
            System.out.print(value + " ");
        }
        System.out.println(" ");

        for (FishCard card : computerHand) {
            if (fish.priority.contains(card.getValue())) {
                value = card.getValue();
                Integer integerToRemove = value;
                fish.priority.remove(integerToRemove);
                return value;
            }
        }
        for (FishCard card : computerHand) {
            if (!(fish.doNotAsk.contains(card.getValue()))) {
                value = card.getValue();
                return value;
            }
        }

        ArrayList<Integer> intValues = new ArrayList<Integer>();
        for (FishCard card : computerHand) {
            intValues.add(card.getValue());
        }


        return intValues.get(0);
    }

}
