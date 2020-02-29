package org.jpr.poker.card;

/**
 * @author prabeenjayaraj
 * The Card Rank is held as Enum to cater to the rank of the cards like Ace, Jack King, Queen
 * with Number Values
 */
public enum CardRank {

    TEN("T", "10"),
    JACK("J", "11"),
    QUEEN("Q", "12"),
    KING("K", "13"),
    ACE("A", "14"),
    NINE("9", "9"),
    EIGHT("8", "8"),
    SEVEN("7", "7"),
    SIX("6", "6"),
    FIVE("5", "5"),
    FOUR("4", "4"),
    THREE("3", "3"),
    TWO("2", "2");


    private String rank;
    private String rankValue;

    CardRank(String rank, String rankValue) {
        this.rank = rank;
        this.rankValue = rankValue;
    }

    public String getRank() {
        return rank;
    }

    public String getRankValue() {
        return rankValue;
    }
}
