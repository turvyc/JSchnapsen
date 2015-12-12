import java.util.ArrayList;
import java.util.Comparator;

/**
 * A flexible way to compare two cards.
 */
public class CardComparator implements Comparator<Card> {

    // If true, compare by both suit and rank; if false, compare by rank alone.
    private boolean sortBySuit;

    // Sets the trump suit, if necessary
    private Suit trump;

    // The suit order, index 0 being the lowest suit.
    private ArrayList<Suit> suitOrder;

    // The rank order, index 0 being the lowest rank.
    private ArrayList<Rank> rankOrder;

    /**
     * Constructs a default comparator for a standard 52-card deck:
     * aces low; clubs, diamonds, hearts, spades in ascending order.
     */
    public CardComparator() {
        sortBySuit = false;
        trump = null;
        
        // Populate suit order using the order defined in the Enum
        for (Suit s : Suit.values())
            suitOrder.add(s);

        // Populate rank order using the order defined in the Enum
        for (Rank r : Rank.values())
            rankOrder.add(r);

        // Remove the jokers
        rankOrder.remove(Rank.LOW_JOKER);
        rankOrder.remove(Rank.HIGH_JOKER);
    }

    /**
     * Constructs a custom comparator, as in for a stripped deck.
     */
    public CardComparator(ArrayList<Rank> ranks) {
        sortBySuit = false;
        trump = null;
        rankOrder = ranks;

        // Populate suit order using the order defined in the Enum
        for (Suit s : Suit.values())
            suitOrder.add(s);

    }

    /**
     * Compares two different cards (it is assumed that a deck has no
     * duplicate cards).
     * @param a the first card to be compared
     * @param b the second card to be compared
     * @return a negative number if a ranks lower than b, or a postive 
     * number if a ranks higher than b.
     */
    public int compare(Card a, Card b) {
        Rank aRank = a.getRank();
        Rank bRank = b.getRank();
        Suit aSuit = a.getSuit();
        Suit bSuit = b.getSuit();

        assert (aRank != bRank && aSuit != bSuit);

        // Handle trump cards
        if (aSuit == trump) {
            if (bSuit == trump)
                return rankOrder.indexOf(aRank) - rankOrder.indexOf(bRank);
            else
                return 1;
        }

        else if (bSuit == trump)
            return -1;

        // No trumps
        if (sortBySuit) {
            if (aSuit == bSuit)
                return rankOrder.indexOf(aRank) - rankOrder.indexOf(bRank);
            return suitOrder.indexOf(aSuit) - suitOrder.indexOf(bSuit);
        }
        else
            return rankOrder.indexOf(aRank) - rankOrder.indexOf(bRank);
    }

    /**
     * Sets aces to be the highest or lowest rank.
     * @param b true sets aces to be ranked above kings, false sets aces 
     * to be ranked below twos.
     */
    public void setAcesHigh(boolean b) {
        assert rankOrder.contains(Rank.ACE);
        if (b) 
            // Moves ACE to the end of the list
            rankOrder.add(rankOrder.remove(rankOrder.indexOf(Rank.ACE)));
        else
            // Moves ACE to the beginning of the list
            rankOrder.add(0, rankOrder.remove(rankOrder.indexOf(Rank.ACE)));
    }

    /**
     * Sets whether to sort by suit as well as by rank.
     * @param b if true, sort by suit and rank; if false, by rank alone.
     */
    public void sortBySuit(boolean b) {
        sortBySuit = b;
    }

    /**
     * Sets one suit to be the highest ranked suit by moving it to 
     * the end of the ArrayList.
     * @param s the suit to be promoted to the highest rank
     */
    public void setHighestSuit(Suit s) {
        suitOrder.remove(s);
        suitOrder.add(s);
    }

    /**
     * Sets a trump suit, a suit that beats all others.
     * @param s the suit to be set as trump
     */
    public void setTrump(Suit s) {
        trump = s;
    }
}
