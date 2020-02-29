package org.jpr.poker.test;

import com.google.common.io.Resources;
import org.jpr.poker.card.CardHandFileReader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author prabeenjayaraj
 * Class to test reading the card hand from file
 */
public class CardHandFileReaderTest {


    @Test
    public void onTestReadCardHandFromFile() throws IOException {
        File file = new File(Resources.getResource("pokerCardHand.txt").getFile());
        CardHandFileReader cardHandFileReader = new CardHandFileReader();
        List<String> cardStrList = cardHandFileReader.cardHandFileReader(file.getPath());
        Assert.assertNotNull(cardStrList);
        Assert.assertTrue(cardStrList.size() > 0);
    }
}
