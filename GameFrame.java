import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameFrame extends JFrame {

    private GameController controller;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;
    private String FRAME_TITLE = "JSchnapsen";

    public GameFrame(GameController c) {
        controller = c;

        // Set window properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle(FRAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createOptionsMenu());
        menuBar.add(createAboutMenu());
    }

    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");

        // Define the items
        JMenuItem exit = new JMenuItem("Exit");

        // Add them to the menu
        menu.add(exit);

        // Attach them to the controller
        exit.addActionListener(controller);

        return menu;
    }

    private JMenu createOptionsMenu() {
        JMenu menu = new JMenu("Options");

        // Define the items
        JMenuItem blank = new JMenuItem("Blank");

        // Add them to the menu
        menu.add(blank);

        // Attach them to the controller
        blank.addActionListener(controller);

        return menu;
    }

    private JMenu createAboutMenu() {
        JMenu menu = new JMenu("About");

        // Define the items
        JMenuItem about = new JMenuItem("About JSchnapsen");

        // Add them to the menu
        menu.add(about);

        // Attach them to the controller
        about.addActionListener(controller);

        return menu;
    }
}
