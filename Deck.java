import java.util.Collections;
import java.util.ArrayList;
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
                super.add(new Card(r, s));
        }
        shuffle();
    }

    /**
     * Creates a stripped deck.
     * @param ranks the ranks to include
     */
    public Deck(ArrayList<Rank> ranks) {
        for (Suit s : Suit.values()) {
            for (Rank r : ranks)
                super.add(new Card(r, s));
        }
        shuffle();
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
        return super.remove(0);
    }
}
