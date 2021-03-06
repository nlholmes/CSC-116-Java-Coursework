import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Hand class
 * @author Suzanne Balik
 * @author Nathan Holmes
 */
public class HandTest extends TestCase {
    
    /** hand for testing */
    private Hand hand;

    /**
     * Creates hand for testing
     */
    @Before
    public void setUp() {
        Card[] cards = {new Card(2,'c'), new Card(3,'d'), new Card(4,'s'), new Card(5,'h'), 
                        new Card(6,'c')};
        hand = new Hand(cards);
    }

    @Test
    public void testConstants() {
        // The following test tests that the constant is defined as specified
        assertEquals("CARDS_IN_HAND", 5, Hand.CARDS_IN_HAND);
    }

    @Test
    public void testConstructorPreConditions() {
        try {
            new Hand(null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Correct NullPointerException message", "Null array",
                    e.getMessage());
        }

        try {
            new Hand(new Card[6]);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid array length",
                    e.getMessage());
        }

        try {
            new Hand(new Card[5]);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Correct NullPointerException message", "Null element",
                    e.getMessage());
        }       
    }

    @Test
    public void testGetCardPreConditions() {
        try {
            Card c = hand.getCard(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid index",
                    e.getMessage());
        }

        try {
            Card c = hand.getCard(5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid index",
                    e.getMessage());
        }

        try {
            Card c = hand.getCard(8);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid index",
                    e.getMessage());
        }
    }

    @Test
    public void testGetCard() {
        assertEquals("Card ", new Card(2,'c'), hand.getCard(0));
        assertEquals("Card ", new Card(3,'d'), hand.getCard(1));
        assertEquals("Card ", new Card(4,'s'), hand.getCard(2));
        assertEquals("Card ", new Card(5,'h'), hand.getCard(3));
        assertEquals("Card ", new Card(6,'c'), hand.getCard(4));
    }

    @Test
    public void testReplacePreConditions() {
        try {
            hand.replace(1, null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Correct NullPointerException message", "Null card",
                    e.getMessage());
        }
        
        try {
            Card c = hand.getCard(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid index",
                    e.getMessage());
        }

        try {
            Card c = hand.getCard(5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid index",
                    e.getMessage());
        }

        try {
            Card c = hand.getCard(8);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid index",
                    e.getMessage());
        }
    }

    @Test
    public void testReplace() {
        hand.replace(2, new Card(8, 'h'));
        assertEquals("Card ", new Card(8,'h'), hand.getCard(2));
    }

    @Test
    public void testToString() {
        assertEquals("toString  after constructed",
                     "[c2, d3, s4, h5, c6]", hand.toString());
    }

    @Test
    public void testEquals() {
        Card[] cards = {new Card(2,'c'), new Card(3,'d'), new Card(4,'s'), new Card(5,'h'), 
                        new Card(6,'c')};
        Hand sameHand = new Hand(cards);
        Card[] differentCards = {new Card(10,'c'), new Card(3,'d'), new Card(14,'s'), 
                                 new Card(5,'h'), new Card(6,'c')};
        Hand differentHand = new Hand(differentCards);
        assertTrue("hand equals with same instance", hand.equals(hand));
        assertTrue("hand equals with different instances", hand.equals(sameHand));
        assertFalse("hand with different hand", hand.equals(differentHand));
        assertFalse("hand compared to null object", hand.equals(null));
        assertFalse("hand compared to String", hand.equals("Hand"));
    }

    @Test 
    public void testIsFlush() {
        Card[] cards = {new Card(2,'c'), new Card(3,'c'), new Card(10,'c'), new Card(12,'c'), 
                        new Card(6,'c')};
        Hand flushHand = new Hand(cards);
        assertTrue("Flush hand", flushHand.isFlush());
        assertFalse("Not flush hand", hand.isFlush());
    } 
    
    // straight
    @Test
    public void testIsStraight() {
        Card[] cards = {new Card(2,'c'), new Card(2,'s'), new Card(4,'h'), new Card(5,'c'), 
                        new Card(6,'c')};
        Hand notStraightHand = new Hand(cards);
        assertTrue("Straight hand", hand.isStraight());
        assertFalse("Not Straight hand", notStraightHand.isStraight());
    }
    // straight flush
    @Test
    public void testIsStraightFlush() {
        Card[] cards = {new Card(2,'c'), new Card(3,'c'), new Card(4,'c'), new Card(5,'c'), 
                        new Card(6,'c')};
        Hand straightFlushHand = new Hand(cards);
        assertTrue("Straight Flush hand", straightFlushHand.isStraightFlush());
        assertFalse("Not Straight Flush hand", hand.isStraightFlush());
    }
    // royal flush
    @Test
    public void testIsRoyalFlush() {
        Card[] cards = {new Card(10,'c'), new Card(11,'c'), new Card(12,'c'), new Card(13,'c'), 
                        new Card(14,'c')};
        Hand royalFlushHand = new Hand(cards);
        assertTrue("Royal Flush hand", royalFlushHand.isRoyalFlush());
        assertFalse("Not Royal Flush hand", hand.isRoyalFlush());
    }
    // four of a kind
    @Test
    public void testHasFourOfAKind() {
        Card[] cards = {new Card(2,'c'), new Card(2,'s'), new Card(2,'d'), new Card(2,'h'), 
                        new Card(6,'c')};
        Hand fourOfAKindHand = new Hand(cards);
        assertTrue("Four of a Kind hand", fourOfAKindHand.hasFourOfAKind());
        assertFalse("Not Four of a Kind hand", hand.hasFourOfAKind());
    }
    // three of a kind
    @Test
    public void testHasThreeOfAKind() {
        Card[] cards = {new Card(3,'c'), new Card(2,'s'), new Card(2,'d'), new Card(2,'h'), 
                        new Card(6,'c')};
        Hand threeOfAKindHand = new Hand(cards);
        assertTrue("Three of a Kind hand", threeOfAKindHand.hasThreeOfAKind());
        assertFalse("Not Three of a Kind hand", hand.hasThreeOfAKind());
    }
    // two pairs
    @Test
    public void testTwoPairs() {
        Card[] cards = {new Card(2,'c'), new Card(2,'s'), new Card(4,'d'), new Card(4,'h'), 
                        new Card(6,'c')};
        Hand twoPairsHand = new Hand(cards);
        assertTrue("Two Pairs hand", twoPairsHand.hasTwoPairs());
        assertFalse("Two Pairs hand", hand.hasTwoPairs());
    }
    // one pair
    @Test
    public void testOnePair() {
        Card[] cards = {new Card(2,'c'), new Card(2,'s'), new Card(5,'d'), new Card(4,'h'), 
                        new Card(6,'c')};
        Hand onePairHand = new Hand(cards);
        assertTrue("One Pair hand", onePairHand.hasOnePair());
        assertFalse("Not One Pair hand", hand.hasOnePair());
    }
}
