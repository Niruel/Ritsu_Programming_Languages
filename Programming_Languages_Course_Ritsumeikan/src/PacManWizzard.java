/*
				* PacManWizzard that inherits PacMan
				* Created  By Nicholas Ruppel 2019/12/02
				* Made use of Pacman With eye and a added a wizzard hat
				*/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

public class PacManWizzard extends Face {

	public PacManWizzard(int size_, int x_, int y_, int angle_, int check_) {
		super(size_, x_, y_, angle_, check_);
	}

	public void make(Graphics g) {
		int xCenter = getXCenter();
		int yCenter = getYCenter();
		int size = getSize();
		super.make(g);

		g.setColor(Color.black);
		g.fillOval(xCenter - size / 12, yCenter - size / 3, size / 6, size / 6);

		Polygon polygon = new Polygon();
		polygon.addPoint(xCenter - size / 2, yCenter);
		polygon.addPoint(xCenter + size / 4, yCenter - 14 * size / 30);
		polygon.addPoint(xCenter - size, yCenter - 3 * size / 4);

		g.setColor(Color.blue);
		g.fillPolygon(polygon);

	}
}
