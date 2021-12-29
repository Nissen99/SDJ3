package client.network;

import java.beans.PropertyChangeEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBackClient extends Remote {
    void update(PropertyChangeEvent event) throws RemoteException;
}
