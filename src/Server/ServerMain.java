package Server;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Forms.Rectangle;

public class ServerMain extends UnicastRemoteObject implements ServerInterface {
    protected ServerMain() throws RemoteException {
        super();
    }

    @Override
    public void saveShapes(ArrayList<Rectangle> shapes) throws RemoteException {
        // Nom du fichier de sauvegarde
        String fileName = "shapes.ser";

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            // Écriture des formes dans le fichier
            out.writeObject(shapes);
            
           // Fermer le flux de sortie
            out.close();
            fileOut.close();
            
            System.out.println("Formes sauvegardees avec succes dans " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des formes : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            ServerMain obj = new ServerMain();
            // Exporte l'objet distant
            ServerInterface stub = (ServerInterface) obj;

            // Cree le registre RMI
            java.rmi.registry.LocateRegistry.createRegistry(1099);

            // Enregistre l'objet distant dans le registre
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.getRegistry();
            registry.rebind("Server", stub);

            System.out.println("Server rmi ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
