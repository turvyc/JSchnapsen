/**
 * Represents a hand of cards held by a player.
 */
public class Hand extends CardGrouping {

    /**
     * Sets the entire hand to be visible or not.
     * @param b the hand is visible to the user if true, covered if false
     */
    public void setVisible(boolean b) {
        for (Card c : cards)
            c.setVisible(b);
    }
}
