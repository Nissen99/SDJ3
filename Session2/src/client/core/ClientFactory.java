package client.core;

import client.network.Client;
import client.network.IClient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFactory {


    private static ClientFactory clientFactory;
    private IClient client;

    private ClientFactory(){}

    public static ClientFactory getInstance(){
        if (clientFactory == null){
            clientFactory = new ClientFactory();
        }
        return clientFactory;
    }

    public IClient getClient() throws RemoteException {
        if (client == null){
            client = new Client();
            client.startClient();
        }
        return client;
    }
}
