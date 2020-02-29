package org.jpr.poker.test;

import org.jpr.poker.card.Card;
import org.jpr.poker.card.CardHand;
import org.jpr.poker.card.CardHandGrouper;
import org.jpr.poker.exception.InvalidCardSetException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author prabeenjayaraj
 * Test the Card Grouping based on Rank or Suit
 */
public class CardHandGrouperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void onTestSortCardHandByRank() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("3H JS 3C 7C 5D");
        Card card1 = new Card("3", "H");
        Card card2 = new Card("3", "C");
        Card card3 = new Card("J", "S");
        Card card4 = new Card("7", "C");
        Card card5 = new Card("5", "D");

        Map<String, List<Card>> expectedGroupedHand = new HashMap<>();
        expectedGroupedHand.put("3", Arrays.asList(card1, card2));
        expectedGroupedHand.put("11", Arrays.asList(card3));
        expectedGroupedHand.put("7", Arrays.asList(card4));
        expectedGroupedHand.put("5", Arrays.asList(card5));

        CardHandGrouper cardHandGrouper = new CardHandGrouper();
        Map<String, List<Card>> actualGroupedHand = cardHandGrouper.groupByCardRank(cardHand);
        Assert.assertEquals(4, actualGroupedHand.size());
        Assert.assertEquals(expectedGroupedHand.size(), actualGroupedHand.size());
        Assert.assertTrue(expectedGroupedHand.keySet().equals(actualGroupedHand.keySet()));
    }

    @Test
    public void onTestSortCardHandByRank_Three() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("3H JS 3C 7C 3D");
        Card card1 = new Card("3", "H");
        Card card2 = new Card("3", "C");
        Card card3 = new Card("J", "S");
        Card card4 = new Card("7", "C");
        Card card5 = new Card("3", "D");

        Map<String, List<Card>> expectedGroupedHand = new HashMap<>();
        expectedGroupedHand.put("3", Arrays.asList(card1, card2, card5));
        expectedGroupedHand.put("11", Arrays.asList(card3));
        expectedGroupedHand.put("7", Arrays.asList(card4));

        CardHandGrouper cardHandGrouper = new CardHandGrouper();
        Map<String, List<Card>> actualGroupedHand = cardHandGrouper.groupByCardRank(cardHand);
        Assert.assertEquals(3, actualGroupedHand.size());
        Assert.assertEquals(expectedGroupedHand.size(), actualGroupedHand.size());
        Assert.assertTrue(expectedGroupedHand.keySet().equals(actualGroupedHand.keySet()));
    }

    @Test
    public void onTestSortCardHandByRank_Four() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("3H 3S 3C 8C 3D");
        Card card1 = new Card("3", "H");
        Card card2 = new Card("3", "C");
        Card card3 = new Card("3", "S");
        Card card4 = new Card("8", "C");
        Card card5 = new Card("3", "D");

        Map<String, List<Card>> expectedGroupedHand = new HashMap<>();
        expectedGroupedHand.put("3", Arrays.asList(card1, card2, card3, card4));
        expectedGroupedHand.put("8", Arrays.asList(card5));

        CardHandGrouper cardHandGrouper = new CardHandGrouper();
        Map<String, List<Card>> actualGroupedHand = cardHandGrouper.groupByCardRank(cardHand);
        Assert.assertEquals(2, actualGroupedHand.size());
        Assert.assertEquals(expectedGroupedHand.size(), actualGroupedHand.size());
        Assert.assertTrue(expectedGroupedHand.keySet().equals(actualGroupedHand.keySet()));
    }


    @Test
    public void onTestGroupCardHandBySuit() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("3H JS 3C 7C 5D");
        Card card1 = new Card("3", "H");
        Card card2 = new Card("3", "C");
        Card card3 = new Card("J", "S");
        Card card4 = new Card("7", "C");
        Card card5 = new Card("5", "D");

        Map<String, List<Card>> expectedGroupedHand = new HashMap<>();
        expectedGroupedHand.put("H", Arrays.asList(card1));
        expectedGroupedHand.put("S", Arrays.asList(card3));
        expectedGroupedHand.put("C", Arrays.asList(card2, card4));
        expectedGroupedHand.put("D", Arrays.asList(card5));

        CardHandGrouper cardHandGrouper = new CardHandGrouper();
        Map<String, List<Card>> actualGroupedHand = cardHandGrouper.groupByCardSuit(cardHand);
        Assert.assertEquals(4, actualGroupedHand.size());
        Assert.assertEquals(expectedGroupedHand.size(), actualGroupedHand.size());
        Assert.assertTrue(expectedGroupedHand.keySet().equals(actualGroupedHand.keySet()));
    }


    @Test
    public void onTestGroupCardHandBySuit_All_Same() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("3H 4H 5H 7H 6H");
        Card card1 = new Card("3", "H");
        Card card2 = new Card("4", "H");
        Card card3 = new Card("5", "H");
        Card card4 = new Card("7", "H");
        Card card5 = new Card("7", "H");

        Map<String, List<Card>> expectedGroupedHand = new HashMap<>();
        expectedGroupedHand.put("H", Arrays.asList(card1, card2, card3, card4, card5));

        CardHandGrouper cardHandGrouper = new CardHandGrouper();
        Map<String, List<Card>> actualGroupedHand = cardHandGrouper.groupByCardSuit(cardHand);
        Assert.assertEquals(1, actualGroupedHand.size());
        Assert.assertEquals(expectedGroupedHand.size(), actualGroupedHand.size());
        Assert.assertTrue(expectedGroupedHand.keySet().equals(actualGroupedHand.keySet()));
    }
}
