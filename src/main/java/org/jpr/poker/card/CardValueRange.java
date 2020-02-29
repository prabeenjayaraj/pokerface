package org.jpr.poker.card;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * * @author prabeenjayaraj
 * Class used to hold the predefined rank of the
 * cards. Need this as card like ACE can be used as the highest or the lowest
 */
public final class CardValueRange {
    public static final List<String> CARD_RANK_REFERENCE = ImmutableList.of(
            CardRank.TWO.getRankValue(), CardRank.THREE.getRankValue(), CardRank.FOUR.getRankValue(),
            CardRank.FIVE.getRankValue(), CardRank.SIX.getRankValue(), CardRank.SEVEN.getRankValue(),
            CardRank.EIGHT.getRankValue(), CardRank.NINE.getRankValue(), CardRank.TEN.getRankValue(),
            CardRank.JACK.getRankValue(), CardRank.QUEEN.getRankValue(), CardRank.KING.getRankValue(),
            CardRank.ACE.getRankValue());
    public static final List<String> CARD_SUIT_REFERENCE = ImmutableList.of(CardSuit.CLUB.getSymbol(),
            CardSuit.DIAMOND.getSymbol()
            , CardSuit.HEART.getSymbol(), CardSuit.SPADE.getSymbol());

    public static final List<String> CARD_RANK_ORDER = ImmutableList.of(
            CardRank.TWO.getRankValue(), CardRank.THREE.getRankValue(),
            CardRank.FOUR.getRankValue(), CardRank.FIVE.getRankValue(),
            CardRank.ACE.getRankValue());
    // Use this to Check the Royal Flush
    public static final List<String> CARD_RANK_ORDER_1 = ImmutableList.of(CardRank.TEN.getRankValue(),
            CardRank.JACK.getRankValue(), CardRank.QUEEN.getRankValue(), CardRank.KING.getRankValue(),
            CardRank.ACE.getRankValue());
}
