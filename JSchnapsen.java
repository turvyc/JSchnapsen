/**
 * The main entry point for JSchnapsen.
 */
public class JSchnapsen {

    public static void main(String[] args) {

        Deck deck = new Deck();
        CardComparator comparator = new CardComparator();
        deck.sortBySuit(false);
        comparator.setTrump(Suit.HEARTS);
        deck.sort(comparator);

        for (int i = 0; i < 52; i++) {
            Card c = deck.draw();
            c.setVisible(true);
            System.out.print(c + " ");
        }
        System.out.print("\n");

    }
}
