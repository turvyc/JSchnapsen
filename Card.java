public class Card {

    private Rank rank;
    private Suit suit;

    private boolean visible;

    public Card(Rank r, Suit s) {
        rank = r;
        suit = s;
        visible = false;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Suit.Color getColor() {
        return suit.getColor();
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean b) {
        visible = b;
    }
}
