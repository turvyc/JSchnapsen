import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles events for the menu items.
 */
class MenuItemListener implements ActionListener {

    GameController controller;

    public MenuItemListener(GameController c) {
        controller = c;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(GameFrame.MENU_ITEM_EXIT))
            System.exit(0);
    }
}
