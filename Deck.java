import java.util.Collections;
import java.util.EnumSet;
import java.util.Random;

/**
 * Represents a complete deck of cards used in a game.
 */
public class Deck extends CardGrouping {

    /**
     * Creates a standard 52-card deck.
     */
    public Deck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values())
                add(new Card(r, s));
        }
    }

    /**
     * Creates a stripped deck.
     * @param ranks the ranks to include
     */
    public Deck(EnumSet<Rank> ranks) {
        for (Suit s : Suit.values()) {
            for (Rank r : ranks)
                add(new Card(r, s));
        }
    }

    /**
     * Adds two jokers to the deck.
     */
    public void addJokers() {
        add(new Card(Rank.LOW_JOKER, Suit.JOKER));
        add(new Card(Rank.HIGH_JOKER, Suit.JOKER));
    }

    /**
     * Randomizes the cards in the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards, new Random());
    }

    /**
     * Removes and returns the top card of the deck.
     * @return the top card of the deck
     */
    public Card draw() {
        return remove(0);
    }
}
