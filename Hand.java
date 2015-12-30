/**
 * Represents a hand of cards held by a player.
 */
public class Hand extends CardGrouping {

    @Override
    public String toString() {
        String s = "Hand: ";
        for (Card c : cards)
            s += c.toString();
        return s;
    }
}
