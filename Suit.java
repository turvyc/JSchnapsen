public enum Suit {

    CLUBS       (Color.BLACK),
    DIAMONDS    (Color.RED),
    HEARTS      (Color.RED),
    SPADES      (Color.BLACK);

    public enum Color { BLACK, RED }
    private final Color color;

    Suit(Color c) {
        this.color = c;
    }

    public Color getColor() { return color; }
}
