/**
 * Represents a human player.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String n) {
        super(n);
        hand.sortBySuit(false);
    }

    @Override
    public void giveCard(Card c) {
        super.giveCard(c);
        c.setVisible(true);
    }
}
