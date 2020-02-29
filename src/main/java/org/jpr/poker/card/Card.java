package org.jpr.poker.card;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author prabeenjayaraj
 * Card Class to hold the given card
 * Have added another field of rank value to cater for ranks like A, J, K, Q as a numberical value
 * similar to the rest of the card ranks
 */

@Getter
@ToString
public class Card {
    @NonNull
    private String rank;
    @NonNull
    private String rankValue;
    @NonNull
    private String symbol;

    public Card(String rank, String symbol) {
        this.rank = rank;
        this.symbol = symbol;
        this.rankValue = replaceRankSymbolWithValue(rank);
    }

    private String replaceRankSymbolWithValue(String rankSymbol) {
        return rankSymbol.replace("T", CardRank.TEN.getRankValue())
                .replace("K", CardRank.KING.getRankValue())
                .replace("Q", CardRank.QUEEN.getRankValue())
                .replace("J", CardRank.JACK.getRankValue())
                .replace("A", CardRank.ACE.getRankValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }

        Card card = (Card) o;

        if (!getRank().equals(card.getRank())) {
            return false;
        }
        if (!getRankValue().equals(card.getRankValue())) {
            return false;
        }
        return getSymbol().equals(card.getSymbol());
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = 31 * result + getRank().hashCode();
        result = 31 * result + getRankValue().hashCode();
        result = 31 * result + getSymbol().hashCode();
        return result;
    }
}
