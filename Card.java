/**
 * Represents a single playing card.
 */
public class Card {

    private Rank rank;
    private Suit suit;

    private boolean visible;

    private String unicode;

    /**
     * Creates a new card.
     * @param r the rank of the card
     * @param s the suit of the card
     */
    public Card(Rank r, Suit s) {
        rank = r;
        suit = s;
        visible = false;

        // Calculate the unicode
        if (rank == Rank.LOW_JOKER)
            unicode = "1F0CF";
        else if (rank == Rank.HIGH_JOKER)
            unicode = "1F0DF";
        else {
            unicode = "1F0";
            switch (suit) {
                case Suit.SPADES: unicode += "A"; break;
                case Suit.HEARTS: unicode += "B"; break;
                case Suit.DIAMONDS: unicode += "C"; break;
                case Suit.CLUBS: unicode += "D"; break;
            }
            switch (rank) {
                case Rank.ACE: unicode += 1; break;
                case Rank.TWO: unicode += 2; break;
                case Rank.THREE: unicode += 3; break;
                case Rank.FOUR: unicode += 4; break;
                case Rank.FIVE: unicode += 5; break;
                case Rank.SIX: unicode += 6; break;
                case Rank.SEVEN: unicode += 7; break;
                case Rank.EIGHT: unicode += 8; break;
                case Rank.NINE: unicode += 9; break;
                case Rank.TEN: unicode += "A"; break;
                case Rank.JACK: unicode += "B"; break;
                case Rank.QUEEN: unicode += "D"; break;
                case Rank.KING: unicode += "E"; break;
            }
        }
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
