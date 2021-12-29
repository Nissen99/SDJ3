package shared;


import model.Message;
import model.Peer;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface PeerInterface
        extends Remote
{
    public void deliverMessage( Message message ) throws RemoteException;
    Peer getMe() throws RemoteException;

    Peer lookUp(String alias) throws RemoteException;
}
