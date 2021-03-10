/**
 * Class to represent a single card in the card game
 * @author Nathan Holmes
 */
 
public class Card implements Comparable<Card> {
    
    // Class constants
    /** A char value that represents the suit "Clubs." */
    public static final char CLUBS = 'c';
    /** A char value that represents the suit "Diamonds." */
    public static final char DIAMONDS = 'd';
    /** A char value that represents the suit "Spades." */
    public static final char SPADES = 's';
    /** A char value that represents the suit "Hearts." */
    public static final char HEARTS = 'h';
    /** The lowest numeric value for a card. */
    public static final int LOWEST_VALUE = 2;
    /** The highest numeric value for a card. */
    public static final int HIGHEST_VALUE = 14;
    
    // Fields
    /** Card value */
    private int value;
    /** Card suit */
    private char suit;
    
    
    /**
     * Copied from class website
     *
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     * 
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
    
    // constructor
    /**
     * Constructor for card object
     * Throws IllegalArgumentException if card is invalid in either value or suit
     * @param value card value
     * @param suit card suit
     */
    public Card(int value, char suit) {
        if (value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (suit != CLUBS && suit != DIAMONDS && suit != SPADES && suit != HEARTS) {
            throw new IllegalArgumentException("Invalid suit");
        }
        this.value = value;
        this.suit = suit;
    }
    
    // getter for value
    /**
     * Gets card value
     * @return card value
     */
    public int getValue() {
        return value;
    }
    
    // getter for suit
    /**
     * Gets card suit
     * @return card suit
     */
    public char getSuit() {
        return suit;
    }
    
    // equals method for card object
    /**
     * Determines equality of card objects
     * @param o object to compare against
     * @return true if objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card r = (Card) o;
            return value == r.value && suit == r.suit;
        } else {
            return false;
        }
    }
    
    // toString method for card object
    /**
     * Converts card object to string
     * @return card object as string
     */
    public String toString() {
        return "" + suit + value;
    }
    
}