import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JFrame;

public class WorkingWithImages extends JFrame {
    BufferedImage bimage;
    String filename = "Rage.jpg";

    WorkingWithImages() {
        setTitle("Monkey");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        takeImage();
    }

    public void paint(Graphics g) {
        if (bimage != null) {
            g.drawImage(bimage, 10, 30, this);
        }
    }

    public void takeImage() {
        try {
            File file = new File(filename);
            bimage = ImageIO.read(file);
            System.out.println("Width = " + bimage.getWidth() + " Height = " + bimage.getHeight());
            System.out.println("Type: " + bimage.getType() + " fileID: " + BufferedImage.TYPE_3BYTE_BGR);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error " + e);
        }
        repaint();
    }

    public static void main(String[] args) {
        new WorkingWithImages();
    }
}