
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testDeck() {
		Deck pokerDeck = new Deck();
		assertEquals(52,pokerDeck.getCardCount(),"Poker deck must contain 52 cards");
		assertEquals(0,pokerDeck.getCardsDealt(),"Poker deck must not have any cards dealt");
	}

	@Test
	void testShuffle() {
		Deck pokerDeck = new Deck();
		Card firstCard = pokerDeck.getNextCard();
		assertEquals(4,firstCard.getSuit(),"First card must be an KING of SPADES");
		assertEquals(13,firstCard.getRank(),"First card must be an KING of SPADES");
		pokerDeck.shuffle(); 
		Card secondCardAfterShuffle = pokerDeck.getNextCard();
		assertFalse(
			secondCardAfterShuffle.getSuit()==firstCard.getSuit()
			&&secondCardAfterShuffle.getRank()==firstCard.getRank()
			, "First card before and after shuffle can't be the same");
	}

	@Test
	void testReset() {
		Deck pokerDeck = new Deck();
		Card firstCard = pokerDeck.getNextCard();
		assertEquals(4,firstCard.getSuit(),"First card must be an KING of SPADES");
		assertEquals(13,firstCard.getRank(),"First card must be an KING of SPADES");
		assertEquals(51,pokerDeck.getCardCount() ,"Poker deck must contain only 51 cards");
		assertEquals(1,pokerDeck.getCardsDealt() ,"Poker deck must have dealt 1 card");
		pokerDeck.reset();
		assertEquals(52,pokerDeck.getCardCount(),"Poker deck must contain 52 cards");
		assertEquals(0,pokerDeck.getCardsDealt(),"Poker deck must not have any cards dealt");
	}

	@Test
	void testGetCardCount() {
		Deck pokerDeck = new Deck();
		assertEquals(52,pokerDeck.getCardCount(),"Poker deck must contain 52 cards");
		Card firstCard = pokerDeck.getNextCard();
		assertEquals(51,pokerDeck.getCardCount() ,"Poker deck must contain only 51 cards");
	}

	@Test
	void testGetCardsDealt() {
		Deck pokerDeck = new Deck();
		assertEquals(0,pokerDeck.getCardsDealt(),"Poker deck must not have any cards dealt");
		Card firstCard = pokerDeck.getNextCard();
		assertEquals(1,pokerDeck.getCardsDealt() ,"Poker deck must have dealt 1 card");
	}

	@Test
	void testGetNextCard() {
		Deck pokerDeck = new Deck();
		while (true) {
			try {
			  Card myCard = pokerDeck.getNextCard();
			} catch (IndexOutOfBoundsException ex) {
				assertEquals(0,pokerDeck.getCardCount(),"Poker deck must have 0 cards");
				assertEquals(52,pokerDeck.getCardsDealt(),"All cards must be dealt");
			}
		}
	}

}
