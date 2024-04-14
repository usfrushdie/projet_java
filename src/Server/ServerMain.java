package Server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Forms.Rectangle;

public class ServerMain extends UnicastRemoteObject implements ServerInterface {
    protected ServerMain() throws RemoteException {
        super();
    }

    @Override
    public void saveShapes(ArrayList<Rectangle> shapes) throws RemoteException {
        // Implémentation de la logique de sauvegarde des formes sur la machine distante
    }

    public static void main(String[] args) {
        try {
            ServerMain obj = new ServerMain();
            // Exporte l'objet distant
            ServerInterface stub = (ServerInterface) obj;

            // Crée le registre RMI
            LocateRegistry.createRegistry(1099);

            // Enregistre l'objet distant dans le registre
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Server", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}