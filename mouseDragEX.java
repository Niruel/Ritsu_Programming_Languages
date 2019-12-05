import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class mouseDragEX extends JFrame implements MouseListener, MouseMotionListener {
    int xCenter;
    int yCenter;
    int size;

    public mouseDragEX() {
        setTitle("Interface Drag");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, 500, 500);
        g.setColor(Color.green);
        g.fillOval(xCenter - size / 2, yCenter - size / 2, size, size);

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        xCenter = e.getX();
        yCenter = e.getY();
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        size = (int) Math.hypot(xCenter - e.getX(), yCenter - e.getY()) * 2;
        repaint();
    }

    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        new mouseDragEX();
    }
}