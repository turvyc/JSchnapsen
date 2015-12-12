import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents an abstract collection of cards.
 */
public abstract class CardGrouping {

    protected ArrayList<Card> cards;

    /**
     * The constructor only initializes the cards ArrayList.
     */
    public CardGrouping() {
        cards = new ArrayList<Card>();
    }

    /**
     * Adds a single, specified card to the grouping.
     * @param c the card to add
     */
    protected void add(Card c) {
        cards.add(c);
    }

    /**
     * Removes a single, specified card from the grouping.
     * @param c a card in the grouping
     * @return the specified card
     */
    protected Card remove(Card c) {
        assert cards.contains(c);
        int i = cards.indexOf(c);
        return remove(i);
    }

    /**
     * Removes a single card from a specified index.
     * @param i the index of the card to be removed
     * @return the card at the specified index
     */
    protected Card remove(int i) {
        assert cards.size() >= i + 1;
        Card r = cards.get(i);
        cards.remove(i);
        return r;
    }

    /**
     * Returns the number of cards in the grouping.
     * @return the number of cards
     */
    protected int size() {
        return cards.size();
    }

    /**
     * Sets the grouping to be visible to the user or not.
     * @param b true for visible, false for hidden
     */
    protected void setVisible(boolean b) {
        for (Card c : cards)
            c.setVisible(b);
    }

    /**
     * Sorts the cards by rank, without regard to suit.
     */
    protected void sortByRank(CardComparator comparator) {
        comparator.sortBySuit(false);
        Collections.sort(cards, comparator);
    }

    /**
     * Sorts the cards by rank, grouped by suit.
     */
    protected void sortBySuit(CardComparator comparator) {
        comparator.sortBySuit(true);
        Collections.sort(cards, comparator);
    }
}
