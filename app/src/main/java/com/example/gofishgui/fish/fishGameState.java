package com.example.gofishgui.fish;
import java.util.ArrayList;
import java.util.List;

public class fishGameState {
    // Instance variables
    private static fishGameState instance = null;

    private int currentPlayer;

    public ArrayList<FishCard> deck;
    public ArrayList<FishCard> humanHand; //Map of the player ID to their hand of cards
    public ArrayList<FishCard> computerHand;

    public int computerAsk;
    public ArrayList<Integer> priority = new ArrayList<>();
    public ArrayList<Integer> doNotAsk = new ArrayList<>();

    //private Map<Integer, Integer> playerScores; // ..scores?!
    public int playerScore;
    public int opponentScore;
    public boolean gameOver;

    fishGameState() {
        currentPlayer = 0;
        playerScore = 0;
        opponentScore = 0;
        gameOver = false;
        humanHand = new ArrayList<>();
        computerHand = new ArrayList<>();
        deck = new ArrayList<>();

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

    public static fishGameState getInstance() {
        if (instance == null) {
            instance = new fishGameState();
        }
        return instance;
    }

    public void startGame() {

    }

    public void nextPlayer() {
        if (getCurrentPlayer() == 0) {
            setCurrentPlayer(1);
        } else {
            setCurrentPlayer(0);
        }
    }

    public boolean isGameOver() {
        if (humanHand.isEmpty() || computerHand.isEmpty()) {
            return true;
        } else {
            return false;
        }
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

    public int getComputerAsk() {
        return computerAsk;
    }

    public void setComputerAsk(int computerAsk) {
        this.computerAsk = computerAsk;
    }

}
