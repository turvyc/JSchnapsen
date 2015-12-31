import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Creates the main frame of the game, including the menu bar.
 */
public class GameFrame extends JFrame implements Observer {

    private Game game;
    private GameController controller;
    private MenuItemListener listener;

    private final int FRAME_WIDTH = 1000;
    private final int FRAME_HEIGHT = 1000;
    private String FRAME_TITLE = "JSchnapsen";

    public static String MENU_ITEM_EXIT = "Exit";
    public static String MENU_ITEM_BLANK = "Blank";
    public static String MENU_ITEM_ABOUT = "About";

    public GameFrame(Game g, GameController c) {
        game = g;
        controller = c;
        listener = new MenuItemListener();

        // Set frame properties
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle(FRAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Create the menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createOptionsMenu());
        menuBar.add(createAboutMenu());

        // Create the main panels
        JPanel opponentPanel = createOpponentPanel();
        JPanel centerPanel = createCenterPanel();
        JPanel playerPanel = createPlayerPanel();
        JPanel buttonPanel = createButtonPanel();

        // Add the panels to the frame, according to the constraints
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        add(opponentPanel, constraints);

        constraints.gridy = 1;
        constraints.weighty = 1;
        add(centerPanel, constraints);

        constraints.gridy = 2;
        constraints.weighty = 0.5;
        add(playerPanel, constraints);

        constraints.gridy = 3;
        constraints.weighty = 0.1;
        add(buttonPanel, constraints);

    }

    @Override
    public void update(Observable o, Object arg) {
        Game g = (Game) o;
    }

    private JPanel createOpponentPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.RED);
        MultiCardPane opponentHandPane = new MultiCardPane(25, 0);
        p.add(opponentHandPane);

        game.getOpponentHand().addObserver(opponentHandPane);
        MultiCardPane opponentHand = new MultiCardPane(25, 0);
        return p;
    }

    private JPanel createCenterPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.setBackground(Color.GREEN);

        MultiCardPane deck = new MultiCardPane(2, 2);
        MultiCardPane discard = new MultiCardPane(2, 2);

        p.add(deck, BorderLayout.WEST);
        p.add(discard, BorderLayout.EAST);
        return p;
    }

    private JPanel createPlayerPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.BLUE);
        MultiCardPane playerHandPane = new MultiCardPane(25, 0);
        p.add(playerHandPane);
        game.getPlayerHand().addObserver(playerHandPane);
        return p;
    }

    private JPanel createButtonPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.YELLOW);
        return p;
    }

    private JMenu createFileMenu() {
        JMenu menu = new JMenu("File");

        // Define the items
        JMenuItem exit = new JMenuItem(MENU_ITEM_EXIT);

        // Add them to the menu
        menu.add(exit);

        // Attach them to the controller
        exit.addActionListener(listener);

        return menu;
    }

    private JMenu createOptionsMenu() {
        JMenu menu = new JMenu("Options");

        // Define the items
        JMenuItem blank = new JMenuItem(MENU_ITEM_BLANK);

        // Add them to the menu
        menu.add(blank);

        // Attach them to the controller
        blank.addActionListener(listener);

        return menu;
    }

    private JMenu createAboutMenu() {
        JMenu menu = new JMenu("About");

        // Define the items
        JMenuItem about = new JMenuItem(MENU_ITEM_ABOUT);

        // Add them to the menu
        menu.add(about);

        // Attach them to the controller
        about.addActionListener(listener);

        return menu;
    }
}
