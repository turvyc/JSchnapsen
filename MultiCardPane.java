import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLayeredPane;

/**
 * A class to display multiple Card components, such as the deck or a hand.
 */
public class MultiCardPane extends JLayeredPane implements Observer {

    // The cards in this hand
    ArrayList<Card> cards;

    // The horizontal offset in pixels to display the cards
    protected int h_offset;

    // The vertical offset distance
    protected int v_offset;

    /**
     * Creates a new empty HandPane.
     * @param h the horizontal offset to display successive cards in pixels
     * @param v the vertical offset to display successive cards in pixels
     */
    public MultiCardPane(int h, int v) {
        cards = new ArrayList<Card>();
        h_offset = h;
        v_offset = v;
    }

    @Override
    public Dimension getPreferredSize() {
        int width = CardComponent.CARD_WIDTH + (cards.size() * h_offset);
        int height = CardComponent.CARD_HEIGHT + (cards.size() + v_offset);
        return new Dimension(width, height);
    }

    @Override
    public void update(Observable o, Object arg) {
        CardGrouping cg = (CardGrouping) o;
        cards = cg.getCards();

        // Display the card components
        for (int i = 0; i < cards.size(); i++) {
            CardComponent cc = new CardComponent(cards.get(i));
            cc.setBounds(h_offset * i, v_offset * i, CardComponent.CARD_WIDTH, 
                    CardComponent.CARD_HEIGHT);
            add(cc, (Integer) i);
        }
    }
}
