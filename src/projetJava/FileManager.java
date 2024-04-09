package projetJava;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileManager {
	private DrawingPanel panel;
	private WindowFrame windowFrame;

	
	public void setWindowFrame(WindowFrame windowFrame) {
        this.windowFrame = windowFrame;
    }
	
	public void getWindowFrame(WindowFrame windowFrame) {
        this.windowFrame = windowFrame;
    }
	
	public void setPanel(DrawingPanel panel) {
	    this.panel = panel;
	}
	
	
	
	protected void saveAsPng() {
        BufferedImage image = panel.getPanelImage();
        try {
        	// On utilise une date en nom du fichier pour qu'on puisse sauvegarder plusieurs fichiers sans ecraser les anciens
        	String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            File outputFile = new File("Image" + timeStamp +".png"); // L'image se cree dans le repertoire actuel (src)
            ImageIO.write(image, "png", outputFile);
            
        } catch (IOException ex) {
            System.out.println("Erreur lors de l'enregistrement de l'image : " + ex.getMessage());
        }
    }
    
    
    protected void saveAsSerialized() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = "Sauvegarde_" + timeStamp + ".ser"; // Nom du fichier avec timestamp

        File fileToSave = new File(fileName); // Crée un objet File avec le chemin actuel (src) + nom du fichier

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave))) {
            oos.writeObject(panel.getShapes()); 
            System.out.println("Fichier sauvegardé dans : " + fileToSave.getAbsolutePath());
        } catch (IOException ex) {
            System.err.println("Erreur lors de la sauvegarde: " + ex.getMessage());
        }
    }


    protected void loadFromSerializedFile(WindowFrame parentFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisissez un fichier à charger");
        int userSelection = fileChooser.showOpenDialog(parentFrame); // Pour contenir le resultat du choix de l'utilisateur : il a choisi ouvrir ou annuler
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToLoad))) {
                // Efface les formes actuelles
                panel.clearShapes();
                
                // Lecture et ajout des formes à partir du fichier
                @SuppressWarnings("unchecked") // Pour eviter les erreurs de compilation (contrainte de type générique : objet <=> ArrayList<Rectangle>)
                ArrayList<Rectangle> loadedShapes = (ArrayList<Rectangle>) ois.readObject();
                for (Rectangle shape : loadedShapes) {
                    panel.addShape(shape);
                }
                
                panel.repaint(); // Redessine le panel avec les formes chargées
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Erreur lors du chargement du fichier: " + ex.getMessage());
            }
        }
    }

}
