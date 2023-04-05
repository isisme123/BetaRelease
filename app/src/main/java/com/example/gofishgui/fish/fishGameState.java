package com.example.gofishgui.fish;
import java.util.ArrayList;
import java.util.List;

public class fishGameState {
    // Instance variables
    private int currentPlayer;

    public ArrayList<FishCard> deck;
    public ArrayList<FishCard> humanHand; //Map of the player ID to their hand of cards
    public ArrayList<FishCard> computerHand;
    //private Map<Integer, Integer> playerScores; // ..scores?!
    private int playerScore;
    private int opponentScore;
    private boolean gameOver;
    //private FishDeck deck;

    public fishGameState(int currentPlayer, ArrayList<FishCard> deck, ArrayList<FishCard> humanHand, ArrayList<FishCard> computerHand,
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
        this.deck = p.deck;
        this.humanHand = p.humanHand;
        this.computerHand = p.computerHand;
        this.currentPlayer = p.currentPlayer;
        this.playerScore = p.playerScore;
        this.opponentScore = p.opponentScore;
        this.gameOver = p.gameOver;
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

    public void setDeck(ArrayList<FishCard> deck) {
        this.deck = deck;
    }

    public void setHumanHand(ArrayList<FishCard> humanHand) {
        this.humanHand = humanHand;
    }

    public void setComputerHand(ArrayList<FishCard> computerHand) {
        this.computerHand = computerHand;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setOpponentScore(int opponentScore) {
        this.opponentScore = opponentScore;
    }
}
