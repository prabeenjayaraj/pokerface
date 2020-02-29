package org.jpr.poker.test;

import org.jpr.poker.card.Card;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author prabeenjayaraj
 * Class to Test the Card creation
 */
public class CardTest {

    @Test
    public void onTestCreateCard() {
        String cardString = "AD";
        Card card = new Card(String.valueOf(cardString.charAt(0)), String.valueOf(cardString.charAt(1)));
        Assert.assertNotNull(card);
        Assert.assertEquals("A", card.getRank());
        Assert.assertEquals("D", card.getSymbol());
    }

    @Test
    public void onTestRankSymbolValue_Ace() {
        String cardString = "AD";
        Card card = new Card(String.valueOf(cardString.charAt(0)), String.valueOf(cardString.charAt(1)));
        Assert.assertNotNull(card);
        Assert.assertEquals("A", card.getRank());
        Assert.assertEquals("14", card.getRankValue());
        Assert.assertEquals("D", card.getSymbol());
    }

    @Test
    public void onTestRankSymbolValue_Jack() {
        String cardString = "JD";
        Card card = new Card(String.valueOf(cardString.charAt(0)), String.valueOf(cardString.charAt(1)));
        Assert.assertNotNull(card);
        Assert.assertEquals("J", card.getRank());
        Assert.assertEquals("11", card.getRankValue());
        Assert.assertEquals("D", card.getSymbol());
    }

    @Test
    public void onTestCard_Equals() {
        String cardString = "JD";
        Card card = new Card(String.valueOf(cardString.charAt(0)), String.valueOf(cardString.charAt(1)));
        Card cardDuplicate = new Card(String.valueOf(cardString.charAt(0)), String.valueOf(cardString.charAt(1)));

        Assert.assertTrue(card.equals(cardDuplicate));
    }


    @Test(expected = NullPointerException.class)
    public void onTestCard_Null() {
        Card card = new Card(null, null);
    }
}
