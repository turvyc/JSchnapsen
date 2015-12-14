/**
 * Represents a single trick.
 */
public class Trick extends CardGrouping {

    private Suit suitLed;

    @Override
    public void add(Card c) {
        if (super.size() == 0)
            suitLed = c.getSuit();
        super.add(c);
    }
    
    /**
     * Returns the suit of the leading card.
     * @return the suit of the leading card
     */
    public Suit getSuitLed() {
        return suitLed;
    }

    /**
     * Chooses the winning card in the trick.
     * @param comparator The comparator object
     * @return the winning card
     */
    public Card compare(CardComparator comparator) {
        comparator.setHighestSuit(suitLed);
        super.sortBySuit(true);
        super.sort(comparator);
        return super.remove(0);
    }
}
