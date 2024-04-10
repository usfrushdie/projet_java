package projetJava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {
    protected ServerImplementation() throws RemoteException {
        super();
    }

    @Override
    public void saveShapes(ArrayList<Rectangle> shapes) throws RemoteException {
        try {
            // Créer un fichier pour sauvegarder les formes
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            
            // Écrire les formes dans le fichier
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



