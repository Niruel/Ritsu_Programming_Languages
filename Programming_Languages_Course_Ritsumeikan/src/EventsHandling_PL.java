
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class EventsHandling_PL extends JFrame {
    int xScreen = 500, yScreen = 500, XCenter, YCenter, OSize;

    EventsHandling_PL() {
        setSize(xScreen, yScreen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        EventHandling eventHandling = new EventHandling();
        addMouseListener(eventHandling);
        addMouseMotionListener(eventHandling);
    }

    public void paint(Graphics g) {
        // g.clearRect(0, 0, xScreen, yScreen);
        g.setColor(Color.white);
        g.fillRect(0, 0, xScreen, yScreen);

        g.setColor(Color.green);
        g.fillOval(XCenter - OSize / 2, YCenter - OSize / 2, OSize, OSize);

        Polygon polygon = new Polygon();
        polygon.addPoint(210, 10);
        polygon.addPoint(200, 110);
        polygon.addPoint(220, 110);

        g.setColor(Color.blue);
        g.fillPolygon(polygon);

    }

    public static void main(String[] args) {
        new EventsHandling_PL();
    }

    class EventHandling extends MouseAdapter {
        int size = 50;

        /*
         * public void mousePressed(MouseEvent e){ XCenter=e.getX(); YCenter=e.getY(); }
         * public void mouseDragged(MouseEvent e){ OSize =
         * (int)Math.hypot(XCenter-e.getX(), YCenter-e.getY())*2; repaint(); }
         */
        // Mouse pressed
        public void mousePressed(MouseEvent e) {
            if (e.getClickCount() == 2) {
                Graphics g = getGraphics();
                g.setColor(Color.blue);
                g.fillOval(e.getX() - size / 2, e.getY() - size / 2, size, size);
                g.dispose();
            } else {
                Graphics g = getGraphics();
                g.setColor(Color.red);
                g.drawOval(e.getX() - size / 2, e.getY() - size / 2, size, size);
                g.dispose();
            }
        }

        // Right mouse clicked
        /*
         * public void mousePressed(MouseEvent e){ if ((e.getModifiersEx() &
         * MouseEvent.BUTTON3_DOWN_MASK)==MouseEvent.BUTTON3_DOWN_MASK) { Graphics g =
         * getGraphics(); g.setColor(Color.red); g.fillOval(e.getX()-size/2,
         * e.getY()-size/2, size, size); g.dispose(); } else{ Graphics g =
         * getGraphics(); g.setColor(Color.black); g.drawOval(e.getX()-size/2,
         * e.getY()-size/2, size, size); g.dispose(); } }
         */

        /*
         * public void mouseClicked(MouseEvent e){ System.out.println("Clicked at: (" +
         * e.getScreenX() + " , " + e.getScreenY() + ")"); } public void
         * mouseEntered(MouseEvent e){ System.out.println("Clicked at: (" +
         * e.getScreenX() + " , " + e.getScreenY() + ")"); } public void
         * mouseExited(MouseEvent e){ System.out.println("Clicked at: (" +
         * e.getScreenX() + " , " + e.getScreenY() + ")"); } public void
         * mousePressed(MouseEvent e){ System.out.println("Clicked at: (" +
         * e.getScreenX() + " , " + e.getScreenY() + ")"); } public void
         * mouseReleased(MouseEvent e){ System.out.println("Clicked at: (" +
         * e.getScreenX() + " , " + e.getScreenY() + ")"); }
         */
    }
}
