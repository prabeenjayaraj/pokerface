package org.jpr.poker.card;

/**
 * @author prabeenjayaraj
 * Holds the Card Suit symbol to be be more readable
 */
public enum CardSuit {

    HEART("H"),
    SPADE("S"),
    CLUB("C"),
    DIAMOND("D");


    private String symbol;

    CardSuit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
