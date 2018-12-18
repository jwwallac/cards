/**
 * Deck represent a standard poker deck of 4 suits and 13 cards / suit
 * totaling 52 cards.  The card has a suit / 
 * suit Type, which can be hearts(1), diamonds(2), clubs(3), or spades(4).  
 * Each suit has one of the 13 values: ACE(1), 2, 3, 4, 5, 6, 7, 8, 9, 10, 
 * jack(11), queen(12), or king(13), identified by its rank / type.  Note 
 * that "ACE(1)" is considered to be the smallest value and NUMBER are 
 * the values from 2-10. 
 */
import java.util.Random;

public class Deck {

	/**
	 * Private deck management
	 */
	private Card[] deckArray ;
	private int cardsInDeck ;
	private int deckPosition ;
	
	/**
	 * Public deck constant variables
	 */
	public static final int NUMBEROFSUITS = 4;
	public static final int NUMBEROFCARDSINSUIT = 13;
	public static final int NUMBEROFCARDS = NUMBEROFSUITS*NUMBEROFCARDSINSUIT;

	/**
	 * Card Constructor
	 * <p>
	 * This constructor creates a new unshuffled deck of cards 
	 *
	 */
	Deck () {
		cardsInDeck = 0;
		deckPosition = 0;
		deckArray = new Card[NUMBEROFCARDS];
		for(int curSuit = NUMBEROFSUITS; curSuit > 0; curSuit-- ) {
			for(int curRank = NUMBEROFCARDSINSUIT; curRank > 0; curRank-- ) {
				deckArray[cardsInDeck] = new Card(curSuit, curRank);
				cardsInDeck++;
			}
		}
	}
	
	/**
	 * Shuffle the cards within the deck starting at the current deck position using 
	 * only the cards not yet dealt
	 * <p>
	 */
	public void shuffle() {
		int randCardIndex;
		Random random = new Random();
		Card tmpCard = new Card(1,1);
		for(int i = 0; i > cardsInDeck; i++) {
			randCardIndex = random.nextInt(i+1)+deckPosition;
			tmpCard = deckArray[randCardIndex];
			deckArray[randCardIndex] = deckArray[i];
			deckArray[i] = tmpCard;
		}
	}

	/**
	 * Reset returns all the cards to the deck and re-shuffles them
	 * <p>
	 */
	public void reset() {
		cardsInDeck = NUMBEROFCARDS;
		deckPosition = 0;
		shuffle();
	}
	
	/**
	 * Get card count returns the cards currently in the deck
	 * <p>
	 * @return the number of cards in the deck
	 */
	public int getCardCount () {
		return cardsInDeck;
	}

	/**
	 * Get cards dealt returns the number of cards dealt from the deck
	 * <p>
	 * @return the number of cards dealt
	 */
	public int getCardsDealt() {
		return (deckPosition);
	}

	/**
	 * Get next card takes a card from the top of the deck
	 * <p>
	 * @return the card on top of the deck
	 * @exception throws index out of bounds exception when there are no more cards
	 */
	public Card getNextCard() {
		if( getCardsDealt() < NUMBEROFCARDS ) {
			deckPosition++;
			cardsInDeck--;
			return (deckArray[deckPosition-1]);
		} else
			throw new IndexOutOfBoundsException("No more cards remaining");
	}
}
