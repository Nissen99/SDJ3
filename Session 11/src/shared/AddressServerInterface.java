package shared;

import model.Peer;

import java.rmi.Remote;
import java.rmi.RemoteException;



public interface AddressServerInterface
        extends Remote
{
    public boolean registerPeer( Peer peer ) throws RemoteException;

    public Peer findPeer(String alias ) throws RemoteException;


    public static final String SERVICE_NAME = "p2padr";
}
