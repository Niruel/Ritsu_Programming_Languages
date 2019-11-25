/*
 *  Created By: Nicholas Ruppel
 *  Class: Programming Practice
 *  Ecercise: 15 
 *  Date 2019/11/11 
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Exercise15 extends JFrame{
     int winX = 500,
         winY = 500,
         XCenter,
         YCenter,
         OSize;
        

        Exercise15(){
            setSize(winX,winY);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true); 
            EventHandling eventHandling = new EventHandling();
            addMouseListener(eventHandling);
            addMouseMotionListener(eventHandling);
        }
        public void paint(Graphics g){
            g.setColor(Color.white);
            g.fillRect(0, 0, winX, winY);

            g.setColor(Color.yellow);
            g.fillArc(XCenter-OSize/2, YCenter-OSize/2, OSize, OSize,30,300);
    

        }
    public static void main(String[] args) {
        new Exercise15();
    }
    class EventHandling extends MouseAdapter{
        
        public void mousePressed(MouseEvent e){
            XCenter=e.getX();
            YCenter=e.getY();
        }
        public void mouseDragged(MouseEvent e){
            OSize = (int)Math.hypot(XCenter-e.getX(), YCenter-e.getY())*2;
            repaint();
        }
    }
  
}
