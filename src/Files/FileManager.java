package Files;

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

import Forms.Rectangle;
import Graphics.DrawingPanel;
import Graphics.WindowFrame;
import Server.ServerInterface;

import java.rmi.ConnectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileManager {
	private DrawingPanel panel;
	private WindowFrame windowFrame;
    private ServerInterface server;

    
	public void setWindowFrame(WindowFrame windowFrame) {
        	this.windowFrame = windowFrame;
    }
	
	public WindowFrame getWindowFrame(WindowFrame windowFrame) {
		return windowFrame;
    }
	
	public void setPanel(DrawingPanel panel) {
	    this.panel = panel;
	}
	
	public void distantSaveAsSerialized(String ipAddress) {
        try {
            Registry registry = LocateRegistry.getRegistry(ipAddress, 1099);
            server = (ServerInterface) registry.lookup("Server");

            //Pour recuperer les formes depuis le panneau
            ArrayList<Rectangle> shapes = panel.getShapes();
            

            //Ppour sauvegarder les formes
            server.saveShapes(shapes);

            System.out.println("Formes sauvegardées avec succès sur la machine distante.");
        } catch (ConnectException e) {
            System.err.println("Impossible de se connecter au registre RMI. Assurez-vous que le serveur RMI est en cours d'exécution sur l'adresse IP spécifiée.");
        } catch (Exception e) {
            System.err.println("Erreur lors de la sauvegarde des formes sur la machine distante : " + e.getMessage());
        }
    }

	public void exportAsPng() {
        BufferedImage image = panel.getPanelImage();
        try {
        	// On utilise une date en nom du fichier pour qu'on puisse sauvegarder plusieurs fichiers sans ecraser les anciens
        	String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            File outputFile = new File("Image" + timeStamp +".png"); // L'image se cree dans le repertoire actuel
            ImageIO.write(image, "png", outputFile);
            
        } catch (IOException ex) {
            System.out.println("Erreur lors de l'enregistrement de l'image : " + ex.getMessage());
        }
    }
    
    
    public void saveAsSerialized() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String fileName = "Sauvegarde_" + timeStamp + ".ser"; // Nom du fichier avec timestamp

        File fileToSave = new File(fileName); // Cree un objet File avec le chemin actuel + nom du fichier

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSave))) {
            oos.writeObject(panel.getShapes()); 
            System.out.println("Fichier sauvegarde dans : " + fileToSave.getAbsolutePath());
        } catch (IOException ex) {
            System.err.println("Erreur lors de la sauvegarde: " + ex.getMessage());
        }
    }


    public void loadFromSerializedFile(WindowFrame parentFrame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choisissez un fichier à charger");
        int userSelection = fileChooser.showOpenDialog(parentFrame); // Pour contenir le resultat du choix de l'utilisateur : s'il a choisi ouvrir ou annuler
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToLoad))) {
                // Efface les formes actuelles
                panel.clearShapes();
                
                // Lecture et ajout des formes a partir du fichier
                @SuppressWarnings("unchecked") // Pour eviter les erreurs de compilation (contrainte de type generique : objet <=> ArrayList<Rectangle>)
                ArrayList<Rectangle> loadedShapes = (ArrayList<Rectangle>) ois.readObject();
                for (Rectangle shape : loadedShapes) {
                    panel.addShape(shape);
                }
         
                panel.repaint(); // Redessine le panel avec les formes chargees
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Erreur lors du chargement du fichier: " + ex.getMessage());
            }
        }
    }

}
