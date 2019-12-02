
/**
 * Painter
 * Created By Nicholas Ruppel 2019/12/02
 * Listen for two button clicks
 * each button has 3 functions
 * the first is to switch between each type of pac man 
 * pacman, pacmanwitheye, and pacmanwizzard
 * the next button will change between creation checking and changeing the pacman
 * Last is tne text box that does orgin of creation and when checking reads the name
 */
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Painter extends JFrame {
    Face face[] = new Face[10];
    int count = -1;
    int flag = 0;
    int mode = 0;

    JButton button1, button2;
    JTextField text;

    public Painter() {
        setTitle("painter");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MyListener myListener = new MyListener();
        addMouseListener(myListener);
        addMouseMotionListener(myListener);

        button1 = new JButton();
        button1.addMouseListener(new ButtonListener1());

        button2 = new JButton();
        button2.addMouseListener(new ButtonListener2());

        text = new JTextField();
        text.setColumns(16);

        JPanel p = new JPanel();
        p.add(button1);
        p.add(button2);
        p.add(text);

        getContentPane().add(p, BorderLayout.SOUTH);
        button2.setText("create mode");
        button1.setText("PacMan");
        text.setText("Click the center point");
        setVisible(true);

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.clearRect(0, 0, 500, 450);
        if (count >= 0) {
            if (count > 9) {
                count = 9;
            }
            for (int i = 0; i < count + 1; i++) {
                face[i].make(g);
            }
        }
    }

    public static void main(String[] args0) {
        new Painter();

    }

    class MyListener extends MouseAdapter {
        int distance;
        int xCenter;
        int yCenter;

        public void mousePressed(MouseEvent e) {

            if (mode == 0) {
                if (++count < 10) {
                    if (flag == 0) {
                        face[count] = new PacMan(0, e.getX(), e.getY(), 60, count);
                    } else if (flag == 1) {
                        face[count] = new PacManWithEye(0, e.getX(), e.getY(), 60, count);
                    } else if (flag == 2) {
                        face[count] = new PacManWizzard(0, e.getX(), e.getY(), 60, count);
                    }
                    repaint();
                    text.setText("the center is(" + e.getX() + "," + e.getY() + "");
                } else {
                    text.setText("no more PacMan");
                }
            } else if (mode == 1) {
                Boolean press = false;
                for (Face faceObj : face) {
                    if (faceObj != null) {
                        if (Math.hypot(e.getX() - faceObj.getXCenter(),
                                e.getY() - faceObj.getYCenter()) < faceObj.getSize() / 2) {
                            press = true;
                            if (faceObj instanceof PacMan) {
                                text.setText("This is PacMan");
                            } else if (faceObj instanceof PacManWithEye) {
                                text.setText("This is PacManWithEye");
                            } else if (faceObj instanceof PacManWizzard) {
                                text.setText("This is PacManWizzard");
                            } else {
                                text.setText("Type is not found");
                            }
                        }
                    }
                }
                if (!press) {
                    text.setText("Press a Pac-Man");
                }
            } else if (mode == 2) {
                Boolean found = false;
                for (Face faceObj : face) {
                    if (faceObj != null) {

                        if (Math.hypot(e.getX() - faceObj.getXCenter(),
                                e.getY() - faceObj.getYCenter()) < faceObj.getSize() / 2) {
                            found = true;
                            if (flag == 0) {
                                if (faceObj instanceof PacMan) {
                                    text.setText("Already PacMan");
                                } else {
                                    face[faceObj.getCheck()] = new PacMan(faceObj.getSize(), faceObj.getXCenter(),
                                            faceObj.getYCenter(), faceObj.getAngle(), faceObj.getCheck());
                                    text.setText("Changing to PacMan");
                                }
                            } else if (flag == 1) {
                                if (faceObj instanceof PacManWithEye) {
                                    text.setText("Already PacManWithEye");
                                } else {
                                    face[faceObj.getCheck()] = new PacManWithEye(faceObj.getSize(),
                                            faceObj.getXCenter(), faceObj.getYCenter(), faceObj.getAngle(),
                                            faceObj.getCheck());
                                    text.setText("Changing to  PacManWithEye");
                                }
                            } else if (flag == 2) {
                                if (faceObj instanceof PacManWizzard) {
                                    text.setText("Already PacManWizzard");
                                } else {
                                    face[faceObj.getCheck()] = new PacManWizzard(faceObj.getSize(),
                                            faceObj.getXCenter(), faceObj.getYCenter(), faceObj.getAngle(),
                                            faceObj.getCheck());
                                    text.setText("Changing to PacManWizzard");
                                }
                            }
                            repaint();
                        }
                    }
                }

                if (!found) {
                    text.setText("Press a Pac-Man");
                }
            }
        }

        public void mouseDragged(MouseEvent e) {
            if (count < 10) {
                distance = (int) Math.hypot(e.getX() - face[count].getXCenter(), e.getY() - face[count].getYCenter());
                face[count].setSize(distance * 2);
                text.setText(Integer.toString(distance * 2));
                repaint();
            }
        }
    }

    class ButtonListener1 extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (++flag > 2) {
                flag = 0;
            }
            if (flag == 0) {
                button1.setText("PacMan");
            } else if (flag == 1) {
                button1.setText("PacManWithEye");
            } else if (flag == 2) {
                button1.setText("PacManWizzard");
            }
        }
    }

    class ButtonListener2 extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            if (++mode > 2) {
                mode = 0;
            }
            if (mode == 0) {
                button2.setText("Create Mode");
            } else if (mode == 1) {
                button2.setText("Check Mode");
            } else if (mode == 2) {
                button2.setText("Change Mode");
            }
        }
    }
}