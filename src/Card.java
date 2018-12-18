/**
 * Card represent a standard poker deck playing card.  The card has a suit / 
 * suit Type, which can be hearts(1), diamonds(2), clubs(3), or spades(4).  
 * Each suit has one of the 13 values: ACE(1), 2, 3, 4, 5, 6, 7, 8, 9, 10, 
 * jack(11), queen(12), or king(13), identified by its rank / type.  Note 
 * that "ACE(1)" is considered to be the smallest value and NUMBER are 
 * the values from 2-10. 
 */
public class Card {

	/**
	 * Private class variables to manage card suit & value
	 */
	private final int suit; 
	private final int rank;
	private final Type type;
	private final Suit suitType;

	public enum Type {
		ACE, NUMBER, JACK, QUEEN, KING
	};

	/**
	 * Returns suit numerical equivalent 1..4. 
	 * <p>
	 * @return suit numerical equivalent 1..4. 
	 */
	public int getSuit() {return suit;}
	/**
	 * Returns the rank numeric equivalent 1..13
	 * <p>
	 * @return the rank numeric equivalent 1..13
	 */
	public int getRank() {return rank;}
	/**
	 * Returns the type of card: Ace, King, Queen, Jack, or numeric
	 * <p>
	 * @return the type of card: Ace, King, Queen, Jack, or numeric
	 */
	public Type getType() {return type;}
	/**
	 * Returns the card suit: Hearts, Diamonds, Clubs, Spades
	 * <p>
	 * @return the card suit: Hearts, Diamonds, Clubs, Spades
	 */
	public Suit getSuitType() { return suitType;}

	/**
	 * Card Constructor
	 * <p>
	 * This constructor creates a new card provided with a numeric suit and card value 
	 *
	 * @param  suit suit numeric value of 1..4, 
	 * @param  rank rank of the card within the suit 1..13
	 * @exception throws Illegal Argument Exception when either a suit or rank is out of bounds
	 */
	Card(int suit, int rank){
		this.rank = rank;
		this.suit = suit;
		switch (suit) {
			case 1: suitType = Suit.HEARTS; break;
			case 2: suitType = Suit.DIAMONDS; break;
			case 3: suitType = Suit.CLUBS; break;
			case 4: suitType = Suit.SPADES; break;
			default: throw new IllegalArgumentException("Playing card suit must be between 1 & 4");
		}
		switch (rank) {
			case 1: type = Type.ACE; break;
			case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10: type = Type.NUMBER; break;
			case 11: type = Type.JACK; break;
			case 12: type = Type.QUEEN; break;
			case 13: type = Type.KING; break;
		    default: throw new IllegalArgumentException("Playing card rank must be between 1 & 13");
		}
	}
	/**
	 * equals operator for card value comparison
	 * <p>
	 * This constructor creates a new card provided with a numeric suit and card value 
	 *
	 * @param	another card to compare with 
	 * @return 	true if the card is equal; false otherwise;
	 */
	public boolean equals(Object otherCard) {
		return otherCard instanceof Card
				&& this.rank == ((Card)otherCard).rank; 
	}

}
