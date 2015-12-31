/**
 * Represents an AI player.
 */
public class ComputerPlayer extends Player {

    private String name;

    public ComputerPlayer(String n) {
        super();
        name = n;
    }

    @Override
    public void giveCard(Card c) {
        c.setVisible(false);
        super.giveCard(c);
    }
}
