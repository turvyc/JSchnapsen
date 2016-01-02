import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Observable;
import java.util.Random;

public class Game extends Observable {

    // The state of the game
    private enum State { START, PREGAME, OPEN, CLOSED, POSTGAME, END };
    private State state;

    // The two players, may be human or AI
    private Player p1, p2;

    // The current dealer, used to determine who plays the first trick
    private Player dealer;

    // The deck, which becomes the stock, or "talon"
    private Deck deck;

    // The number of cards dealt in an initial hand
    private final int HAND_SIZE = 5;

    // The ranks used in Schnapsen, used to create a "stripped" deck
    private final Rank[] RANKS = { Rank.JACK, Rank.QUEEN, Rank.KING,
        Rank.TEN, Rank.ACE };

    // Maps ranks to their point values
    private EnumMap<Rank, Integer> rankValues;
    private final int JACK_VALUE = 3;
    private final int QUEEN_VALUE = 4;
    private final int KING_VALUE = 5;
    private final int TEN_VALUE = 10;
    private final int ACE_VALUE = 11;

    // The trick being played on the table
    private Trick trick;

    // The discard pile
    private DiscardPile discard;

    // The comparator, used to sort and rank cards
    private CardComparator comparator;

    /**
     * Creates a new game of Schnapsen.
     * @param p1 a player, usually human
     * @param p2 the other player, either human or AI
     */
    public Game(Player p1, Player p2) {
        // The START state is only for the constructor
        state = State.START;

        // Initialize the players
        this.p1 = p1;
        this.p2 = p2;

        // Create the comparator for the stripped deck
        comparator = new CardComparator(new ArrayList<Rank>(Arrays.asList(RANKS)));

        // Assign point values to the cards
        rankValues = new EnumMap<Rank, Integer>(Rank.class);
        rankValues.put(Rank.JACK, JACK_VALUE);
        rankValues.put(Rank.QUEEN, QUEEN_VALUE);
        rankValues.put(Rank.KING, KING_VALUE);
        rankValues.put(Rank.TEN, TEN_VALUE);
        rankValues.put(Rank.ACE, ACE_VALUE);

        // Create the deck and CardGrouping objects
        resetDeck();
    }

    /**
     * Starts a new game.
     */
    public void newGame() {
        state = State.PREGAME;

        // Randomly determine the first dealer
        Random r = new Random();
        dealer = (r.nextInt() % 2 == 0) ? p1 : p2;

        // Deal the hand
        for (int i = 0; i < HAND_SIZE; i++) {
            p1.giveCard(deck.draw());
            p2.giveCard(deck.draw());
        }

        // Set the trump card
        Card trump = deck.draw();
        comparator.setTrump(trump.getSuit());
        deck.addTrump(trump);

        p1.getHand().sort(comparator);

        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        p1.getHand().notifyObservers();
        p2.getHand().notifyObservers();
        deck.notifyObservers();
        discard.notifyObservers();
        trick.notifyObservers();
        super.notifyObservers();
    }

    public Hand getPlayerHand() {
        return p1.getHand();
    }

    public Hand getOpponentHand() {
        return p2.getHand();
    }

    public Deck getDeck() {
        return deck;
    }

    public DiscardPile getDiscardPile() {
        return discard;
    }

    public void play() {
        state = State.OPEN;
    }

    public State getState() {
        return state;
    }

    /**
     * Prepares the next hand in a game.
     */
    private void prepareNextHand() {
        state = State.PREGAME;

        resetDeck();

        // Change the dealer
        dealer = (dealer == p1) ? p2 : p1;

        p1.resetHandPoints();
        p2.resetHandPoints();

        // Notify the observer
        setChanged();
        notifyObservers();
    }

    /**
     * Helper method to create/reset the deck and CardGrouping objects.
     */
    private void resetDeck() {
        deck = new Deck(new ArrayList<Rank>(Arrays.asList(RANKS)));
        trick = new Trick();
        discard = new DiscardPile();
    }
}
