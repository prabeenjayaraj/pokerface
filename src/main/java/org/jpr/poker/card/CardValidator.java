package org.jpr.poker.card;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author prabeenjayaraj
 * Validate the CardHand
 */
public class CardValidator {

    public boolean validateCardSet(Set<Card> cardSet) {
        Set<Card> validatedCardSet = cardSet.stream()
                .filter(card -> CardValueRange.CARD_RANK_REFERENCE.contains(card.getRankValue())
                        && CardValueRange.CARD_SUIT_REFERENCE.contains(card.getSymbol()))
                .collect(Collectors.toSet());

        if (cardSet.size() != validatedCardSet.size()) {
            return false;
        }

        return true;
    }

    public boolean validateParsedStringList(List<String> parsedCardStrList) {
        long cardStrLength = parsedCardStrList.stream()
                .filter(cardStr -> cardStr.length() != 2).count();

        if (cardStrLength > 0) {
            return false;
        }

        return true;
    }
}
