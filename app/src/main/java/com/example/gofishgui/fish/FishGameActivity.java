//package com.example.gofishgui.fish;
//
//import java.util.ArrayList;
//import java.util.ArrayList;
//
//public class FishGameActivity {
//    public static void main(String[] args) {
//        // Create a deck and deal cards to the players
//        FishDeck deck = FishDeck.getInstance();
//        ArrayList<FishCard> humanHand = deck.getHumanHand();
//        ArrayList<FishCard> computerHand = deck.getComputerHand();
//
//        // Create the players
//        FishHumanPlayer humanPlayer = new FishHumanPlayer(humanHand);
//        FishDumbAI computerPlayer = new FishDumbAI(computerHand);
//
//        // Have the human player ask the computer player for a card
//        FishActionObject humanAction = humanPlayer.askForCard(2, "2", computerHand);
//        System.out.println("Human asked for a 2 of hearts: " + humanAction.getCards());
//
//        // Have the computer player ask the human player for a card
//        FishActionObject computerAction = computerPlayer.askForCard(3, "3", humanHand);
//        System.out.println("Computer asked for a 3 of diamonds: " + computerAction.getCards());
//    }
//}


