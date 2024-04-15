package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Forms.Rectangle;

public interface ServerInterface extends Remote {
    public void saveShapes(ArrayList<Rectangle> shapes) throws RemoteException;
}
