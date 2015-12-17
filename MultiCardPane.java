import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLayeredPane;

/**
 * A class to display multiple Card components, such as the deck or a hand.
 */
public class MultiCardPane extends JLayeredPane implements Observer {

    // The cards in this hand
    ArrayList<CardComponent> cards;

    // The horizontal offset in pixels to display the cards
    private int h_offset;

    // The vertical offset distance
    private int v_offset;

    /**
     * Creates a new empty HandPane.
     * @param h the vertical offset to display successive cards in pixels
     * @param v the vertical offset to display successive cards in pixels
     */
    public MultiCardPane(int h, int v) {
        cards = new ArrayList<CardComponent>();
        h_offset = h;
        v_offset = v;
    }

    /**
     * Adds a card to the hand pane and redraws it.
     */
    public void addCard(CardComponent c) {
        cards.add(c);
    }

    public void showCards() {
        for (int i = 0; i < cards.size(); i++) {
            CardComponent c = cards.get(i);
            c.setBounds(h_offset * i, v_offset * i, CardComponent.CARD_WIDTH, 
                    CardComponent.CARD_HEIGHT);
            add(c, (Integer) i);
        }
    }

    public void setHOffset(int i) {
        h_offset = i;
    }

    public void setVOffset(int i) {
        v_offset = i;
    }

    @Override
    public Dimension getPreferredSize() {
        int width = CardComponent.CARD_WIDTH + (cards.size() * h_offset);
        int height = CardComponent.CARD_HEIGHT + (cards.size() + v_offset);
        return new Dimension(width, height);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("HandPane observed something!");
    }
}
