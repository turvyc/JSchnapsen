import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles events for the GUI buttons.
 */
class ButtonListener implements ActionListener {

    GameController controller;

    public ButtonListener(GameController c) {
        controller = c;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GameFrame.CALL_SCHNAPSEN))
            System.out.println("You called Schnapsen!");
        else if (e.getActionCommand().equals(GameFrame.CLOSE_DECK))
            System.out.println("You closed the deck!");
        else if (e.getActionCommand().equals(GameFrame.SHOW_MARRIAGE))
            System.out.println("You showed a marriage!");
    }
}
