import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

/**
 * Represents an abstract collection of cards.
 */
public abstract class CardGrouping extends Observable {

    protected ArrayList<Card> cards;

    protected boolean sortBySuit;

    /**
     * The constructor only initializes the cards ArrayList.
     */
    public CardGrouping() {
        cards = new ArrayList<Card>();
        sortBySuit = true;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Sets whether to sort by suit and rank or by rank alone.
     * @param b true sorts by both suit and rank
     */
    public void sortBySuit(boolean b) {
        sortBySuit = b;
    }

    /**
     * Adds a single, specified card to the grouping.
     * @param c the card to add
     */
    protected void add(Card c) {
        setChanged();
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
        setChanged();
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
        setChanged();
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
        setChanged();
    }

    /**
     * Sorts the cards.
     */
    protected void sort(CardComparator comparator) {
        comparator.sortBySuit(this.sortBySuit);
        Collections.sort(cards, comparator);
        setChanged();
    }
}
