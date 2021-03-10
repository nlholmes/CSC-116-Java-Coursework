import static org.junit.Assert.assertEquals;

import org.junit.*;
import junit.framework.TestCase;

/**
 * This program tests SomewhatMoreSimplifiedSolitaire
 * 
 * Somewhat Simplified Solitaire Encryption and Decryption algorithm.
 * 
 * See: https://www.schneier.com/academic/solitaire/
 * 
 * @author Dr. Jason King
 * @author Dr. Jessica Young Schmidt
 *
 */
public class SomewhatMoreSimplifiedSolitaireTest extends TestCase {

    @Test
    public void testEncrypt() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Encrypt the message \"HELLO\"";
        String expected = "TPVPR";
        String actual = SomewhatMoreSimplifiedSolitaire.encrypt(deck, "HELLO");
        assertEquals(description, expected, actual);

        // TODO: Add Test Case
    }

    @Test
    public void testDecrypt() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Decrypt the message \"TPVPR\"";
        String expected = "HELLO";
        String actual = SomewhatMoreSimplifiedSolitaire.decrypt(deck, "TPVPR");
        assertEquals(description, expected, actual);

        // TODO: Add Test Case
    }

    @Test
    public void testMoveFirstJokerDownByOne() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Moving Joker A down by one when Joker A "
                + "is not the last card in the deck";
        String expected = "1 4 7 10 13 3 6 9 12 15 2 14 5 8 11";
        String actual = SomewhatMoreSimplifiedSolitaire.moveFirstJokerDownOne(deck);
        assertEquals(description, expected, actual);

        // TODO: Add Test Cases
    }

    @Test
    public void testMoveSecondJokerDownByTwo() {
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Moving Joker B down by two";
        String expected = "1 4 7 10 13 3 6 9 12 14 2 15 5 8 11";
        String actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testTripleCut() {
        // TODO: Add Test Cases
    }

    @Test
    public void testMoveToBack() {
        // TODO: Add Test Cases
    }

    @Test
    public void testGetKey() {
        // TODO: Add Test Cases
    }

    @Test
    public void testShuffle() {
        // TODO: Add Test Cases
    }

}
