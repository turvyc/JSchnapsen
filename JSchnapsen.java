/**
 * The main entry point for JSchnapsen.
 */
public class JSchnapsen {

    public static void main(String[] args) {

        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            Card c = deck.draw();
            c.setVisible(true);
            System.out.printf("Suit: %10s Rank: %8s Unicode: %s Count: %d\n",
                    c.getSuit(), c.getRank(), c.toString(), i + 1);
        }

    }
}
