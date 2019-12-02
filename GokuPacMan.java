import javax.swing.*;
//import javax.swing.event.MouseInputListener;

//import jdk.internal.util.xml.impl.Input;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



@SuppressWarnings("serial")
public class GokuPacMan extends JFrame {
    int xScreen = 500,
        yScreen = 500,
        XCenter =200,
        YCenter =200,
        OSize =100;

    
        GokuPacMan(){
        setSize(xScreen,yScreen);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
       
    }
    public void paint(Graphics g){
        //g.clearRect(0, 0, xScreen, yScreen);
        g.setColor(Color.white);
        g.fillRect(0, 0, xScreen, yScreen);

        g.setColor(Color.yellow);
        g.fillArc(XCenter-OSize/2, YCenter-OSize/2, OSize, OSize, 30, 300);

        Polygon polygon = new Polygon();
		polygon.addPoint(XCenter-50 , YCenter);
		polygon.addPoint(90 , 110);
		polygon.addPoint(220 , 150);
        

        g.setColor(Color.blue);
		g.fillPolygon(polygon);


    }
    public static void main(String[] args) {
        new GokuPacMan();
    }
    
}
