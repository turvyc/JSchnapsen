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

    // The current dealer
    private Player dealer;

    // The deck, which becomes the stock, or "talon"
    private Deck deck;

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

        // Prepare the stripped deck and the CardGrouping objects
        ArrayList<Rank> ranks = new ArrayList<Rank>(Arrays.asList(RANKS));
        comparator = new CardComparator(ranks);
        deck = new Deck(ranks);
        trick = new Trick();
        discard = new DiscardPile();

        // Assign point values to the cards
        rankValues.put(Rank.JACK, JACK_VALUE);
        rankValues.put(Rank.QUEEN, QUEEN_VALUE);
        rankValues.put(Rank.KING, KING_VALUE);
        rankValues.put(Rank.TEN, TEN_VALUE);
        rankValues.put(Rank.ACE, ACE_VALUE);

        // Randomly determine the first dealer
        Random r = new Random();
        dealer = (r.nextInt() % 2 == 0) ? p1 : p2;

        // Notify the observer
        setChanged();
        notifyObservers();
    }
}
