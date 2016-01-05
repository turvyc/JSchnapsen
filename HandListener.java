import java.awt.event.MouseEvent;
import java.lang.NullPointerException;
import javax.swing.event.MouseInputAdapter;

/**
 * Listens for user mouse clicks on card components.
 */
public class HandListener extends MouseInputAdapter {

    GameController controller;

    CardComponent selectedCard;

    public HandListener(GameController c) {
        controller = c;
        selectedCard = null;
    }

    public void mousePressed(MouseEvent e) {
        if (selectedCard == e.getComponent()) {
            selectedCard.setSelected(false);
            // Send it to the controller
        }
        else {
            try {
                selectedCard.setSelected(false);
            }
            catch (NullPointerException npe) {
                // Squelch! Just means there's no selected card right now.
            }
            finally {
                selectedCard = (CardComponent) e.getComponent();
                selectedCard.setSelected(true);
            }
        }
        selectedCard.repaint();
    }
}
