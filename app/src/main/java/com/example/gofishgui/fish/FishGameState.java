//package com.example.gofishgui.fish;
//
//import java.util.List;
//import java.util.Random;
//
//public class FishGameState {
//    // Constants
//    public static final int NUM_PLAYERS = 2;
//    public static final int NUM_CARDS = 52;
//    public static final int HAND_SIZE = 7;
//
//    // Instance variables
//    private int playerIndex; //player who's turn it is
//    private int opponentIndex;
//    private int playerScore;
//    private int opponentScore;
//    private boolean gameOver;
//
//    // Constructor
//    public FishGameState() {
//        this.playerIndex = 0;
//        this.opponentIndex = 0;
//        this.playerScore = 0;
//        this.opponentScore = 0;
//        this.gameOver = false;
//    }
//
//    public GameState(GameState deep) {
//        playerIndex = deep.playerIndex;
//        opponentIndex = deep.opponentIndex;
//
//        for(int i = 0; i < deep.deck.size(); i++) {
//            this.deck.add(new Card(deep.deck.get(i)));
//        }
//
//        playerScore = deep.playerScore;
//        opponentScore = deep.opponentScore;
//
//        for(int i = 0; i < deep.playerHands.size(); i++) {
//            this.playerHands.add(new Card(deep.playerHands.get(i)));
//        }
//
//        for(int i = 0; i < deep.opponentHands.size(); i++) {
//            this.opponentHands.add(new Card(deep.opponentHands.get(i)));
//        }
//
//        gameOver = deep.gameOver;
//    }
//
//    // Ask for a card
//    public boolean askForCard(int playerIndex, int rank) {
//        boolean found = false;
//        if (playerIndex == this.playerIndex && rank > 0 && rank <= 13) {
//            for (int i = 0; i < opponentHands.size(); i++) {
//                if (opponentHands.get(i).getRank() == rank) {
//                    playerHands.add(opponentHands.remove(i));
//                    found = true;
//                }
//            }
//            if (found) {
//                if (checkForFour(playerHands, rank)) {
//                    playerScore++;
//                }
//                return true;
//            }
//        }
//        return false;
//    }
//
//    //Go fish to determine a legal move
//    public boolean goFish(int playerIndex) {
//        if (playerIndex == this.playerIndex) {
//            Random random = new Random();
//            int k = random.nextInt(deck.size());
//            Card cardDrawn = deck.get(k);
//            playerHands.add(cardDrawn);
//            deck.remove(k);
//            if (checkForFour(playerHands, cardDrawn.getRank())) {
//                playerScore++;
//            }
//            return true;
//        }
//        return false;
//    }
//
//    // Check for four of a kind
//    //helper method
//    private boolean checkForFour(List<Card> hand, int rank) {
//        int count = 0;
//        for (int i = 0; i < hand.size(); i++) {
//            if (hand.get(i).getRank() == rank) {
//                count++;
//            }
//        }
//        return count == 4;
//    }
//    // Draw card from deck
//    public boolean drawCard(int playerIndex) {
//        if (playerIndex == this.playerIndex) {
//            if (deck.size() > 0) {
//                playerHands.add(deck.remove(0));
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // Get the current player index
//    public int getCurrentPlayerIndex () {
//        return playerIndex;
//    }
//
//    // Set the current player index
//    public void setCurrentPlayerIndex ( int currentPlayerIndex){
//        this.playerIndex = currentPlayerIndex;
//    }
//
//    public int getOpponentIndex () {
//        return opponentIndex;
//    }
//
//    // Set the current player index
//    public void setOpponentIndex ( int opponentIndex){
//        this.opponentIndex = opponentIndex;
//    }
//
//
//    // Get the player scores
//    public int getPlayerScore (int playerScore){
//        return playerScore;
//    }
//    public int getOpponentScore () {
//        return opponentScore;
//    }
//
//    // Set the player scores
//    public void setPlayerScore (int playerScore){
//        this.playerScore = playerScore;
//    }
//
//    // Check if the game is over
//    public boolean isGameOver() {
//        return gameOver;
//    }
//
//    // Set the game over state
//    public void setGameOver(boolean gameOver){
//        this.gameOver = gameOver;
//    }
//
//    //This toString print the state of the game.
//    //String concatenation?! THIS MIGHT BE WRONG HEHE, IDK WHAT I'M DOING
//    @Override
//    public String toString() {
//        return "GameState{" +
//                "playerIndex=" + playerIndex +
//                ", opponentIndex=" + opponentIndex +
//                ", deck=" + deck +
//                ", playerHands=" + playerHands +
//                ", opponentHands=" + opponentHands +
//                ", playerScore=" + playerScore +
//                ", opponentScore=" + opponentScore +
//                ", gameOver=" + gameOver +
//                '}';
//    }
