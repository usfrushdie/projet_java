package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            // Creer un objet de l'implémentation serveur
            ServerInterface server = new ServerImplementation();

            // Demarrer un registre RMI sur le port spécifié (1099 par défaut)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Lier l'objet de l'implémentation serveur avec un nom dans le registre
            registry.rebind("Server", server);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage du serveur : " + e.getMessage());
        }
    }
}

