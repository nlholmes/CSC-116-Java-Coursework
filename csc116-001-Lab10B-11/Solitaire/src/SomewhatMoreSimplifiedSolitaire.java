import java.util.Scanner;

/**
 * This program implements the Somewhat More Simplified Solitaire Encryption and
 * Decryption algorithm.
 * 
 * See: https://www.schneier.com/academic/solitaire/
 * 
 * @author Dr. Jason King
 * @author Dr. Jessica Young Schmidt
 *
 */
public class SomewhatMoreSimplifiedSolitaire {

    /**
     * Joker A is represented by the number 14
     */
    public static final String JOKER_A = "14";

    /**
     * Joker B is represented by the number 15
     */
    public static final String JOKER_B = "15";

    /**
     * The alphabet
     */
    public static final String ALPHABET = "BACDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Starts the Somewhat Simplified Solitaire program
     * 
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the deck of cards: ");
        String deck = scan.nextLine();

        System.out.println("Do you want to (E)ncrypt or (D)ecrypt? ");
        String option = scan.nextLine();

        System.out.println("Enter message: ");
        String message = scan.nextLine().toUpperCase();

        if (option.equalsIgnoreCase("E")) {
            System.out.println(encrypt(deck, message));
        } else {
            System.out.println(decrypt(deck, message));
        }
    }

    /**
     * Encrypts a user-provided message.
     * 
     * @param deck
     *            deck used for encryption
     * @param message
     *            the message the user wishes to encrypt
     * @return the encrypted message
     */
    public static String encrypt(String deck, String message) {
        StringBuilder cipherText = new StringBuilder();
        for (int j = 0; j < message.length(); j++) {
            char ch = message.charAt(j);
            if (Character.isLetter(ch)) {
                deck = shuffle(deck);
                String key = getKey(deck);

                while (key.equals("invalid")) {
                    deck = shuffle(deck);
                    key = getKey(deck);
                }

                int k = Integer.parseInt(key);

                int indexOfLetter = ALPHABET.indexOf(ch);

                int sum = indexOfLetter + k;

                if (sum >= ALPHABET.length()) {
                    sum -= ALPHABET.length();
                }

                String cipherLetter = ALPHABET.charAt(sum) + "";
                cipherText.append(cipherLetter + "");
            } else {
                cipherText.append(ch + "");
            }
        }
        return cipherText.toString();
    }

    /**
     * Decrypts a user-provided message
     * 
     * 
     * @param deck
     *            deck used for decryption
     * @param message
     *            - the message the user wishes to decrypt
     * @return the decrypted message
     */
    public static String decrypt(String deck, String message) {
        StringBuilder plainText = new StringBuilder();
        for (int j = 0; j < message.length(); j++) {
            char ch = message.charAt(j);
            if (Character.isLetter(ch)) {
                deck = shuffle(deck);
                String key = getKey(deck);

                while (key.equals("invalid")) {
                    deck = shuffle(deck);
                    key = getKey(deck);
                }

                int k = Integer.parseInt(key);

                int indexOfLetter = ALPHABET.indexOf(ch);

                int difference = indexOfLetter - k;
                if (difference < 0) {
                    difference += ALPHABET.length();
                }

                String plainLetter = ALPHABET.charAt(difference) + "";
                plainText.append(plainLetter + "");
            } else {
                plainText.append(ch + "");
            }
        }
        return plainText.toString();
    }

    /**
     * Steps-through the Somewhat Simplified Solitaire algorithm and returns the
     * next keystream value
     * 
     * @param deck
     *            current deck
     * @return the next keystream value
     */
    public static String shuffle(String deck) {
        deck = moveFirstJokerDownOne(deck);
        deck = moveSecondJokerDownTwo(deck);
        deck = tripleCut(deck);
        deck = moveToBack(deck);
        return deck;
    }

    /**
     * Find Joker A. Exchange it with the card beneath (after) it in the deck, to
     * move the card down the deck by one position. If the joker is the last card in
     * the deck, then imagine that the deck of cards is continuous; the card
     * following the bottom card is the top card of the deck, and you'd just
     * exchange them.
     * 
     * @param deck
     *            current deck
     * 
     * @return the deck after moving Joker A down one position
     */
    public static String moveFirstJokerDownOne(String deck) {
        int indexOfJokerA = deck.indexOf(JOKER_A);
        if (indexOfJokerA < deck.lastIndexOf(" ")) {
            String firstHalfOfDeck = deck.substring(0, indexOfJokerA);
            String secondHalfOfDeck = deck.substring(indexOfJokerA + 3);
            String firstCardInSecondHalf = secondHalfOfDeck.substring(0,
                    secondHalfOfDeck.indexOf(" ") + 1);
            String secondHalfOfDeckWithoutFirstCard = "";
            if (!secondHalfOfDeck.contains(" ")) {
                firstCardInSecondHalf = secondHalfOfDeck;
            } else {
                secondHalfOfDeckWithoutFirstCard = secondHalfOfDeck
                        .substring(secondHalfOfDeck.indexOf(" ") + 1);
            }
            return firstHalfOfDeck + firstCardInSecondHalf + JOKER_A + " "
                    + secondHalfOfDeckWithoutFirstCard;
        } else {
            String firstHalfOfDeck = deck.substring(0, indexOfJokerA - 1);
            return JOKER_A + " " + firstHalfOfDeck;
        }
    }

    /**
     * Moves Joker B down in the deck by two positions, wrapping around to the top
     * of the deck if needed.
     * 
     * @param deck
     *            current deck
     * @return the deck after moving Joker B down two positions
     */
    public static String moveSecondJokerDownTwo(String deck) {
        int indexOfJokerB = deck.indexOf(JOKER_B);
        if (indexOfJokerB < deck.substring(0, deck.lastIndexOf(" ") - 1).lastIndexOf(" ")) {
            String firstHalfOfDeck = deck.substring(0, indexOfJokerB - 1);
            String secondHalfOfDeck = deck.substring(indexOfJokerB + 3);
            String firstCardInSecondHalf = secondHalfOfDeck.substring(0,
                    secondHalfOfDeck.indexOf(" "));
            String secondHalfOfDeckWithoutFirstCard = secondHalfOfDeck
                    .substring(secondHalfOfDeck.indexOf(" ") + 1);
            String secondCardInSecondHalf = secondHalfOfDeckWithoutFirstCard.substring(0,
                    secondHalfOfDeckWithoutFirstCard.indexOf(" "));
            if (secondHalfOfDeckWithoutFirstCard.indexOf(" ") == -1) {
                secondCardInSecondHalf = secondHalfOfDeckWithoutFirstCard + " ";
                secondHalfOfDeckWithoutFirstCard += " ";
            }
            String secondHalfOfDeckWithoutFirstTwoCards = secondHalfOfDeckWithoutFirstCard
                    .substring(secondCardInSecondHalf.length());
            return firstHalfOfDeck + firstCardInSecondHalf + secondCardInSecondHalf + JOKER_B + " "
                    + secondHalfOfDeckWithoutFirstTwoCards;
        } else if (indexOfJokerB < deck.lastIndexOf(" ")) {
            String firstCardInDeck = deck.substring(0, deck.indexOf(" "));
            String lastCardInDeck = deck.substring(deck.lastIndexOf(" ") + 1);
            String firstHalfOfDeckWithoutFirstCard = deck.substring(firstCardInDeck.length(),
                    indexOfJokerB);
            return JOKER_B + firstHalfOfDeckWithoutFirstCard + lastCardInDeck + " "
                    + firstCardInDeck;

        } else {
            String firstCardInDeck = deck.substring(0, deck.indexOf(" "));
            String deckWithoutFirstCard = deck.substring(firstCardInDeck.length() + 1,
                    indexOfJokerB);
            String secondCardInDeck = deckWithoutFirstCard.substring(0,
                    deckWithoutFirstCard.indexOf(" "));
            String deckWithoutFirstTwoCards = deckWithoutFirstCard
                    .substring(secondCardInDeck.length() + 1);
            return secondCardInDeck + " " + JOKER_B + " " + deckWithoutFirstTwoCards
                    + firstCardInDeck;
        }
    }

    /**
     * Swaps the cards BEFORE the first joker with the cards AFTER the second joker
     * 
     * @param deck
     *            current deck
     * @return the deck after performing the triple cut
     */
    public static String tripleCut(String deck) {
        int indexOfJokerA = deck.indexOf(JOKER_A);
        int indexOfJokerB = deck.indexOf(JOKER_B);

        if (indexOfJokerA < indexOfJokerB) {
            String firstPartOfDeck = "";
            if (indexOfJokerA != 0) {
                firstPartOfDeck = " " + deck.substring(0, indexOfJokerA - 1);
            }
            String secondPartOfDeck = "";
            if (indexOfJokerB != 0) {
                secondPartOfDeck = deck.substring(indexOfJokerB + 3) + " ";
            }
            String middlePartOfDeck = deck.substring(indexOfJokerA, indexOfJokerB + 2);
            return secondPartOfDeck + middlePartOfDeck + firstPartOfDeck;
        } else {
            String firstPartOfDeck = "";
            if (indexOfJokerB != 0) {
                firstPartOfDeck = " " + deck.substring(0, indexOfJokerB - 1);
            }
            String secondPartOfDeck = "";
            if (indexOfJokerA != 0) {
                secondPartOfDeck = deck.substring(indexOfJokerA + 3) + " ";
            }
            String middlePartOfDeck = deck.substring(indexOfJokerB, indexOfJokerA + 2);
            return secondPartOfDeck + middlePartOfDeck + firstPartOfDeck;
        }
    }

    /**
     * Take the bottom card from the deck. Count down from the top card by a
     * quantity of cards equal to the value of that bottom card. (If the bottom card
     * is a joker, let its value be 14, regardless of which joker it is.) Take that
     * group of cards and move them to the bottom of the deck. Return the bottom
     * card to the bottom of the deck.
     * 
     * For example: if the bottom card is 8, move the first 8 cards in the deck to
     * the end of the deck, then replace the 8 as the last card in the deck.
     * 
     * @param deck
     *            current deck
     * @return the deck after performing the move to back step
     */
    public static String moveToBack(String deck) {
        String lastCardInDeck = deck.substring(deck.lastIndexOf(" ") + 1).trim();
        int lastCardValue = Integer.parseInt(lastCardInDeck);
        if (lastCardValue >= Integer.parseInt(JOKER_A)) {
            lastCardValue = Integer.parseInt(JOKER_A);
        }

        StringBuilder firstXCards = new StringBuilder();
        Scanner deckScanner = new Scanner(deck);
        for (int i = 0; i < lastCardValue; i++) {
            firstXCards.append(deckScanner.next() + " ");
        }
        String firstPartOfDeck = deckScanner.nextLine().trim();
        String firstPartOfDeckWithoutLastCard = "";
        if (firstPartOfDeck.contains(" ")) {
            firstPartOfDeckWithoutLastCard = firstPartOfDeck.substring(0,
                    firstPartOfDeck.lastIndexOf(" ")) + " ";
        }

        return firstPartOfDeckWithoutLastCard + firstXCards.toString() + lastCardInDeck;
    }

    /**
     * Look at the top card's value (which is again 1-14, as it was in the previous
     * step). Put the card back on top of the deck. Count down the deck by that many
     * cards. Record the value of the NEXT card in the deck, but don't remove it
     * from the deck.
     * 
     * @param deck
     *            current deck
     * @return the next keystream value
     */
    public static String getKey(String deck) {
        String firstCard = deck.substring(0, deck.indexOf(" "));
        int firstCardValue = Integer.parseInt(firstCard);

        if (firstCardValue >= Integer.parseInt(JOKER_A)) {
            firstCardValue = Integer.parseInt(JOKER_A);
        }

        Scanner deckScanner = new Scanner(deck);
        for (int i = 0; i < firstCardValue; i++) {
            deckScanner.next();
        }
        return deckScanner.next();
    }
}
