package Forms;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Rectangle implements Forme,Serializable{
		
	private int x1, x2, y1, y2;
	private Color color;

	public Rectangle(int x1, int x2, int y1, int y2, Color color) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
	}

	public int getX1() {
		return Math.min(x1,x2);
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return Math.max(x2, x1);
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY1() {
		return Math.min(y1,y2);
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return Math.max(y2,y1);
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getWidth() {
        return Math.abs(x2 - x1);
    }

    public int getHeight() {
        return Math.abs(y2 - y1);
    }

	public void deplacerRect(int dx, int dy) {
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
	}
	
	public boolean appartientPoint(int x, int y) {
	    int minX = Math.min(x1, x2);
	    int minY = Math.min(y1, y2);
	    int maxX = Math.max(x1, x2);
	    int maxY = Math.max(y1, y2);
	    
	    return (x >= minX && x <= maxX && y >= minY && y <= maxY);
	}
	
	public void redimensionner(int k) {
		this.x2 *= k;
		this.y2 *= k;
	}
	
	
	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    
	    int width = getWidth();
	    int height = getHeight();
	    
	    if(x1 <= x2 && y1 <= y2) {
	        g2.fillRect(x1, y1, width, height);
	    } else if (x1 <= x2 && y1 > y2) {
	        g2.fillRect(x1, y2, width, height);
	    } else if (x1 > x2 && y1 <= y2) {
	        g2.fillRect(x2, y1, width, height);
	    } else {
	        g2.fillRect(x2, y2, width, height);
	    }
	}
	
}