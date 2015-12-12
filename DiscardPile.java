/**
 * Represents the discard pile.
 */
public class DiscardPile extends CardGrouping {

    @Override
    public void add(Card c) {
        c.setVisible(false);
        super.add(c);
    }
}
