/**
 * Represents an abstract player, either human or AI.
 */
public abstract class Player {

    protected Hand hand;
    
    protected int gamePoints;
    protected int handPoints;

    protected Player() {
        hand = new Hand();
        gamePoints = 0;
        handPoints = 0;
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
}
