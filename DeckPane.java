import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLayeredPane;

/**
 * A class to display the deck of cards.
 */
public class DeckPane extends MultiCardPane {

    private static final int H_OFFSET = 1;
    private static final int V_OFFSET = 1;

    // The vertical offset of the trump card
    private int trump_offset;

    /**
     * Creates a new empty DeckPane.
     */
    public DeckPane() {
        super(H_OFFSET, V_OFFSET);
        trump_offset = (CardComponent.CARD_HEIGHT - CardComponent.CARD_WIDTH) / 2;
    }

    @Override
    public Dimension getPreferredSize() {
        int width = CardComponent.CARD_WIDTH + (cards.size() * h_offset);
        int height = CardComponent.CARD_HEIGHT + (cards.size() + v_offset);

        // Handle the 90-degree trump card under the deck
        width += CardComponent.CARD_HEIGHT;

        return new Dimension(width, height);
    }

    @Override
    public void update(Observable o, Object arg) {
        Deck deck = (Deck) o;
        CardListener listener = (CardListener) arg;

        for (Card c : deck.getCards()) {
            cards.add(new CardComponent(c));
        }

        // Display the card components
        int i = 0;
        for (i = 0; i < cards.size(); i++) {
            CardComponent cc = cards.get(i);
            cc.setBounds(h_offset * i, v_offset * i, CardComponent.CARD_WIDTH, 
                    CardComponent.CARD_HEIGHT);
            add(cc, (Integer) i);
            cc.addMouseListener(listener);
        }

        // Handle the 90-degree trump card under the deck
        i = -1;
        CardComponent trump = new CardComponent(deck.getTrump());
        trump.setRotate(true);
        trump.setBounds(0, trump_offset, CardComponent.CARD_HEIGHT, CardComponent.CARD_WIDTH);
        add(trump, (Integer) i);
        trump.addMouseListener(listener);
    }
}
