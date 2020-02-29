package org.jpr.poker.hand;

import com.google.common.collect.Iterables;
import org.jpr.poker.card.CardHand;
import org.jpr.poker.card.CardHandGrouper;
import org.jpr.poker.card.Card;
import org.jpr.poker.card.CardValueRange;
import org.jpr.poker.card.CardRank;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author prabeenjayaraj
 * This Class is the main class which is used to find the Poker Hand.
 * based on the given card Hand
 */
public class PokerHandFinder {


    CardHandGrouper cardHandGrouper;

    public PokerHandFinder() {
        this.cardHandGrouper = new CardHandGrouper();
    }

    public String findPokerHand(CardHand cardHand) {

        Map<String, List<Card>> cardGroupByRank = cardHandGrouper.groupByCardRank(cardHand);

        String pokerHandType = findPokerHandType(cardGroupByRank, cardHand);

        if (PokerHandType.ROYAL_FLUSH.equals(pokerHandType)) {
            return PokerHandType.ROYAL_FLUSH;
        }
        if (PokerHandType.STRAIGHT_FLUSH.equals(pokerHandType)) {
            return PokerHandType.STRAIGHT_FLUSH;
        }
        if (isFourOfKindHand(cardGroupByRank)) {
            return PokerHandType.FOUR_OF_KIND;
        }
        if (isFullHouseHand(cardGroupByRank)) {
            return PokerHandType.FULL_HOUSE;
        }
        if (PokerHandType.FLUSH.equals(pokerHandType)) {
            return PokerHandType.FLUSH;
        }
        if (PokerHandType.STRAIGHT.equals(pokerHandType)) {
            return PokerHandType.STRAIGHT;
        }
        if (isThreeOfKindHand(cardGroupByRank)) {
            return PokerHandType.THREE_OF_KIND;
        }
        if (isTwoPairHand(cardGroupByRank)) {
            return PokerHandType.TWO_PAIR;
        }
        if (isOnePairHand(cardGroupByRank)) {
            return PokerHandType.ONE_PAIR;
        }

        return PokerHandType.HIGH_CARD;

    }


    /**
     * OnePair Hand is when have 2 Cards of the Same Rank and any Symbol.
     * We need to Group the Cards By Rank and find a single pair.
     *
     * @return
     */
    private boolean isOnePairHand(Map<String, List<Card>> groupedCardHand) {
        int pairCount = 0;
        for (Map.Entry<String, List<Card>> entry : groupedCardHand.entrySet()) {
            if (entry.getValue().size() == 2) {
                pairCount++;
            }
        }

        if (pairCount == 1) {
            return true;
        }

        return false;
    }

    /**
     * TwoPair Hand is when have 2 Cards of One Rank and Another 2 Cards of a different Rank.
     * We need to Group the Cards By Rank and find a single pair
     *
     * @return
     */
    private boolean isTwoPairHand(Map<String, List<Card>> groupedCardHand) {
        int pairCount = 0;

        for (Map.Entry<String, List<Card>> entry : groupedCardHand.entrySet()) {
            if (entry.getValue().size() == 2) {
                pairCount++;
            }

        }

        if (pairCount == 2) {
            return true;
        }
        return false;
    }


    /**
     * Three Of a Kind is when have 3 Cards of One Rank and rest 2 Cards of a different Ranks.
     * We need to Group the Cards By Rank and find a 3 Cards of the Same Rank.
     *
     * @return
     */
    private boolean isThreeOfKindHand(Map<String, List<Card>> groupedCardHand) {

        for (Map.Entry<String, List<Card>> entry : groupedCardHand.entrySet()) {
            if (entry.getValue().size() == 3) {
                return true;
            }

        }

        return false;
    }

    /**
     * Four Of a Kind is when have 4 Cards of One Rank and other Card of a different Rank.
     * We need to Group the Cards By Rank and find a 4 Cards of the Same Rank.
     *
     * @return
     */
    private boolean isFourOfKindHand(Map<String, List<Card>> groupedCardHand) {

        for (Map.Entry<String, List<Card>> entry : groupedCardHand.entrySet()) {
            if (entry.getValue().size() == 4) {
                return true;
            }
        }

        return false;
    }


    /**
     * FullHouse Hand is when have 3 Cards of One Rank and 2 Card of a another Rank.
     * We need to Group the Cards By Rank
     *
     * @return
     */
    private boolean isFullHouseHand(Map<String, List<Card>> groupedCardHand) {

        boolean threeCard = false;
        boolean twoCard = false;

        for (Map.Entry<String, List<Card>> entry : groupedCardHand.entrySet()) {
            if (entry.getValue().size() == 2) {
                twoCard = true;
            }

            if (entry.getValue().size() == 3) {
                threeCard = true;
            }

        }

        if (twoCard && threeCard) {
            return true;
        }

        return false;

    }


    /**
     * Group By Symbol .
     * We need to Group the Cards By Rank
     *
     * @return
     */
    private String findPokerHandType(Map<String, List<Card>> groupedCardHandByRank, CardHand cardHand) {

        if (groupedCardHandByRank.size() != 5) {
            return PokerHandType.NOT_FLUSH;
        }

        Map<String, List<Card>> groupedCardHandBySymbol = cardHandGrouper.groupByCardSuit(cardHand);

        List<String> cardRankList = cardHand.getCardSet().stream()
                .map(card -> card.getRankValue())
                .collect(Collectors.toList());

        // Sort the Card's Rank based on  the reference Rank
        Collections.sort(cardRankList,
                Comparator.comparing(rank -> CardValueRange.CARD_RANK_REFERENCE.indexOf(rank)));

        String lastValue = Iterables.getLast(cardRankList);


        // If All the Symbols are not the SAME Then it is a STRAIGHT
        if (groupedCardHandBySymbol.size() > 1) {
            boolean isStraight = isSequenceChecker(cardRankList);
            if (isStraight) {
                return PokerHandType.STRAIGHT;
            }

        } else if (groupedCardHandBySymbol.size() == 1) {
            if (lastValue.equals(CardRank.ACE.getRankValue())) {
                if (CardValueRange.CARD_RANK_ORDER_1.equals(cardRankList)) {
                    return PokerHandType.ROYAL_FLUSH;
                }
            } else {
                boolean isStraightFlush = isSequenceChecker(cardRankList);
                if (isStraightFlush) {
                    return PokerHandType.STRAIGHT_FLUSH;
                } else {
                    return PokerHandType.FLUSH;
                }


            }
        }


        return PokerHandType.NOT_FLUSH;

    }

    /**
     * Method to help in checking the sequence of the card ranks .
     *
     * @param cardRankList
     * @return
     */
    private boolean isSequenceChecker(List<String> cardRankList) {

        String lastValue = Iterables.getLast(cardRankList);

        if (lastValue.equals(CardRank.ACE.getRankValue())) {
            if (CardValueRange.CARD_RANK_ORDER.equals(cardRankList) ||
                    CardValueRange.CARD_RANK_ORDER_1.equals(cardRankList)) {
                return true;
            }
        }
        // the ranks should be sequential
        int initialRank = Integer.parseInt(cardRankList.get(0));
        initialRank++;
        boolean isSequential = true; // Set to true , unless proven that it is not by the below
        for (int i = 1; i < 5; i++) {
            if (Integer.parseInt(cardRankList.get(i)) != initialRank) {
                isSequential = false;
                break;
            }
            initialRank++;
        }
        return isSequential;
    }
}
