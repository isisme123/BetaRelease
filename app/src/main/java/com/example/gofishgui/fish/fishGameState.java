package com.example.gofishgui.fish;
import java.util.ArrayList;
import java.util.List;

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

//    public fishGameState(int currentPlayer, List<FishCard> deck, List<FishCard> humanHand, List<FishCard> computerHand,
//                         int playerScore, int opponentScore, boolean gameOver) {
//
//        this.deck = deck;
//        this.humanHand = humanHand;
//        this.computerHand = computerHand;
//        this.currentPlayer = currentPlayer;
//        this.playerScore = playerScore;
//        this.opponentScore = opponentScore;
//        this.gameOver = gameOver;
//
//    }
    public fishGameState() {
        currentPlayer = 0;
        deck = null;
        humanHand = null; //Map of the player ID to their hand of cards
        computerHand = null;
        playerScore = 0;
        opponentScore = 0;
        gameOver = false;
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
        if(getCurrentPlayer() == 0) {
            setCurrentPlayer(1);
        }
        else {
            setCurrentPlayer(0);
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
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
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
