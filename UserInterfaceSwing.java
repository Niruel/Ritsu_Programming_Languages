import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class UserInterfaceSwing extends JFrame {
    JButton button1, button2, button3, button4, button5, button6;
    JTextField text1;

    public UserInterfaceSwing() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("My Window");
        button1 = new JButton("Button1");
        button1.addMouseListener(new ButtonListener());
        text1 = new JTextField("", 20);
        JPanel p1 = new JPanel();
        p1.add(button1);
        p1.add(text1);
        getContentPane().add(p1, BorderLayout.NORTH);
        // Example 1
        /*
         * button1 = new JButton("North"); JPanel panel1 = new JPanel();
         * panel1.add(button1);
         * 
         * button2 = new JButton("East"); JPanel panel2 = new JPanel();
         * panel2.add(button2);
         * 
         * button3 = new JButton("West"); JPanel panel3 = new JPanel();
         * panel3.add(button3);
         * 
         * button4 = new JButton("South"); JPanel panel4 = new JPanel();
         * panel4.add(button4);
         * 
         * button5 = new JButton("Center"); JPanel panel5 = new JPanel();
         * panel5.add(button5);
         * 
         * getContentPane().add(panel1,BorderLayout.NORTH);
         * getContentPane().add(panel2,BorderLayout.EAST);
         * getContentPane().add(panel3,BorderLayout.WEST);
         * getContentPane().add(panel4,BorderLayout.SOUTH);
         * getContentPane().add(panel5,BorderLayout.CENTER);
         */

        /*
         * button1 = new JButton("Button1"); button2 = new JButton("Button2"); JPanel p1
         * = new JPanel(); p1.setLayout(new FlowLayout(FlowLayout.LEFT));
         * p1.add(button1); p1.add(button2);
         * getContentPane().add(p1,BorderLayout.NORTH);
         * 
         * button3 = new JButton("Button3"); button4 = new JButton("Button4"); JPanel p2
         * = new JPanel(); p2.setLayout(new FlowLayout(FlowLayout.CENTER));
         * p2.add(button3); p2.add(button4);
         * getContentPane().add(p2,BorderLayout.CENTER);
         * 
         * button5 = new JButton("Button5"); button6 = new JButton("Button6"); JPanel p3
         * = new JPanel(); p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
         * p3.add(button5); p3.add(button6);
         * getContentPane().add(p3,BorderLayout.SOUTH);
         */
        setVisible(true);

    }

    public static void main(String[] args) {
        new UserInterfaceSwing();
    }

    class ButtonListener extends MouseAdapter {
        int count = 0;
        String str;

        public void mousePressed(MouseEvent e) {
            str = text1.getText();
            Graphics g = getGraphics();
            g.clearRect(0, 0, 400, 300);
            Font font1 = new Font("Times New Roman", Font.PLAIN, 30);
            g.setFont(font1);
            g.setColor(Color.BLUE);
            g.drawString(str, 50, 100);
            /*
             * if (++count>1) { text1.setText("Pressed " + count + " times"); } else{
             * text1.setText("One press"); }
             */
        }
    }
}