package projetJava;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


class FormesFrame extends Frame {
	Rectangle t = new Rectangle(0,0,0,0);
	ArrayList<Rectangle> r = new ArrayList<Rectangle>();
    private int shapeType = 1; // 0: Line, 1: Rectangle, 2: Circle

    public FormesFrame() {
        setTitle("Créateur de Formes");
        setSize(800, 600);
        this.setUndecorated(true);
        this.setLocation(200,100);
        this.setLocationRelativeTo(null);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                t.setX1(e.getX());
                t.setY1(e.getY());
            }

            public void mouseReleased(MouseEvent e) {
            	t.setX2(e.getX());
                t.setY2(e.getY());
                r.add(t);
                t.paint(getGraphics());
            }
        });
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        this.addKeyListener(new KeyAdapter() {
		    public void keyPressed(KeyEvent e) {
		    	char ch = e.getKeyChar();
		        if (ch == 'q') {
		            System.exit(0);
		        }
		    }
		});
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int x1, y1, x2, y2;
        x1 = t.getX1();
        y1 = t.getY1();
        x2 = t.getX2();
        y2 = t.getY2();
        switch (shapeType) {
            case 0: // Line
                g2d.drawLine(x1, y1, x2, y2);
                break;
            case 1: // Rectangle
                int width = Math.abs(x2 - x1);
                int height = Math.abs(y2 - y1);
                int upperLeftX = Math.min(x1, x2);
                int upperLeftY = Math.min(y1, y2);
                g2d.drawRect(upperLeftX, upperLeftY, width, height);
                break;
            case 2: // Circle
                int diameter = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
                upperLeftX = x1 < x2 ? x1 : x1 - diameter;
                upperLeftY = y1 < y2 ? y1 : y1 - diameter;
                g2d.drawOval(upperLeftX, upperLeftY, diameter, diameter);
                break;
        }
    }

    public void setShapeType(int type) {
        shapeType = type;
    }
}