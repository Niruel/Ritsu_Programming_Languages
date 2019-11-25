/*
 *  Created By: Nicholas Ruppel
 *  Class: Programming Practice
 *  Ecercise: 16 
 *  Date 2019/11/19
 */
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercise16 extends JFrame{
    JButton button1,
            button2;
    JTextField text1;
    public Exercise16(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        button1 = new JButton("Red");
        JPanel panel1 = new JPanel();
        panel1.add(button1);

        button2 = new JButton("Green");
        panel1.add(button2);

        text1 = new JTextField("This is a text field", 20);
        JPanel panel2 = new JPanel();
        panel2.add(text1);
        getContentPane().add(panel1,BorderLayout.NORTH);
        getContentPane().add(panel2,BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Exercise16();
    }
}
