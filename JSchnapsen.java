/**
 * The main entry point for JSchnapsen.
 */
public class JSchnapsen {

    public static void main(String[] args) {
        Player p1 = new HumanPlayer("Colin");
        Player p2 = new ComputerPlayer("Magali");

        Game game = new Game(p1, p2);
        GameController controller = new GameController(game);
        GameFrame frame = new GameFrame(game, controller);

        frame.setVisible(true);

        // game.addObserver(frame);
        game.newGame();
        // game.play();

    }
}
