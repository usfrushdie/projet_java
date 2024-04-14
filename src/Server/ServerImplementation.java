package Server;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Forms.Rectangle;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
    protected ServerImplementation() throws RemoteException {
        super();
    }

    @Override
    public void saveShapes(ArrayList<Rectangle> shapes) throws RemoteException {
        try {
            // Creer un fichier pour sauvegarder les formes
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            // Ecrire les formes dans le fichier
            out.writeObject(shapes);
            
            // Fermer le flux de sortie
            out.close();
            fileOut.close();
            
            System.out.println("Formes sauvegardées avec succès.");
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des formes : " + e.getMessage());
        }
    }
}