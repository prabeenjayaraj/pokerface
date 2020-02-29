package org.jpr.poker.test;

import org.jpr.poker.card.CardHand;
import org.jpr.poker.exception.InvalidCardSetException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author prabeenjayaraj
 * Test the building of the Card Hand
 * Also ensure that invalid data passed are caught and appropriate exception is thrown
 */
public class CardHandbuilderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void onTestParseAndBuildACardHand() throws InvalidCardSetException {
        String handString = "3H JS 3C 7C 5D";
        CardHand hand = CardHand.cardBuilder().buildHand(handString);
        Assert.assertNotNull(hand);
        Assert.assertEquals(5, hand.getCardSet().size());
    }


    @Test
    public void onTestParseAndBuildACardHand_Less_Cards() throws InvalidCardSetException {
        expectedException.expect(InvalidCardSetException.class);
        expectedException.expectMessage("Number of Cards Given to the Hand is 4, Pls Input 5 Cards Per Hand");

        String handString = "3H JS 3C 7C";
        CardHand hand = CardHand.cardBuilder().buildHand(handString);
        Assert.assertNotNull(hand);
        Assert.assertEquals(5, hand.getCardSet().size());
    }

    @Test
    public void onTestParseEmptyString() throws InvalidCardSetException {
        expectedException.expect(InvalidCardSetException.class);
        expectedException.expectMessage("Empty or Null Data Passed for the Card String");

        CardHand hand = CardHand.cardBuilder().buildHand("");
    }

    @Test
    public void onTestParseNullString() throws InvalidCardSetException {
        expectedException.expect(InvalidCardSetException.class);
        expectedException.expectMessage("Empty or Null Data Passed for the Card String");

        CardHand hand = CardHand.cardBuilder().buildHand(null);
    }


}
