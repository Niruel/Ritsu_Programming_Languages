import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class WorkingWith_Affine_TRansform extends JFrame {
    BufferedImage bI1;
    BufferedImage bI2;
    String fileName = "imageA.jpg";
    int xCenter;
    int yCenter;
    double scale = 0.7;
    double rotate = Math.toRadians(6);

    WorkingWith_Affine_TRansform() {
        setSize(660, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyListenter myListenter = new MyListenter();
        addMouseListener(myListenter);
        initialazation();
        Transform();
        setVisible(true);

    }

    public void paint(Graphics g) {
        int hpostion = 550;
        int size = 5;
        if (bI1 != null) {
            g.drawImage(bI1, 10, 60, bI1.getWidth() / 2, bI1.getHeight() / 2, this);
        }
        if (bI2 != null) {
            g.drawImage(bI2, 10, hpostion, this);
        }
        g.setColor(Color.red);
        g.fillRect(xCenter - size / 2 + 10, yCenter - size / 2 + 60, size, size);
    }

    void initialazation() {
        try {
            bI1 = ImageIO.read(new File(fileName));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    void Transform() {
        bI2 = new BufferedImage(bI1.getWidth(), bI1.getHeight(), bI1.getType());
        AffineTransform affine = new AffineTransform();
        affine.translate(xCenter, yCenter);
        affine.scale(scale, scale);
        affine.rotate(rotate);
        affine.translate(-xCenter, -yCenter);
        AffineTransformOp op = new AffineTransformOp(affine, AffineTransformOp.TYPE_BICUBIC);
        op.filter(bI1, bI2);
    }

    public static void main(String[] args) {
        new WorkingWith_Affine_TRansform();
    }

    class MyListenter extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            xCenter = e.getX() - 10;
            yCenter = e.getY() - 60;
            System.out.println(xCenter + ", " + yCenter);
            Transform();
            repaint();
        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseDragged(MouseEvent e) {

        }
    }
}