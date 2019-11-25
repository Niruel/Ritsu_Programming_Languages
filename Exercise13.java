/*
 *  Created By: Nicholas Ruppel
 *  Class: Programming Practice
 *  Ecercise: 13 
 *  Date 2019/11/11 
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Exercise13 extends JFrame{
     int winX = 500,
         winY = 500;
        Exercise13(){
            setSize(winX,winY);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true); 
            EventHandling eventHandling = new EventHandling();
            addMouseListener(eventHandling);
        }
        public void paint(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0, 0, winX, winY);

        }
    public static void main(String[] args) {
        new Exercise13();
    }
    class EventHandling extends MouseAdapter{
        int size = 50;
        public void mousePressed(MouseEvent e){
            if (e.getClickCount()==2) {
                Graphics g = getGraphics();
                g.setColor(Color.green);
                g.fillRect(e.getX()-size/2, e.getY()-size/2, size, size);
                g.dispose();
            }
            else{
                Graphics g = getGraphics();
                g.setColor(Color.red);
                g.fillRect(e.getX()-size/2, e.getY()-size/2, size, size);
                g.dispose();
            }
        }
    }
}