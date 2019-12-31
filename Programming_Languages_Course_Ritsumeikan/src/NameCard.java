/*
                *  Project Name: Name Card
                *  Created By: Nicholas Ruppel
                *  Class: Programming Languages 
                * 
                * 1st set width and height so the values dton't need to be hard coded
                * 2nd set the everything for the window size and basic operation in the constructor
                * 3rd create the paint function that calls from graphics class which is under awt import
                * 4th create my picture, I choose the logo of a famous store in the U.S. called Target
                * - 3 circles two red one white all at different size to make logo and text next to it
                * 5th create 4 text elements with their own fonts and styles and color
                * 6th run the function in the main 
                */

import java.awt.*;
import javax.swing.JFrame;

@SuppressWarnings("serial") // This is used to hide warning when extending from JFrame
public class NameCard extends JFrame {
    int width = 400;
    int height = 300;

    // Constructor
    NameCard() {
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, width, height);
        g.setColor(Color.red);
        g.fillOval(100, 70, 90, 90);

        g.setColor(Color.white);
        g.fillOval(115, 85, 60, 60);

        g.setColor(Color.red);
        g.fillOval(130, 100, 30, 30);

        Font font1 = new Font("TimesRoman", Font.PLAIN, 20);
        g.setFont(font1);
        g.setColor(Color.red);
        g.drawString("Target", 220, 130);

        Font name = new Font("Georgia", Font.PLAIN, 20);
        g.setFont(name);
        g.setColor(Color.red);
        g.drawString("Nicholas Ruppel, ID:2600190447-6", 50, 220);

        Font student = new Font("TimesRoman", Font.ITALIC, 20);
        g.setFont(student);
        g.setColor(Color.orange);
        g.drawString("I am a Student", 50, 240);

        Font Store = new Font("TimesRoman", Font.PLAIN, 20);
        g.setFont(Store);
        g.setColor(Color.black);
        g.drawString("The logo is from a store in America", 50, 260);

        Font Hobby = new Font("TimesRoman", Font.BOLD, 20);
        g.setFont(Hobby);
        g.setColor(Color.orange);
        g.drawString("Hobby: Creating Games", 50, 280);
    }

    public static void main(String[] args) {
        new NameCard();
    }
}