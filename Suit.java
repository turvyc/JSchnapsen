import java.awt.Color;

public enum Suit {

    CLUBS       (Color.BLACK),
    DIAMONDS    (Color.RED),
    HEARTS      (Color.RED),
    SPADES      (Color.BLACK);

    private final Color color;

    Suit(Color c) {
        this.color = c;
    }

    Color color() { return color; }
}
