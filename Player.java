/**
 * Represents an abstract player, either human or AI.
 */
public abstract class Player {

    protected String name;

    protected Hand hand;
    
    protected int gamePoints;
    protected int handPoints;

    public Player(String n) {
        name = n;
        hand = new Hand();
        gamePoints = 0;
        handPoints = 0;
    }

    public String getName() {
        return name;
    }

    /**
     * Adds a single card to the player's hand.
     * @param c the card to be added to the player's hand
     */
    public void giveCard(Card c) {
        hand.add(c);
    }

    public Hand getHand() {
        return hand;
    }

    public void addGamePoints(int n) {
        gamePoints += n;
    }

    public int getGamePoints() {
        return gamePoints;
    }

    public void addHandPoints(int n) {
        handPoints += n;
    }

    public int getHandPoints() {
        return handPoints;
    }

    public void resetHandPoints() {
        handPoints = 0;
    }
}
