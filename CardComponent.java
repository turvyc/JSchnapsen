import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CardComponent extends JComponent {

    // A reference to the card this component represents
    Card card;

    // The actual card image dimensions (in /img folder)
    private final int CARD_WIDTH = 726;
    private final int CARD_HEIGHT = 500;

    // Image file constants
    private String IMG_DIR = "img/";
    private String IMG_FILETYPE = ".png";
    private String IMG_SEPERATOR = "_";
    private String BACK_FILENAME = "BACK";

    public CardComponent(Card c) {
        card = c;
        card.setVisible(true);
        setPreferredSize(new Dimension(CARD_HEIGHT, CARD_WIDTH));
        setOpaque(true);
    }

    /**
     * Returns the graphical image of the card.
     * @return the image
     */
    public BufferedImage getImage() {
        // Generate the filename
        String filename;
        if (card.isVisible()) {
            filename = IMG_DIR + card.getRank().name() +
                IMG_SEPERATOR + card.getSuit().name() + IMG_FILETYPE;
        }
        else
            filename = IMG_DIR + BACK_FILENAME + IMG_FILETYPE;

        // Create the image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(getImage(), 0, 0, null);
    }
}
