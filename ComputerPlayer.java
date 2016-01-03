/**
 * Represents an AI player.
 */
public class ComputerPlayer extends Player {

    public ComputerPlayer(String n) {
        super(n);
        name = n;
    }

    @Override
    public void giveCard(Card c) {
        c.setVisible(false);
        super.giveCard(c);
    }
}
