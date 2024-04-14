package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

import Forms.Rectangle;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class DrawingPanel extends JPanel {
    
    private Rectangle selectedShape = null;
    private ArrayList<Rectangle> shapes = new ArrayList<>();
    private Color currentColor = Color.RED;
    
    public DrawingPanel() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                for (Rectangle shape : shapes) {
                    if (shape.appartientPoint(e.getX(), e.getY())) {
                        selectedShape = shape;
                        break;
                    }
                }
            }

            public void mouseReleased(MouseEvent e) {
                selectedShape = null;
            }
        });
        
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (selectedShape != null) {
                    selectedShape.deplacerRect(e.getX() - selectedShape.getX1(), e.getY() - selectedShape.getY1());
                    repaint();
                }
            }
        });
    }
    
    public void clearShapes() {
        shapes.clear(); 
        repaint(); 
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Rectangle shape : shapes) {
        	g2d.setColor(shape.getColor());
            shape.paint(g2d);
        }
    }

    public void addShape(Rectangle shape) {
        shapes.add(shape);
        repaint();
    }
    
    public ArrayList<Rectangle> getShapes() {
        return shapes;
    }
    
    public void setShapes(ArrayList<Rectangle> shapes) {
        this.shapes = shapes;
        repaint(); 
    }
    
    public void setCurrentColor (Color color) {
    	currentColor = color;
    }
    
    public Color getCurrentColor() {
        return currentColor;
    }
    
    
    public BufferedImage getPanelImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();
        return image;
    }

    
    
}