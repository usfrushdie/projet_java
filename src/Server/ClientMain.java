/*
package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import projetJava.Rectangle;

public class ClientMain {
	
    public static void main(String[] args) {
        try {
            // Définir l'adresse IP à localhost
            String ipAddress = "localhost";
            int port = 1099; // Le même port que celui utilisé par le serveur

            // Obtenir le registre RMI local
            Registry registry = LocateRegistry.getRegistry(ipAddress, port);

            // Récupérer le service distant du registre RMI
            ServerInterface server = (ServerInterface) registry.lookup("Server");

            ArrayList<Rectangle> shapes = new ArrayList <>();
			// Maintenant, vous pouvez utiliser le service distant comme d'habitude
            // Par exemple, invoquez la méthode de sauvegarde distante
            server.saveShapes(shapes); // shapes est supposé être une ArrayList<Rectangle> à sauvegarder
        } catch (Exception e) {
            System.err.println("Erreur lors de la connexion au serveur : " + e.getMessage());
        }
    }
}
*/



