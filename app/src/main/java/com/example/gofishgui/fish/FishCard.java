package com.example.gofishgui.fish;

public class FishCard {
    // Instances
    private String rank;
    private int value;

    // Constructor
    public FishCard(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    // Getters
    public String getRank() {
        return this.rank;
    }
    public int getValue() {
        return this.value;
    }

    // Setters
    public void setRank(String rank) {
        this.rank = rank;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
