package org.jpr.poker.card;

import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.jpr.poker.exception.InvalidCardSetException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * * @author prabeenjayaraj
 * CardHand which will hold the given list of player card
 * It should Have only 5 cards
 * This CardHand will be built only using the CardBuilder
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CardHand {

    // Having it as a set to ensure there is no duplicate card
    // Given as input
    @NonNull
    private Set<Card> cardSet;


    public static CardHandBuilder cardBuilder() {
        return new CardHandBuilder();
    }

    /**
     * Build Class to build the Card Hand
     * The CardHand cannot be built on its own , but only thro
     * the builder . This will build the cardHand with validation
     */

    public static class CardHandBuilder {

        CardValidator cardValidator = new CardValidator();

        public CardHand buildHand(String handString) throws InvalidCardSetException {

            List<String> parsedHandStrList = parseHandString(handString);

            boolean isValidCardStrLength = cardValidator.validateParsedStringList(parsedHandStrList);

            if (!isValidCardStrLength) {
                throw new InvalidCardSetException("Hand Card Strings Passed should all be of length 2, " +
                        "You Have Passed Invalid Length ");
            }



            Set<Card> cardSet = parsedHandStrList.stream().map(
                    cardStr -> new Card(String.valueOf(cardStr.charAt(0)), String.valueOf(cardStr.charAt(1))))
                    .collect(Collectors.toSet());

            if (cardSet.size() != 5) {
                throw new InvalidCardSetException("Duplicate/Number of Cards Given to the Hand is "
                        + cardSet.size() + ", Pls Input 5 Cards Per Hand");
            }


            if (!cardValidator.validateCardSet(cardSet)) {
                throw new InvalidCardSetException("Card Symbol/Rank values passed are not as expected");
            }

            return new CardHand(cardSet);


        }


        public List<String> parseHandString(String handString) throws InvalidCardSetException {
            if (Strings.isNullOrEmpty(handString)) {
                throw new InvalidCardSetException("Empty or Null Data Passed for the Card String");
            }
            return Arrays.asList(handString.split(" "));
        }
    }
}
