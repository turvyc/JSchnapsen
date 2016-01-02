import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class CardComponent extends JComponent {

    // A reference to the card this component represents
    Card card;

    // The actual card image dimensions (in /img folder)
    public static final int CARD_WIDTH = 125;
    public static final int CARD_HEIGHT = 182;

    // Image file constants
    private String IMG_DIR = "img/";
    private String IMG_FILETYPE = ".png";
    private String IMG_SEPERATOR = "_";
    private String BACK_FILENAME = "BACK";

    // Whether to rotate the image 90 degrees, used for the trump card
    private boolean rotate;

    public CardComponent(Card c) {
        card = c;
        rotate = false;
        setOpaque(true);
    }

    @Override
    public String toString() {
        return card.toString();
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

    public void setRotate(boolean b) {
        rotate = true;
    }

    @Override 
    public Dimension getPreferredSize() {
        return new Dimension(CARD_WIDTH, CARD_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage image = getImage();
        
        if (rotate) {
            AffineTransform at = new AffineTransform();
            at.translate(getWidth() / 2, getHeight() / 2);
            at.rotate(Math.PI / 2);
            at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
            g2.drawImage(image, at, null);
        }
        else
           g2.drawImage(image, 0, 0, null);
    }
}
