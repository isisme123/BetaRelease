package com.example.gofishgui.fish;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class fishGameState {
    // Instance variables
    private int currentPlayer;

    public List<FishCard> deck;
    public List<FishCard> humanHand; //Map of the player ID to their hand of cards
    public List<FishCard> computerHand;
    //private Map<Integer, Integer> playerScores; // ..scores?!
    private int playerScore;
    private int opponentScore;
    private boolean gameOver;
    //private FishDeck deck;

    public fishGameState(int currentPlayer, List<FishCard> deck, List<FishCard> humanHand, List<FishCard> computerHand,
                         int playerScore, int opponentScore, boolean gameOver) {

        this.deck = deck;
        this.humanHand = humanHand;
        this.computerHand = computerHand;
        this.currentPlayer = currentPlayer;
        this.playerScore = playerScore;
        this.opponentScore = opponentScore;
        this.gameOver = gameOver;

    }

    public fishGameState(fishGameState p) {

    }

    public void startGame() {

    }

    public void nextPlayer() {
        if(currentPlayer == 0) {
            currentPlayer = 1;
        }
        else {
            currentPlayer = 0;
        }
    }

    public boolean isGamerOver() {
        return gameOver;
    }

    public List<FishCard> getDeck() {
        return deck;
    }

    public List<FishCard> getHumanHand() {
        return humanHand;
    }

    public List<FishCard> getComputerHand() {
        return computerHand;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getOpponentScore() {
        return opponentScore;
    }

    public void setDeck(List<FishCard> deck) {
        this.deck = deck;
    }

    public void setHumanHand(List<FishCard> humanHand) {
        this.humanHand = humanHand;
    }

    public void setComputerHand(List<FishCard> computerHand) {
        this.computerHand = computerHand;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }
}
