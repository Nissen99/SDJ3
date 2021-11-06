package server;

import client.ICallBackClient;
import shared.TransferObject;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class RMIServer implements IRMIServer {

    private HashMap<ICallBackClient, ArrayList<String>> callBackClients = new HashMap<>();

    public RMIServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);

    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", this);
        System.out.println("Server Started....");


    }



    @Override
    public void addCallback(ICallBackClient callBackClient, ArrayList<String> wantUpdateType) throws RemoteException {

        callBackClients.put(callBackClient, wantUpdateType);
        System.out.println("Client added with: " + wantUpdateType);
    }

    @Override
    public void publish(TransferObject transferObject) throws RemoteException {

        for (ICallBackClient callback : callBackClients.keySet()) {
            try {
                ArrayList<String> types = callBackClients.get(callback);

                if (types.contains(transferObject.getType())) {
                    callback.update(transferObject);
                }
            } catch (Exception e){
                System.out.println("Failed");
            }

        }
    }
}
