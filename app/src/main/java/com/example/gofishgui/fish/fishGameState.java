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

    public void startGame() {

    }

    public void playGame() {

    }

    public void nextPlayer() {

    }

    public boolean isGamerOver() {

    }


}
