package projetJava;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class Windowbuilder extends JFrame {

    private JPanel contentPane;
    Rectangle t = new Rectangle(0,0,0,0); // temporaire
	ArrayList<Rectangle> r = new ArrayList<Rectangle>(); 
    //private int shapeType = 1; // 0: Line, 1: Rectangle, 2: Circle 
	private boolean enableDrawing = false; // pour vérifier si le bouton rectangle est cliqué ou non

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Windowbuilder frame = new Windowbuilder();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Windowbuilder() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1110, 817);
        this.setLocation(200,100);;
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        

        // Bouton
        JButton btnRectangle = new JButton("Rectangle");
        btnRectangle.setBackground(new Color(0, 255, 0));
        btnRectangle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		enableDrawing = !enableDrawing; // on peut dessiner après que la variable est true
        	}
        });
        btnRectangle.setBounds(20, 85, 113, 47);
        contentPane.add(btnRectangle);
        
        // Plan de dessin
        final DrawingPanel panel = new DrawingPanel(); // de type 'final' afin que les conditions dans 'mousePressed' et 'mouseReleased' fonctionnent
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 142, 1074, 625);
        contentPane.add(panel);
        
        // Titre
        JLabel lblFormsEditor = new JLabel("PolyMorph : Design your dreams");
        lblFormsEditor.setBounds(191, 11, 748, 50);
        contentPane.add(lblFormsEditor);
        lblFormsEditor.setForeground(new Color(0, 0, 0));
        lblFormsEditor.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblFormsEditor.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(0, 0, 1094, 73);
        contentPane.add(panel_1);
        panel_1.setLayout(new CardLayout(0, 0));
                
        // LOGO
        JLabel lblNewLabel = new JLabel("");
        panel_1.add(lblNewLabel, "name_612034044413900");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bayah\\OneDrive\\Images\\iTop Screenshot\\chmch2.jpeg"));
                

        
        panel.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        // Vérifie si le clic de souris est à l'intérieur du panel
	        	if ( enableDrawing && e.getX() >= 0 && e.getX() <= panel.getWidth() && e.getY() >= 0 && e.getY() <= panel.getHeight()) {
	        			t.setX1(e.getX());
	        			t.setY1(e.getY());
	            }
	        }

	        public void mouseReleased(MouseEvent e) {
	        // Vérifie si le relâchement de la souris est à l'intérieur du panel
	        	if ( enableDrawing && e.getX() >= 0 && e.getX() <= panel.getWidth() && e.getY() >= 0 && e.getY() <= panel.getHeight()) {
	        		t.setX2(e.getX());
	                t.setY2(e.getY());
	                r.add(t); // ajout du rectangle t à la liste r définie au début
	                t.paint(panel.getGraphics());
	                enableDrawing = false; // réinitialise la variable à son état d'origine (interdit le dessin de nouveaux rectangles sans recliquer sur le bouton 'Rectangle')
	            }
	        }	
        });
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        
        
      
    }
    
    
}
