import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


@SuppressWarnings("serial")
 class Inheratence_PL extends JFrame {
    final int x = 640;
    final int y = 480;
    /*Constructor */
    Inheratence_PL(int x, int y){
            setSize(x,y);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setVisible(true);
           
           
    }

    public void paint(Graphics g){
        g.clearRect(0, 0, x, y);
        Font font1 = new Font("TimesRoman", Font.PLAIN, 20);
        g.setFont(font1);
        g.setColor(Color.blue);
        g.drawString("Information Systems Science and Engineering", 20, 50);
       // g.drawPolygon();
        
        Font font2 = new Font("Georgia", Font.ITALIC, 20);
        g.setFont(font2);
        g.setColor(Color.green);
        g.drawString("Information Systems Science and Engineering", 20, 100);
        
        Font font3 = new Font("Monaco", Font.BOLD, 20);
        g.setFont(font3);
        g.setColor(Color.red);
        g.drawString("Information Systems Science and Engineering", 20, 150);
        
        Font font4 = new Font("Rockwell", Font.ITALIC|Font.BOLD, 20);
        g.setFont(font4);
        g.setColor(Color.black);
        g.drawString("Information Systems Science and Engineering", 20, 200);
        
        Font font5 = new Font("Zapino", Font.PLAIN, 20);
        g.setFont(font5);
        g.setColor(Color.yellow);
        g.drawString("Information Systems Science and Engineering", 20, 250);
        
        
    }
    public static void main(String[] args) {
        new Inheratence_PL(640,480);
    }
}