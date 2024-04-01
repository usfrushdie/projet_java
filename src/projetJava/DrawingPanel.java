package projetJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
    
    public DrawingPanel() {
        setBackground(Color.WHITE); // Couleur de fond
    }

    @Override
    protected void paintComponent(Graphics g) {
    	Rectangle t = new Rectangle(0,0,0,0);
        super.paintComponent(g);  
        Graphics2D g2d = (Graphics2D) g;
        int x1, y1, x2, y2;
        x1 = t.getX1();
        y1 = t.getY1();
        x2 = t.getX2();
        y2 = t.getY2();
        
		int width = Math.abs(x2 - x1);
		int height = Math.abs(y2 - y1);
		int upperLeftX = Math.min(x1, x2);
		int upperLeftY = Math.min(y1, y2);
		g2d.drawRect(upperLeftX, upperLeftY, width, height);
	
    }
    
    public void paint(Graphics g) {
    	Rectangle t = new Rectangle(0,0,0,0);
        super.paint(g);      
    }
}
