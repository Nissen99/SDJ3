package server;

import client.ICallBackClient;
import shared.TransferObject;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IRMIServer extends Remote {

    void addCallback(ICallBackClient callBackClient, ArrayList<String> wantUpdateType) throws RemoteException;
    void publish(TransferObject transferObject) throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;
}
