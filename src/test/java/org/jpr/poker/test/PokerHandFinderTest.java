package org.jpr.poker.test;

import org.jpr.poker.card.CardHand;
import org.jpr.poker.exception.InvalidCardSetException;
import org.jpr.poker.hand.PokerHandFinder;
import org.jpr.poker.hand.PokerHandType;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author prabeenjayaraj
 * Test to find the Poker Hand for the various given input
 * card set
 */

public class PokerHandFinderTest {

    @Test
    public void onTestOnePairHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "3H JS 3C 7C 5D";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String isOnePairHand = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.ONE_PAIR, isOnePairHand);
    }

    @Test
    public void onTestTwoPairHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "JH 2C JD 2H 4C";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.TWO_PAIR, pokerHandType);
    }


    @Test
    public void onTestFullHouse_Eventhough_There_IsThree_Of_A_Kind() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "JH 2C JD 2H JC";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.FULL_HOUSE, pokerHandType);
    }

    @Test
    public void onTestFourOfAKindHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "JH JS JD 2H JC";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.FOUR_OF_KIND, pokerHandType);

    }

    @Test
    public void onTestFullHouseHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "JH JS JD 2H 2C";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.FULL_HOUSE, pokerHandType);

    }

    @Test
    public void onTestStraightHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "TD KS QH JD AC";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.STRAIGHT, pokerHandType);
    }

    @Test
    public void onTestRoyalFlushHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "TH JH QH KH AH";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.ROYAL_FLUSH, pokerHandType);
    }

    @Test
    public void onTestStraightFlushHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "6H 7H 8H 9H TH";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.STRAIGHT_FLUSH, pokerHandType);
    }

    @Test
    public void onTestFlushHand() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "3H 7H 9H JH KH";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.FLUSH, pokerHandType);
    }

    @Test
    public void onTestFindPokerHand_Flush() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "3H 7H 9H JH KH";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.FLUSH, pokerHandType);
    }


    @Test
    public void onTestFindPokerHand_HighCard() throws InvalidCardSetException {
        PokerHandFinder pokerHandFinder = new PokerHandFinder();
        String handString = "7D 8S 5H JC KH";
        CardHand cardHand = CardHand.cardBuilder().buildHand(handString);
        String pokerHandType = pokerHandFinder.findPokerHand(cardHand);
        Assert.assertEquals(PokerHandType.HIGH_CARD, pokerHandType);
    }

}
