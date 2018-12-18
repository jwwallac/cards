


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testGetSuit() {
		Card kingOfHeartsCard = new Card(1,13);
		assertEquals(1,kingOfHeartsCard.getSuit(),"Card Suit must be 1");
	}

	@Test
	void testGetRank() {
		Card testCard = new Card(1,13);
		assertEquals(13,testCard.getRank(),"Card Rank must be 13");
	}

	@Test
	void testGetType() {
		Card testCard = new Card(1,1);
		assertTrue(Card.Type.ACE == testCard.getType(),"Card must be an ACE");
		Card twoOfHeartsCard = new Card(1,2);
		assertTrue(Card.Type.NUMBER == twoOfHeartsCard.getType(),"Card must be a Two of Hearts");
		Card jackOfHeartsCard = new Card(1,2);
		assertTrue(Card.Type.NUMBER == jackOfHeartsCard.getType(),"Card must be a Jack of Hearts");
		Card kingOfHeartsCard = new Card(1,13);
		assertTrue(Card.Type.KING == kingOfHeartsCard.getType(),"Card must be a King of Hearts");
	}

	@Test
	void testGetSuitType() {
		Card kingOfHeartsCard = new Card(1,13);
		assertTrue(Suit.HEARTS == kingOfHeartsCard.getSuitType(),"Card must be a HEART");
		Card queenOfDiamondsCard = new Card(2,12);
		assertTrue(Suit.DIAMONDS == queenOfDiamondsCard.getSuitType(),"Card must be a DIAMOND");
		Card twoOfSpadesCard = new Card(4,2);
		assertTrue(Suit.SPADES == twoOfSpadesCard.getSuitType(),"Card must be a SPADE");
	}

	@Test
	void testCard() {
		Card testCard = new Card(1,13);
		assertTrue(testCard instanceof Card,"Object must be a card");
	}

	@Test
	void testEqualsObject() {
		Card testCard = new Card(1,13);
		Card otherCard = new Card(2,13);
		assertTrue(testCard.equals(otherCard) ,"Both Cards are aces and equal in value");
	}

}
