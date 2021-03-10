import java.util.*;

/** 
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Nathan Holmes
 */
public class Hand {
    
    // Class Constants
    /** Number of cards in hand */
    public static final int CARDS_IN_HAND = 5;
    /** The number 3 for three of a kind */
    public static final int THREE = 3;
    /** The number 4 for four of a kind */
    public static final int FOUR = 4;
    
    // Fields
    /** Contains cards in hand */
    private Card[] hand;


    /**
     * Provided; from class website
     *
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Provided; from class website
     *
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }
    
    // Created methods
    /**
     * Constructor for the hand object
     * Throws NullPointerException if the arry is a null array
     * Throws IllegalArgumentException if length does not equal CARDS_IN_HAND
     * Throws NullPointerException if one or more elements in the array is null
     * @param hand cards in hand
     */
    public Hand(Card[] hand) {
         // null array
        if(hand == null) {
            throw new NullPointerException("Null array");
        }
        
        // invalid length
        if (hand.length != CARDS_IN_HAND) { 
            throw new IllegalArgumentException("Invalid array length");
        }
        
        // null element
        for (int i = 0; i < hand.length; i++) { // need loop for null element to check all elements
            if (hand[i] == null) { // one or more elements are null
                throw new NullPointerException("Null element");
            }
        }
        
        this.hand = hand;
    }
    
    /**
     * Getter method for cards in hand
     * @return card array of cards in hand
     */
    public Card[] getCards() {
        return hand;
    }
    
    /**
     * Gets a card in the hand, dependent on index
     * Trhows IllegalArgumentException if index is less than 0 or greater than CARDS_IN_HAND
     * @param index of desired card in hand
     * @return card in hand at index
     */
    public Card getCard(int index) {
        // invalid index exception
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        
        return hand[index];
    }
    
    /**
     * Replaces card at given index in hand array with given card
     * Throws IllegalArgumentException if index is less than 0 or greater than CARDS_IN_HAND
     * Throws NullPointerException if the card is null
     * @param index card index of card to replace
     * @param card the card to replace with
     */
    public void replace(int index, Card card) {
        // invalid index exception
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        // null card exception
        if (card == null) {
            throw new NullPointerException("Null card");
        }
        
        hand[index] = card; // replaces card
    }
    
    /**
     * Converts Hand object to string
     * @return Hand object as string
     */
    public String toString() {
        String handString = "";
        for (int i = 0; i < hand.length; i++) {
            handString += hand[i].toString(); // Card class toString
            if (i != hand.length - 1) { // if it is not the last element in the hand
                handString += ", "; //add a space
            }
        }
        return "[" + handString + "]";
    }
    
    /**
     * Compares equality of Hand objects
     * @param o object to compare against
     * @return true if objects are the same
     */
    public boolean equals(Object o) {
        if (o instanceof Hand) {
            Hand h = (Hand) o;
            // Check each card in hand
            //  should see if can just try hand == h.hand
            for (int i = 0; i < hand.length; i++) {
                // checks cards using equals() method in Card class
                if (!hand[i].equals(h.hand[i])) { 
                    return false;
                }
            }  
            return true;
        } else {
            return false;
        }
    }
    
    // Additional created methods for type of hand
    
    /**
     * Determines if the hand is a flush
     * All cards must have same suit for flush
     * @return true if hand is a flush
     */
    public boolean isFlush() {
        // check each card in hand
        for (int i = 1; i < hand.length; i++) { // starts at second element
            // need to use getSuit() getter because suit private access
            if (hand[i].getSuit() != hand[0].getSuit()) { // compares to the first element
                return false; // false if not same suit
            }
        }
        return true;
    }
    
    /**
     * Determines if the hand is a straight
     * Values of hand must be in ascending sequence for hand to be a straight
     * @return true if hand is a straight
     */
    public boolean isStraight() {
        Card[] sorted = getSortedHand(); // sorts hand by value, then by suit
        for (int i = 1; i < sorted.length; i++) { // loop through sorted hand
            // started at second element to compare to first
            // adjacent elements must only differ by 1 point in value
            // adjacent elements must not be equal
            if (sorted[i].getValue() == sorted[i - 1].getValue()
                    || sorted[i].getValue() - sorted[i - 1].getValue() > 1) {
                // sorted hand makes it so that sorted[i] >= sorted[i-1] always
                // so just need to check equality
                return false;
            }
        }
        return true;
    }
    
    /**
     * Determines if the hand is a straight flush
     * True if hand is both a straight and a flush
     * @return true if hand is a straight flush
     */
    public boolean isStraightFlush() {
        return isFlush() && isStraight();
    }
    
    /**
     * Determines if the hand is a royal flush
     * True if hand is a straight flush and the values are all greater than or equal to 10
     * @return true if hand is a royal flush
     */
    public boolean isRoyalFlush() {
        // loop to check value >= 10 for each
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getValue() < 10) { // all values must be at least 10
                return false;
            }
        }
        return isStraightFlush(); // checks for straight flush too
    }
    
    /**
     * Determines if the hand has four of a kind
     * @return true if hand has four of a kind
     */
    public boolean hasFourOfAKind() {
        /*
        int[] cardCount = hand.getCounts();
        // loop through cardCount
        // if one element equals 4, return true
        //      technically can't have > 4 due to card suit number
        for (int i = 0; i < cardCount.length; i++) {
            if (cardCount[i] == 4) {
                return true;
            }
        }
        return false;
        */
        return hasAKind(FOUR);
    }
    
    /**
     * Determines if the hand has three of a kind
     * @return true if hand has three of a kind
     */
    public boolean hasThreeOfAKind() {
        return hasAKind(THREE);
    }
    
    /**
     * Determines if the hand has two pairs
     * @return true if hand has two pairs
     */
    public boolean hasTwoPairs() {
        return hasAPair(2);
    }
    
    /**
     * Determines if the hand has exactly one pair
     * @return true if hand has exactly one pair
     */
    public boolean hasOnePair() {
        return hasAPair(1);
    }
    
    /**
     * Determines if the hand is a full house
     * Full house if has two pairs and has three of a kind but their values are different
     * @return true if hand is a full house
     */
    public boolean isFullHouse() {
        return hasThreeOfAKind() && hasTwoPairs();
    }
    
    /**
     * Helper method for hasKind methods
     * @param kind the number representing the kind
     * @return true if the hand has kind number of one card
     */
    public boolean hasAKind(int kind) {
        int[] cardCount = getCounts();
        for (int i = 0; i < cardCount.length; i++) {
            if (cardCount[i] == kind) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Helper method for hasPair methods
     * @param pair the number representing the pair (one or two)
     * @return true if the hand has exactly pair number of pairs
     */
    public boolean hasAPair(int pair) {
        int[] cardCount = getCounts();
        int pairCount = 0; // variable representing number of pairs
        for (int i = 0; i < cardCount.length; i++) {
            if (cardCount[i] == 2) { // pair means two cards of same value
                pairCount++;
            }
        }
        // checks to see if the number of pairs in hand is equal to the number of pairs desired
        return pairCount == pair; 
    }
    
}
