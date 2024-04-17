package Graphics;

import java.awt.CardLayout;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Files.FileManager;
import Forms.Rectangle;
import javax.swing.JColorChooser;


public class WindowFrame extends JFrame{
	private DrawingPanel panel;
    private JPanel contentPane;
	private boolean enableDrawing = false; // pour verifier si le bouton rectangle est clique ou non
	private FileManager fileManager;
    Rectangle t = new Rectangle(0,0,0,0,Color.RED); // temporaire


	
	public WindowFrame() {

        fileManager = new FileManager();
        fileManager.setWindowFrame(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1110, 817);
        this.setLocation(200,100);;
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Plan de dessin
        panel = new DrawingPanel(); 
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 142, 1074, 625);
        contentPane.add(panel);
        
        fileManager.setPanel(panel);

        
        // Boutons
        // Rectangle
        JButton btnRectangle = new JButton("Rectangle");
        btnRectangle.setBackground(new Color(0, 255, 0));
        btnRectangle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		enableDrawing = !enableDrawing; // on peut dessiner après que la variable est true
        	}
        });
        btnRectangle.setBounds(20, 85, 99, 47);
        contentPane.add(btnRectangle);
        
        //Intersection
        JButton btnNewButton = new JButton("");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setIcon(new ImageIcon(WindowFrame.class.getResource("/Images/intersection2.jpeg")));
        btnNewButton.setBounds(145, 85, 48, 47);
        contentPane.add(btnNewButton);
        
        //Union
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setIcon(new ImageIcon(WindowFrame.class.getResource("/Images/union.jpeg")));
        btnNewButton_1.setBounds(203, 85, 48, 47);
        contentPane.add(btnNewButton_1);
        
        //Minus
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        btnNewButton_2.setIcon(new ImageIcon(WindowFrame.class.getResource("/Images/minus.jpeg")));
        btnNewButton_2.setBounds(261, 85, 48, 47);
        contentPane.add(btnNewButton_2);
        
      //Clear
        JButton btnNewButton_3 = new JButton("Clear");
        btnNewButton_3.setBackground(new Color(255, 255, 128));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.clearShapes(); // Pour vider le panneau
            }
        });
        btnNewButton_3.setBounds(988, 85, 75, 47);
        contentPane.add(btnNewButton_3);
        
        //Export as png
        JButton btnSave = new JButton("Export as PNG");
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setBackground(new Color(0, 0, 128));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	fileManager.exportAsPng(); 
            }
        });
        btnSave.setBounds(617, 84, 125, 47);
        contentPane.add(btnSave);
        
        //Save 
        JButton btnSave_1 = new JButton("Save");
        btnSave_1.setForeground(new Color(255, 255, 255));
        btnSave_1.setBackground(new Color(0, 0, 128));
        btnSave_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	fileManager.saveAsSerialized();
            }
        });
        btnSave_1.setBounds(494, 84, 113, 47);
        contentPane.add(btnSave_1);
        
        //Distant saving
        JButton btnDistantSaving = new JButton("Distant saving");
        btnDistantSaving.setForeground(new Color(255, 255, 255));
        btnDistantSaving.setBackground(new Color(0, 0, 128));
        btnDistantSaving.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ipAddress = JOptionPane.showInputDialog(WindowFrame.this, "Entrez l'adresse IP de la machine distante:");
                if (ipAddress != null && !ipAddress.isEmpty()) {
                    // Utiliser l'adresse IP pour sauvegarder les formes dessinées
                    fileManager.distantSaveAsSerialized(ipAddress);
                }
            }
        });
        btnDistantSaving.setBounds(364, 85, 120, 47);
        contentPane.add(btnDistantSaving);
        
        //Color
        JButton btnColorChooser = new JButton("Color");
        btnColorChooser.setBackground(new Color(255, 128, 128));
        btnColorChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(WindowFrame.this, "Choose Rectangle Color", Color.RED); // la premiere forme sera rouge
                if (color != null) {
                    panel.setCurrentColor(color);
                }
            }
        });
        btnColorChooser.setBounds(903, 85, 75, 47);
        contentPane.add(btnColorChooser);
        
        //Fin Boutons
        
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
        lblNewLabel.setIcon(new ImageIcon(WindowFrame.class.getResource("/Images/logo.jpeg")));
        
        //Load
        JButton btnLoad = new JButton("Load");
        btnLoad.setForeground(new Color(255, 255, 255));
        btnLoad.setBounds(752, 85, 113, 47);
        contentPane.add(btnLoad);
        btnLoad.setBackground(new Color(0, 0, 128));
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	fileManager.loadFromSerializedFile(WindowFrame.this); // Appel de la methode pour charger le dessin
            }
        });
        
        
        
        panel.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        // Verifie si le clic de souris est à l'interieur du panel
	        	if ( enableDrawing && e.getX() >= 0 && e.getX() <= panel.getWidth() && e.getY() >= 0 && e.getY() <= panel.getHeight()) {
	        			t.setX1(e.getX());
	        			t.setY1(e.getY());
	            }
	        }
	        
	        public void mouseReleased(MouseEvent e) {
	        // Verifie si le relâchement de la souris est à l'interieur du panel
            if (enableDrawing && e.getX() >= 0 && e.getX() <= panel.getWidth() && e.getY() >= 0 && e.getY() <= panel.getHeight()) {
                t.setX2(e.getX());
                t.setY2(e.getY());
                Color currentColor = panel.getCurrentColor();
                panel.addShape(new Rectangle(t.getX1(), t.getX2(), t.getY1(), t.getY2(), currentColor));
	            enableDrawing = false; // reinitialise la variable à son etat d'origine (interdit le dessin de nouveaux rectangles sans recliquer sur le bouton 'Rectangle')
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