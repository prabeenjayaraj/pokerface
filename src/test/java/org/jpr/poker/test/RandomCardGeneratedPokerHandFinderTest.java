package org.jpr.poker.test;

import org.jpr.poker.card.CardHand;
import org.jpr.poker.exception.InvalidCardSetException;
import org.jpr.poker.hand.PokerHandFinder;
import org.jpr.poker.utils.RandomCardGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author prabeenjayaraj
 * Test to find the Poker Hand for the various randomly given input
 * card set
 */

public class RandomCardGeneratedPokerHandFinderTest {

    /**
     * This test doesnt assert against any expected value.
     * This is more to check to ensure that any random poker card hand either gives a Valid
     * Hand Type or throws and exception
     *
     * @throws InvalidCardSetException
     * @throws IOException
     */
    @Test
    public void onTest_Find_Poker_Hand_With_Random_Cards_Generated() throws InvalidCardSetException, IOException {
        RandomCardGenerator randomCardGenerator = new RandomCardGenerator();
        List<String> randomCardsHandList = randomCardGenerator.randomCardGenerator(500);

        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        for (String randomCardHand : randomCardsHandList) {
            try {
                CardHand cardHand = CardHand.cardBuilder().buildHand(randomCardHand);
                String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
                Assert.assertNotNull(pokerHandType);
                System.out.println("Random CardHand " + randomCardHand + " PokerHand: " + pokerHandType);
            } catch (InvalidCardSetException exception) {
                System.out.println("Random CardHand : " + randomCardHand
                        + " IS NOT Valid See the Exception Message ->  "
                        + exception.getMessage());
            }
        }

    }
}
