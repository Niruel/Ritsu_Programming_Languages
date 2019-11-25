/*
 *  Created By: Nicholas Ruppel
 *  Class: Programming Practice
 *  Ecercise: 17
 *  Date 2019/11/19
 */
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Exercise17 extends JFrame{
    JButton button1,
            button2;
    JTextField text1;
    public Exercise17(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        button1 = new JButton("Red");
        JPanel panel1 = new JPanel();
        panel1.add(button1);

        button2 = new JButton("Green");
        panel1.add(button2);

        text1 = new JTextField("", 20);
        JPanel panel2 = new JPanel();
        panel2.add(text1);

        button1.addMouseListener(new ButtonListener());
        button2.addMouseListener(new ButtonListener2());
        getContentPane().add(panel1,BorderLayout.NORTH);
        getContentPane().add(panel2,BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Exercise17();
    }
    class ButtonListener extends MouseAdapter{
        
         public void mousePressed(MouseEvent e){

             
                 text1.setText("The Red button was pressed");
            
         
         }
     }
     class ButtonListener2 extends MouseAdapter{
        
        public void mousePressed(MouseEvent e){

            
                text1.setText("The Green button was pressed");
           
        
        }
    }
}
