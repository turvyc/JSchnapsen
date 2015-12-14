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

    @Override
    public String toString() {
        String prefix = "\uD83C";
        String suffix = "DC";
        if (! visible)
            suffix += "A0";
        else {
            switch (suit) {
                case SPADES: suffix += "A"; break;
                case HEARTS: suffix += "B"; break;
                case DIAMONDS: suffix += "C"; break;
                case CLUBS: suffix += "D"; break;
            }
            switch (rank) {
                case ACE: suffix += "1"; break;
                case TWO: suffix += "2"; break;
                case THREE: suffix += "3"; break;
                case FOUR: suffix += "4"; break;
                case FIVE: suffix += "5"; break;
                case SIX: suffix += "6"; break;
                case SEVEN: suffix += "7"; break;
                case EIGHT: suffix += "8"; break;
                case NINE: suffix += "9"; break;
                case TEN: suffix += "A"; break;
                case JACK: suffix += "B"; break;
                case QUEEN: suffix += "D"; break;
                case KING: suffix += "E"; break;
            }
        }
        return prefix + new String(Character.toChars(Integer.parseInt(suffix, 16)));
    }
}
