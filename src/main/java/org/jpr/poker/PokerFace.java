package org.jpr.poker;

import com.google.common.base.Strings;
import org.jpr.poker.card.CardHand;
import org.jpr.poker.card.CardHandFileReader;
import org.jpr.poker.exception.InvalidCardSetException;
import org.jpr.poker.hand.PokerHandFinder;

import java.io.IOException;
import java.util.List;

/**
 * @author prabeenjayaraj
 * Main Entry Class that will read the given input file
 * and create the cardhand
 * and find the PokerHand
 */
public class PokerFace {

    public static void main(String[] arg) throws IOException, InvalidCardSetException {

        if (arg.length == 0) {
            System.out.println("******** Pls Provide the Input Path for the CardHand ******* ");
            System.exit(1);
        }

        String cardHandFilePath = arg[0];
        if (Strings.isNullOrEmpty(cardHandFilePath)) {
            System.out.println("******* Pls Provide the Input Path for the CardHand ***** ");
        }

        CardHandFileReader cardHandFileReader = new CardHandFileReader();
        List<String> cardHandStrList = cardHandFileReader.cardHandFileReader(cardHandFilePath);
        for (String cardHandStr : cardHandStrList) {
            try {
                CardHand cardHand = CardHand.cardBuilder().buildHand(cardHandStr);
                PokerHandFinder pokerHandFinder = new PokerHandFinder();
                String pokerHand = pokerHandFinder.findPokerHand(cardHand);
                System.out.println("For Given Card Hand Str : " + cardHandStr + " Poker Hand Found : " + pokerHand);
            } catch (InvalidCardSetException exp) {
                System.out.println("Given Card Str : " + cardHandStr +
                        " IS NOT Valid See the Exception Message ->  " + exp.getMessage());

            }

        }


    }
}
