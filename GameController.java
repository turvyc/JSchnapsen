import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * Handles user input (mouse clicks in the GUI) and manipulates the Game model.
 */
public class GameController extends MouseInputAdapter {

    private Game game;

    public GameController(Game g) {
        game = g;
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getComponent());
    }
}
