/**
 * Represents a single playing card.
 */
public class Card {

    private Rank rank;
    private Suit suit;

    private boolean visible;

    /**
     * Creates a new card.
     * @param r the rank of the card
     * @param s the suit of the card
     */
    public Card(Rank r, Suit s) {
        rank = r;
        suit = s;
        visible = false;
    }

    public int compareTo(Card other) {
        return 0;
    }

    /**
     * Returns the rank of the card.
     * @return the rank
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the color of the card.
     * @return red or black
     */
    public Suit.Color getColor() {
        return suit.getColor();
    }

    /**
     * Determines whether the card is a face card or "pip" card.
     * @return true if the rank is Jack, Queen, or King; false otherwise
     */
    public boolean isFaceCard() {
        return (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING)
            ? true : false;
    }

    /**
     * Returns whether the card is visible to the user.
     * @return true if the card is visible, false if it is hidden
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets whether the card is visible to the user.
     * @param b true for visible, false for hidden
     */
    public void setVisible(boolean b) {
        visible = b;
    }
}
