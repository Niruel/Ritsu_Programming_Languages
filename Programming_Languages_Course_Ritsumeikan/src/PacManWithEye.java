/*
				* PacManWithSmile that inherits PacMan
				* Created By Nicholas Ruppel 2019/12/02
				* create pacman with eye
				*/

import java.awt.Color;
import java.awt.Graphics;

public class PacManWithEye extends Face {

	public PacManWithEye(int size_, int x_, int y_, int angle_, int check_) {
		super(size_, x_, y_, angle_, check_);
	}

	public void make(Graphics g) {
		int xCenter = getXCenter();
		int yCenter = getYCenter();
		int size = getSize();
		super.make(g);
		g.setColor(Color.black);
		g.fillOval(xCenter - size / 12, yCenter - size / 3, size / 6, size / 6);
	}
}
