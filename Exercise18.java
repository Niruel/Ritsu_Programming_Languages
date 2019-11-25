/*
 *  Created By: Nicholas Ruppel
 *  Class: Programming Practice
 *  Ecercise: 18
 *  Date 2019/11/19
 */
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Exercise18 extends JFrame{
    JButton button1,
            button2;
    JTextField text1;
    public Exercise18(){
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
        new Exercise18();
    }
    class ButtonListener extends MouseAdapter{
        String str;
        public void mousePressed(MouseEvent e){

                str = text1.getText();
               Graphics g = getGraphics();
               g.clearRect(0, 100, 400, 200);
               Font font1 = new Font("Rockwell", Font.PLAIN,30);
               g.setFont(font1);
               g.setColor(Color.RED);
               g.drawString(str, 50, 150);
               

           
        
        }
    }
    class ButtonListener2 extends MouseAdapter{
        String str;
       public void mousePressed(MouseEvent e){

           
        str = text1.getText();
        Graphics g = getGraphics();
        g.clearRect(0, 150, 400, 300);
        Font font1 = new Font("Georgia", Font.PLAIN,30);
        g.setFont(font1);
        g.setColor(Color.GREEN);
        g.drawString(str, 50, 200);
        
          
       
       }
   }
}