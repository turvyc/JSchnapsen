public enum Suit {

    CLUBS       (Color.BLACK),
    DIAMONDS    (Color.RED),
    HEARTS      (Color.RED),
    SPADES      (Color.BLACK),
    JOKER       (Color.NONE);

    public enum Color { 
        BLACK, 
        RED,
        NONE 
    }

    private final Color color;

    Suit(Color c) {
        this.color = c;
    }

    public Color getColor() { return color; }
}
