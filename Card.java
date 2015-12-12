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
                case SPADES: unicode += "A"; break;
                case HEARTS: unicode += "B"; break;
                case DIAMONDS: unicode += "C"; break;
                case CLUBS: unicode += "D"; break;
            }
            switch (rank) {
                case ACE: unicode += 1; break;
                case TWO: unicode += 2; break;
                case THREE: unicode += 3; break;
                case FOUR: unicode += 4; break;
                case FIVE: unicode += 5; break;
                case SIX: unicode += 6; break;
                case SEVEN: unicode += 7; break;
                case EIGHT: unicode += 8; break;
                case NINE: unicode += 9; break;
                case TEN: unicode += "A"; break;
                case JACK: unicode += "B"; break;
                case QUEEN: unicode += "D"; break;
                case KING: unicode += "E"; break;
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
