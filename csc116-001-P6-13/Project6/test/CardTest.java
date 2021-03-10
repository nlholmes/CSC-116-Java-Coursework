import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Nathan Holmes
 */
public class CardTest extends TestCase {

    /** card two of hearts for testing */
    private Card twoOfHearts;

    // Ace of spades
    /** card ace of spades for testing */
    private Card aceOfSpades;
    
    /**
     * Create cards for testing
     */
    @Before
    public void setUp() {
        twoOfHearts = new Card(2, 'h');
        // Ace of spades
        aceOfSpades = new Card(14, 's');
    }

    @Test
    public void testConstants() {
        // The following tests test that constants are defined as specified
        assertEquals("CLUBS", 'c', Card.CLUBS);
        assertEquals("DIAMONDS", 'd', Card.DIAMONDS);
        assertEquals("SPADES", 's', Card.SPADES);
        assertEquals("HEARTS", 'h', Card.HEARTS);
        assertEquals("LOWEST_VALUE", 2, Card.LOWEST_VALUE);
        assertEquals("HIGHEST_VALUE]", 14, Card.HIGHEST_VALUE);
    }


    @Test
    public void testConstructorPreConditions() {
        try {
            new Card(1, 'h');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid value",
                    e.getMessage());
        }

        try {
            new Card(15, 's');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid value",
                    e.getMessage());
        }

        try {
            new Card(5, 'x');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid suit",
                    e.getMessage());
        }       

        try {
            new Card(8, 'D');
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid suit",
                    e.getMessage());
        }
    }

    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals("twoOfHearts value", 2, twoOfHearts.getValue());
    }
    // Ace of spades
    @Test
    public void testGetValuAceOfSpades() {
        assertEquals("aceOfSpades value", 14, aceOfSpades.getValue());
    }
    
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals("twoOfHearts suit", 'h', twoOfHearts.getSuit());
    }
    // Ace of spades
    @Test
    public void testGetSuitAceOfSpades() {
        assertEquals("aceOfSpades suit", 's', aceOfSpades.getSuit());
    }
    
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("twoOfHearts toString", "h2", twoOfHearts.toString());
    }
    // Ace of spades
    @Test
    public void testToStringAceOfSpades() {
        assertEquals("aceOfSpades toString", "s14", aceOfSpades.toString());
    }
    
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue("twoOfHearts equals with same instance", twoOfHearts.equals(twoOfHearts));
        assertTrue("twoOfHearts equals with different instances", 
                   twoOfHearts.equals(new Card(2, 'h')));
        assertFalse("twoOfHearts with different value", twoOfHearts.equals(new Card(4, 'h')));
        assertFalse("twoOfHearts with different suit", twoOfHearts.equals(new Card(2, 's')));
        assertFalse("twoOfHearts with different value and suit", 
                    twoOfHearts.equals(new Card(5, 'c')));
        assertFalse("twoOfHearts compared to null object", twoOfHearts.equals(null));
        assertFalse("twoOfHearts compared to String", twoOfHearts.equals("twoOfHearts"));
    }
    // Ace of spades
    @Test
    public void testEqualsAceOfSpades() {
        assertTrue("aceOfSpades equals with same instance", aceOfSpades.equals(aceOfSpades));
        assertTrue("aceOfSpades equals with different instances", 
                   aceOfSpades.equals(new Card(14, 's')));
        assertFalse("aceOfSpades with different value", aceOfSpades.equals(new Card(9, 's')));
        assertFalse("aceOfSpades with different suit", aceOfSpades.equals(new Card(4, 'h')));
        assertFalse("aceOfSpades with different value and suit", 
                    twoOfHearts.equals(new Card(5, 'c')));
        assertFalse("aceOfSpades compared to null object", aceOfSpades.equals(null));
        assertFalse("aceOfSpades compared to String", aceOfSpades.equals("aceOfSpades"));
    }

}
