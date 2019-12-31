
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.BorderLayout;

public class el_EX_21 extends JFrame implements ActionListener, MouseListener {
    // Set booleans to be used throughout the code
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;

    Color color;// Color variable to be changed based on the flags

    int xCenter;
    int yCenter;
    int size = 100;// size of object
    int colorIndex = 0;// number to change color
    int shapeIndex = 0;// number to change shape

    Color[] colorSet = { Color.red, Color.yellow, Color.green, Color.blue };// array of colors
    String[] colorLabel = { "Red", "Yellow", "Green", "Blue" };// string array for button
    String[] shapeLabel = { "Circle", "Square" };// string array for shape switch

    // this included in my instruction at the top
    // JButton button1, button2;
    JButton button1;
    JButton button2;

    public el_EX_21() {
        setTitle("Painter");// Title can be taken off if you wish

        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button1 = new JButton(colorLabel[colorIndex]);// set the button to the color label index color
        button1.addActionListener(this);
        button1.setActionCommand("btn1");

        button2 = new JButton(shapeLabel[shapeIndex]);// set the button to the shape label index shape
        button2.addActionListener(this);
        button2.setActionCommand("btn2");

        JPanel panel1 = new JPanel();
        panel1.add(button1);
        panel1.add(button2);
        getContentPane().add(panel1, BorderLayout.NORTH);
        addMouseListener(this);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 70, 500, 450);
        if (flag1) {
            Font font1 = new Font("Dialoge", Font.PLAIN, 20);
            g.setFont(font1);
            g.setColor(Color.red);
            g.drawString("Enter", 440, 50);
        }
        if (flag2) {// if true draw circle
            g.setColor(colorSet[colorIndex]);
            g.fillOval(xCenter - size / 2, yCenter - size / 2, size, size);
        }
        if (flag3) {// if true draw a square
            g.setColor(colorSet[colorIndex]);
            g.fillRect(xCenter - size / 2, yCenter - size / 2, size, size);
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        flag1 = true;
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        flag1 = false;
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        // System.out.println(shapeIndex);
        // Check the index of the shape 0 for circle shape 1 for square shape
        if (shapeIndex == 0) {
            flag2 = true;

            xCenter = e.getX();
            yCenter = e.getY();
            color = colorSet[colorIndex];
            repaint();

        } else if (shapeIndex == 1) {

            flag3 = true;
            xCenter = e.getX();
            yCenter = e.getY();
            color = colorSet[colorIndex];
            repaint();
        }

    }

    public void mouseReleased(MouseEvent e) {
    }

    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();
        if (cmd.equals("btn1")) {
            colorIndex++;
            if (colorIndex > 3) {
                colorIndex = 0;
            }
            button1.setText(colorLabel[colorIndex]);
            color = colorSet[colorIndex];
            repaint();// repaint after the action
        } else if (cmd.equals("btn2")) {
            shapeIndex++;
            if (shapeIndex > 1) {
                shapeIndex = 0;
            }
            // Check shape index again and set the opposite flag to false
            if (shapeIndex == 0) {
                flag2 = true;
                flag3 = false;
                button2.setText(shapeLabel[shapeIndex]);// set to the index
                repaint();// repaint after every change
            }
            if (shapeIndex == 1) {
                flag2 = false;
                flag3 = true;
                button2.setText(shapeLabel[shapeIndex]);// set to the index
                repaint();// repaint after every change
            }
        }

    }

    public static void main(String[] args) {

        new el_EX_21();
    }
}