package client;

import shared.TransferObject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICallBackClient extends Remote {

    void update(TransferObject transferObject) throws RemoteException;
}
