
/**
 * SwitchInterface
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SwitchInterface extends JFrame implements MouseListener {

    boolean flag = false;
    boolean flag1 = false;
    Color color;
    int xCenter;
    int yCenter;
    int size = 100;

    public SwitchInterface() {
        setTitle("Painter");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(this);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, 500, 500);
        if (flag) {
            Font font = new Font("Dialoge", Font.PLAIN, 20);
            g.setFont(font);
            g.setColor(Color.red);
            g.drawString("Enter", 440, 50);

        }
        if (flag1) {
            g.setColor(color);
            g.fillOval(xCenter - size / 2, yCenter - size / 2, size, size);

        }
    }

    public void mouseClicked(MouseEvent e) {
        flag1 = true;
        color = Color.green;
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
        flag = true;
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        flag = false;
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        flag1 = true;
        xCenter = e.getX();
        yCenter = e.getY();
        color = Color.red;
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        flag1 = false;
        repaint();
    }

    public static void main(String[] args) {
        new SwitchInterface();
    }
}