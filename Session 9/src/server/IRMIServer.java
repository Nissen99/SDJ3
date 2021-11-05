package server;

import client.ICallBackClient;
import shared.TransferObject;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIServer extends Remote {

    void addCallback(ICallBackClient callBackClient, String wantUpdateType) throws RemoteException;
    void publish(TransferObject transferObject) throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;
}
