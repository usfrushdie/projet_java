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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class Windowbuilder extends JFrame {
	
	private DrawingPanel panel;
    private JPanel contentPane;
    Rectangle t = new Rectangle(0,0,0,0); // temporaire
	ArrayList<Rectangle> r = new ArrayList<Rectangle>(); 
    //private int shapeType = 1; // 0: Line, 1: Rectangle, 2: Circle 
	private boolean enableDrawing = false; // pour verifier si le bouton rectangle est clique ou non

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
        
        // Plan de dessin
        panel = new DrawingPanel(); // de type 'final' afin que les conditions dans 'mousePressed' et 'mouseReleased' fonctionnent
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 142, 1074, 625);
        contentPane.add(panel);
        

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
        btnNewButton.setIcon(new ImageIcon(Windowbuilder.class.getResource("/Images/intersection2.jpeg")));
        btnNewButton.setBounds(195, 85, 48, 47);
        contentPane.add(btnNewButton);
        
        //Union
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setIcon(new ImageIcon(Windowbuilder.class.getResource("/Images/union.jpeg")));
        btnNewButton_1.setBounds(265, 85, 48, 47);
        contentPane.add(btnNewButton_1);
        
        //Minus
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        btnNewButton_2.setIcon(new ImageIcon(Windowbuilder.class.getResource("/Images/minus.jpeg")));
        btnNewButton_2.setBounds(335, 85, 48, 47);
        contentPane.add(btnNewButton_2);
        
      //Clear
        JButton btnNewButton_3 = new JButton("Clear");
        btnNewButton_3.setBackground(new Color(255, 255, 128));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel.clearShapes(); // Pour vider le panneau
            }
        });
        btnNewButton_3.setBounds(960, 85, 113, 47);
        contentPane.add(btnNewButton_3);
        
        //Save as png
        JButton btnSave = new JButton("Save as png");
        btnSave.setBackground(new Color(255, 255, 128));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAsPng(); 
            }
        });
        btnSave.setBounds(826, 85, 113, 47);
        contentPane.add(btnSave);
        
        //Load
        JButton btnLoad = new JButton("Load");
        btnLoad.setBackground(new Color(255, 255, 128));
        btnLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadDrawing(); // Appel de la methode pour charger le dessin
            }
        });
        btnLoad.setBounds(692, 85, 113, 47);
        contentPane.add(btnLoad);
        
        //Save as Ser
        JButton btnSave_1 = new JButton("Save as Ser");
        btnSave_1.setBackground(new Color(255, 255, 128));
        btnSave_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveAsSerialized();
            }
        });
        btnSave_1.setBounds(553, 85, 113, 47);
        contentPane.add(btnSave_1);
        
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
        lblNewLabel.setIcon(new ImageIcon(Windowbuilder.class.getResource("/Images/logo.jpeg")));
        

        

        
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
                panel.addShape(new Rectangle(t.getX1(), t.getX2(), t.getY1(), t.getY2()));
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
    
    private void saveAsPng() {
        BufferedImage image = panel.getPanelImage();
        try {
            File outputFile = new File("forms.png"); // L'image se cree dans le repertoire actuel (src)
            ImageIO.write(image, "png", outputFile);
            
        } catch (IOException ex) {
            System.out.println("Erreur lors de l'enregistrement de l'image : " + ex.getMessage());
        }
    }
    

    private void saveAsSerialized() {
        try {
            // Capture du contenu de la fenetre en tant qu'image (Probleme de capture du haut panel aussi)
            BufferedImage image = new BufferedImage(contentPane.getWidth(), contentPane.getHeight(), BufferedImage.TYPE_INT_RGB);
            contentPane.paint(image.getGraphics());

            // Enregistrer l'image dans un fichier temporaire
            File tempFile = File.createTempFile("window_content", ".png");
            ImageIO.write(image, "png", tempFile);

            // Enregistrer le chemin du fichier temporaire dans le fichier .ser
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("window_content.ser"));
            objectOutputStream.writeObject(tempFile.getAbsolutePath());
            objectOutputStream.close();

            } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadDrawing() {
        // Creer une boîte de dialogue de selection de fichier
        JFileChooser fileChooser = new JFileChooser();
        
        // Definir le filtre de fichier pour ne montrer que les fichiers .ser
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Serialized files", "ser"));
        
        // Afficher la boîte de dialogue de selection de fichier
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                // Obtenir le fichier selectionne
                File selectedFile = fileChooser.getSelectedFile();
                
                // Charger l'image à partir du fichier selectionne
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(selectedFile));
                String imagePath = (String) objectInputStream.readObject();
                objectInputStream.close();
                
                // Charger l'image à partir du chemin du fichier
                BufferedImage loadedImage = ImageIO.read(new File(imagePath));
                
                // Afficher l'image dans le panneau
                Graphics g = panel.getGraphics();
                g.drawImage(loadedImage, 0, 0, null);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }





}