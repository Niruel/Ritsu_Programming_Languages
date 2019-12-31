import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JFrame;

public class WorkingWithImages2 extends JFrame {
    BufferedImage bimage;
    String filename = "Rage.jpg";
    double rate = 0.7;

    WorkingWithImages2() {
        setTitle("Monkey");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        takeImage();
    }

    public void paint(Graphics g) {
        if (bimage != null) {
            g.drawImage(bimage, 10, 30, (int) (bimage.getWidth() * rate), (int) (bimage.getHeight() * rate), this);
            System.out.println(
                    "Width = " + (int) (bimage.getWidth() * rate) + " Height = " + (int) (bimage.getHeight() * rate));

        }
    }

    public void takeImage() {
        try {
            File file = new File(filename);
            bimage = ImageIO.read(file);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error " + e);
        }
        repaint();
    }

    public static void main(String[] args) {
        new WorkingWithImages2();
    }
}