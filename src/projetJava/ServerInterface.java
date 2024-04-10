package projetJava;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerInterface extends Remote {
    void saveShapes(ArrayList<Rectangle> shapes) throws RemoteException;
}


