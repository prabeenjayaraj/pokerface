package org.jpr.poker.utils;

import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
import org.jpr.poker.card.CardRank;
import org.jpr.poker.card.CardSuit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.github.benas.randombeans.FieldDefinitionBuilder.field;
import static io.github.benas.randombeans.api.EnhancedRandom.random;

/**
 * @author prabeenjayaraj
 * Util Generator Class to Generate random Cards for the Poker Hand
 */
public class RandomCardGenerator {

    public List<String> randomCardGenerator(int handLimit) throws IOException {

        EnhancedRandomBuilder builder = EnhancedRandomBuilder.aNewEnhancedRandomBuilder();
        EnhancedRandom enhancedRandom = builder.randomize(field().named("cardSuit").ofType(CardSuit.class).get(),
                (Randomizer<CardSuit>) () -> random(CardSuit.class))
                .randomize(field().named("cardRank").ofType(CardRank.class).get(),
                        (Randomizer<CardRank>) () -> random(CardRank.class))
                .build();

        List<String> randomHandStrList = new ArrayList<>();

        for (int i = 0; i < handLimit; i++) {
            randomHandStrList.add(generateRandomCardHand(enhancedRandom));
        }

        return randomHandStrList;

    }

    private String generateRandomCardHand(EnhancedRandom enhancedRandom) {
        StringBuilder cardHandStrBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            cardHandStrBuilder.append(enhancedRandom.nextObject(CardRank.class).getRank());
            cardHandStrBuilder.append(enhancedRandom.nextObject(CardSuit.class).getSymbol());
            cardHandStrBuilder.append(" ");
        }

        return cardHandStrBuilder.toString();
    }
}
