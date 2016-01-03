import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * Listens for user mouse clicks on card components.
 */
public class CardListener extends MouseInputAdapter {

    GameController controller;

    public CardListener(GameController c) {
        controller = c;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getComponent());
    }
}
