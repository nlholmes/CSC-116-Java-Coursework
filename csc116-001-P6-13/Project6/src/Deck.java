import java.util.Random;
/**
 * Class representing a deck of 52 playing cards
 * @author Nathan Holmes
 */
public class Deck {
    // Class constants
    /** Number of cards in deck */
    public static final int CARDS_IN_DECK = 52;
    /** Number of cards in suit */
    public static final int CARDS_IN_SUIT = 13; // CARDS_IN_DECK/4
    
    // Fields
    /** Array of card objects representing the deck */
    private Card[] deck;
    /** Index of next card to be dealt from array of cards */
    private int nextIndex;
    /** Random seed, provided for testing */
    private int seed;
    
    /**
     * Constructor for Deck object
     * @param seed randomizing seed for deck while testing
     */
    public Deck(int seed) {
        // might need to set nextIndex = 0
        //this.nextIndex = 0;
        this.seed = seed;
        this.deck = new Card[CARDS_IN_DECK]; // initializes cards
        
        char[] suits = new char[] {Card.CLUBS, Card.DIAMONDS, Card.HEARTS, Card.SPADES};
        int currentIndex;
        // Two loops with suit array
        for(int i = 0; i < suits.length; i++) { // for every suit
            // current card in j-suit loop is equal to
            //currentIndex = i + j * CARDS_IN_SUIT;
            for (int r = Card.LOWEST_VALUE; r <= Card.HIGHEST_VALUE; r++) { // for every card value
                currentIndex = r - 2 + i * CARDS_IN_SUIT;
                this.deck[currentIndex] = new Card(r, suits[i]);
            }
        }
        
        /*
        char[] suits = new char[] {Card.CLUBS, Card.DIAMONDS, Card.HEARTS, Card.SPADES};
        int currentIndex;
        // one loop with addition
        // c for deck[2-14]
        // d for deck[2-14 + 13]
        // h for deck[2-14 + 26]
        // s for deck[2-14 + 39]
        // because there are twelve cards per suit, where CARDS_IN_SUIT = 13;
            for (int r = Card.LOWEST_VALUE; r <= Card.HIGHEST_VALUE; r++) {
                    this.deck[r - 2] = new Card(r, Card.CLUBS); // makes clubs cards
                    this.deck[r - 2 + CARDS_IN_SUIT] = new Card(r, Card.DIAMONDS);
                    this.deck[r - 2 + 2 * CARDS_IN_SUIT] = new Card(r, Card.HEARTS);
                    this.deck[r - 2 + 3 * CARDS_IN_SUIT] = new Card(r, Card.SPADES);
            }
        */
    }
    
    /**
     * "Shuffles" the deck using random numbers
     * Uses an algorithm that guarantees all permutations are equally likely
     * Psuedocode for this algorithm was provided on the class website
     */
    public void shuffle() {
        // if theres a seed make a random object from that seed
        // if not then make a random object without a seed
        
        
        Random rand = new Random();
        if (this.seed != -1) {
            //Random rand = new Random();
            rand = new Random(seed); // if seed is -1, there was no seed
        } /*else {
            rand = new Random(seed);
        }*/
        
        
        /**
        for i = n - 1 down to 1 do
          swap a[i] with a random element among a[0],...,a[i]
          (so if the chosen element is a[i], it stays put)
        */
        int randNum;
        Card temp; // temporary swapping value, wihtout it it makes 2 copies of same card
        for (int i = CARDS_IN_DECK - 1; i > 0; i--) {
            randNum = rand.nextInt(CARDS_IN_DECK); // creates random number between 0 and 51
            // swaps the current element with random element
            temp = deck[randNum];
            deck[randNum] = deck[i];
            deck[i] = temp;
        }
        
        this.nextIndex = 0; // resets the next index
    }
    
    /**
     * Returns the next card in the deck
     * @return next card in the deck
     */
    public Card nextCard() {  
        Card next = deck[nextIndex]; // nextIndex is field
        nextIndex++;
        return next;
    }
    
    /**
     * Determines equality of deck objects
     * @param o object to compare against
     * @return true if objects are equal
     */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck d = (Deck) o;
            // Check deck field equality for objects (need to check every card)
            for (int i = 0; i < deck.length; i++) {
                // checks cards using equals() method in Card class
                if (!deck[i].equals(d.deck[i])) { 
                    return false;
                }
            }
            
            return seed == d.seed; // checks seed equality
        } else {
            return false;
        }
    }
    
    /**
     * Converts Deck object to string
     * @return Deck object as string
     */
    public String toString() {
        String deckString = "";
        for (int i = 0; i < deck.length; i++) {
            // new line after each
            // calls Card class toString() method
            deckString += "card " + i + ": " + deck[i].toString() + "\n"; 
        }
        return deckString;
    }
    
}