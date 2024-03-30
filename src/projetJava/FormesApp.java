package projetJava;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FormesApp {
    public static void main(String[] args) {
        FormesFrame frame = new FormesFrame();
        frame.setVisible(true);
    }
}

class Forme {
    public int x1, y1, x2, y2;
    public int type;

    public Forme(int x1, int y1, int x2, int y2, int type) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.type = type;
    }
}

class FormesFrame extends Frame {
    private ArrayList<Forme> formes = new ArrayList<>();
    private int x1, y1, x2, y2;
    private int shapeType = 1; // 0: Line, 1: Rectangle, 2: Circle

    public FormesFrame() {
        setTitle("Créateur de Formes");
        setSize(600, 400);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                x1 = e.getX();
                y1 = e.getY();
            }

            public void mouseReleased(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                formes.add(new Forme(x1, y1, x2, y2, shapeType));
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                x2 = e.getX();
                y2 = e.getY();
                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        for (Forme forme : formes) {
            switch (forme.type) {
                case 0: // Line
                    g2d.drawLine(forme.x1, forme.y1, forme.x2, forme.y2);
                    break;
                case 1: // Rectangle
                    int width = Math.abs(forme.x2 - forme.x1);
                    int height = Math.abs(forme.y2 - forme.y1);
                    int upperLeftX = Math.min(forme.x1, forme.x2);
                    int upperLeftY = Math.min(forme.y1, forme.y2);
                    g2d.fillRect(upperLeftX, upperLeftY, width, height); 
                    break;
                case 2: // Circle
                    int diameter = Math.max(Math.abs(forme.x2 - forme.x1), Math.abs(forme.y2 - forme.y1));
                    int upperLeftXCircle = forme.x1 < forme.x2 ? forme.x1 : forme.x1 - diameter;
                    int upperLeftYCircle = forme.y1 < forme.y2 ? forme.y1 : forme.y1 - diameter;
                    g2d.fillOval(upperLeftXCircle, upperLeftYCircle, diameter, diameter); 
                    break;
            }
        }
    }

    public void setShapeType(int type) {
        shapeType = type;
    }
}
>>>>>>> origin/master
