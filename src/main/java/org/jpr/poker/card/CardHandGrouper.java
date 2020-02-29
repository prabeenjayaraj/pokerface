package org.jpr.poker.card;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author prabeenjayaraj
 * This Class is used to group the given cards
 * either based on the rank or the suit
 */
public class CardHandGrouper {


    public Map<String, List<Card>> groupByCardRank(CardHand cardHand) {

        Map<String, List<Card>> cardGrouped = cardHand.getCardSet()
                .stream()
                .collect(Collectors.groupingBy(x -> x.getRankValue()));
        return cardGrouped;
    }


    public Map<String, List<Card>> groupByCardSuit(CardHand cardHand) {

        Map<String, List<Card>> cardGrouped = cardHand.getCardSet()
                .stream()
                .collect(Collectors.groupingBy(x -> x.getSymbol()));
        return cardGrouped;
    }
}
