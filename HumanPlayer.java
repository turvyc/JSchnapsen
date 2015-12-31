/**
 * Represents a human player.
 */
public class HumanPlayer extends Player {

    private String name;

    public HumanPlayer(String n) {
        super();
        name = n;
    }

    @Override
    public void giveCard(Card c) {
        c.setVisible(true);
        super.giveCard(c);
    }
}
