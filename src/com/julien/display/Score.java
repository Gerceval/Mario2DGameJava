package com.julien.display;

public class Score {

    private final int totalCoins = 10;

    private int nbrCoins;

    public Score() {
        this.nbrCoins = 0;
    }

    // GETTERS & SETTERS
    public int getTotalCoins() {
        return totalCoins;
    }

    public int getNbrCoins() {
        return nbrCoins;
    }

    public void setNbrCoins(int nbrCoins) {
        this.nbrCoins = nbrCoins;
    }
}
