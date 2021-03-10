/**
 * Class to handle logic behind hte video poker game
 * @author Nathan Holmes
 */
 
public class VideoPoker {
    
    // Class constants
    /** Inticates if a random game should be played */
    public static final int RANDOM_GAME = -1;
    /** Number of cards in hand */
    public static final int CARDS_IN_HAND = 5;
    /** Starting number of points */
    public static final int STARTING_POINTS = 100;
    /** Points to start a new game */
    public static final int POINTS_FOR_NEW_GAME = 10;
    /** Points awarded for royal flush */
    public static final int ROYAL_FLUSH = 100;
    /** Points awarded for straight flush */
    public static final int STRAIGHT_FLUSH = 60;
    /** Points awared for four of a kind */
    public static final int FOUR_OF_A_KIND = 50;
    /** Points awarded for a full house */
    public static final int FULL_HOUSE = 40;
    /** Points awarded for a flush */
    public static final int FLUSH = 30;
    /** Points awarded for a straight */
    public static final int STRAIGHT = 25;
    /** Points awarded for three of a kind */
    public static final int THREE_OF_A_KIND = 15;
    /** Points awarded for two pairs */
    public static final int TWO_PAIRS = 10;
    /** Points awarded for one pair */
    public static final int ONE_PAIR = 7;
    
    // Fields
    /** Deck of cards for use in the game */
    private Deck deck;
    /** Hand of cards in the game */
    private Hand hand;
    /** Current number of points */
    private int points;
    
    // Created methods
    
    /**
     * Creates deck
     * @param seed random seed for deck
     */
    public VideoPoker(int seed) {
        this.deck = new Deck(seed);
        this.points = STARTING_POINTS;
    }
    
    /**
     * Gets number of points
     * @return number of points
     */
    public int getPoints() {
        return points;
    }
    
    /**
     * Returns name of image file for the card at the index in the hand
     * @param index location number of card in hand
     * @return name of image file for the card
     */
    public String getCardFileName(int index) {
        // uses card toString()
        // uses getCard() from Hand class
        return "cards/" + hand.getCard(index).toString() + ".gif";
    }
    
    /**
     * Returns card at given index in the hand
     * @param index of card in hand
     * @return card at given index
     */
    public Card getCard(int index) {
        // uses getCard() from Hand class
        return hand.getCard(index);
    }
    
    /**
     * Starts new game and subtracts points to do so
     */
    public void newGame() {
        points -= POINTS_FOR_NEW_GAME; // subtracts points
        
        // Stops the game if points are negative
        //  Not a required feature
        if (points < 0) {
            System.out.println("Game over. You lost all of your points.");
            System.exit(1);
        }
        
        deck.shuffle(); // shuffles deck
        // creating new hand
        Card[] newHand = new Card[CARDS_IN_HAND]; // initialize card array representing new hand
        for (int i = 0; i < CARDS_IN_HAND; i++) { // get a number of cards equal to cards in hand
            newHand[i] = deck.nextCard();
        }
        hand = new Hand(newHand);
    }
    
    /**
     * Replaces card in hand at given index with new card from deck
     * @param index location number of card in hand to be replaced
     */
    public void replaceCard(int index) {
        // use replace() from Hand class
        hand.replace(index, deck.nextCard());
    }
    
    /**
     * Returns type of hand as a string and adds respective number of points to player score
     * @return type of hand as string
     */
    public String scoreHand() {
        if (hand.isRoyalFlush()) {
            points += ROYAL_FLUSH;
            return "Royal Flush";
        } else if (hand.isStraightFlush()) {
            points += STRAIGHT_FLUSH;
            return "Straight Flush";
        } else if (hand.hasFourOfAKind()) {
            points += FOUR_OF_A_KIND;
            return "Four of a Kind";
        } else if (hand.isFullHouse()) { 
            points += FULL_HOUSE;
            return "Full House";
        } else if (hand.isFlush()) {
            points += FLUSH;
            return "Flush";
        } else if (hand.isStraight()) { 
            points += STRAIGHT;
            return "Straight";            
        } else if (hand.hasThreeOfAKind()) { 
            points += THREE_OF_A_KIND;
            return "Three of a Kind";            
        } else if (hand.hasTwoPairs()) { 
            points += TWO_PAIRS;
            return "Two Pairs";            
        } else if (hand.hasOnePair()) { 
            points += ONE_PAIR;
            return "One Pair";           
        } else {
            return "No Pair";
        }
    }
    
    
}