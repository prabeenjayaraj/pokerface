package org.jpr.poker.test;

import org.jpr.poker.card.CardHand;
import org.jpr.poker.card.CardValidator;
import org.jpr.poker.exception.InvalidCardSetException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

/**
 * @author prabeenjayaraj
 * Test to Ensure that the Values passed to create the cards is correct
 */
public class CardValidatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void onTestValidCardHand() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("3H JS 3C 7C 5D");
        Assert.assertNotNull(cardHand);
    }


    @Test
    public void onTest_InvalidCardHand_Duplicates() throws InvalidCardSetException {
        expectedException.expectMessage("Duplicate/Number of Cards Given to the Hand is 4, Pls Input 5 Cards Per Hand");
        expectedException.expect(InvalidCardSetException.class);
        CardHand.cardBuilder().buildHand("AH AH 7C 6C 4C");
    }


    @Test
    public void onTestValidCardHand_1() throws InvalidCardSetException {
        CardHand cardHand = CardHand.cardBuilder().buildHand("4S 3H 3C 7C 5D");
        Assert.assertNotNull(cardHand);
    }

    @Test
    public void onTestInvalidCardHand() throws InvalidCardSetException {
        expectedException.expect(InvalidCardSetException.class);
        expectedException.expectMessage("Card Symbol/Rank values passed are not as expected");
        CardHand.cardBuilder().buildHand("3F JS 3C 7C 5D");
    }

    @Test
    public void onTestInvalidCardHand_2() throws InvalidCardSetException {
        expectedException.expect(InvalidCardSetException.class);
        expectedException.expectMessage("Card Symbol/Rank values passed are not as expected");
        CardHand.cardBuilder().buildHand("4F 3F 3C 7C 5D");
    }

    @Test
    public void onTestParseCardStr_Invalid_length() throws InvalidCardSetException {
        String handString = "3HH JFFS C C 5DDD";
        CardValidator cardValidator = new CardValidator();
        boolean isValidStr = cardValidator.validateParsedStringList(Arrays.asList(handString.split(" ")));
        Assert.assertFalse(isValidStr);
    }
}
