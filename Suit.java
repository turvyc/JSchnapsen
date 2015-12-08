public enum Suit {

    CLUBS       (Color.BLACK, "\u2663"),
    DIAMONDS    (Color.RED, "\u2666"),
    HEARTS      (Color.RED, "\u2665"),
    SPADES      (Color.BLACK, "\u2660"),
    JOKER       (Color.NONE, "\u1F0CF");

    public enum Color { 
        BLACK, 
        RED,
        NONE
    }
    private final Color color;
    private String unicode;

    Suit(Color c, String u) {
        this.color = c;
        this.unicode = u;
    }

    public Color getColor() { return color; }

    public String getUnicode() { return unicode; }
}
