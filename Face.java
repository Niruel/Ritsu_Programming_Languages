/*
 * Face which is an upper class of three types of PacMan
 * Edited By Nicholas Ruppel 2019/12/02
 * use to set size, count, x and y center
 */

import java.awt.Color;
import java.awt.Graphics;

public class Face {
    private int size;
    private int xCenter;
    private int yCenter;
    private int angle;
    private int check;

    public Face() {
    }

    public Face(int size_, int x_, int y_, int angle_, int check_) {
        setSize(size_);
        setXCenter(x_);
        setYCenter(y_);
        setAngle(angle_);
        setCheck(check_);
    }

    public int getSize() {
        return (size);
    }

    public void setSize(int num) {
        size = num;
        if (xCenter != 0) {
            setXCenter(xCenter);
        }
        if (yCenter != 0) {
            setYCenter(yCenter);
        }
    }

    public int getCheck() {
        return (check);
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getXCenter() {
        return (xCenter);
    }

    public void setXCenter(int num) {
        if (size != 0) {
            if (num - size / 2 < 0) {
                size = num * 2;
            } else if (num + size / 2 > 500) {
                size = (500 - num) * 2;
            }
        }
        xCenter = num;
    }

    public int getYCenter() {
        return (yCenter);
    }

    public void setYCenter(int num) {
        if (size != 0) {
            if (num - size / 2 < 25) {
                size = (num - 25) * 2;
            } else if (num + size / 2 > 450) {
                size = (500 - num) * 2;
            }
        }
        yCenter = num;
    }

    public int getAngle() {
        return (angle);
    }

    public void setAngle(int num) {
        if (num > 90) {
            angle = 90;
        } else {
            angle = num;
        }
    }

    public void make(Graphics g) {
        g.setColor(Color.yellow);
        g.fillArc(xCenter - size / 2, yCenter - size / 2, size, size, angle / 2, 360 - angle);
    }
}
