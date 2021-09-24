package client.core;

import client.model.ClientModel;
import client.model.IClientModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory {

    private static ModelFactory modelFactory;
    private IClientModel clientModel;


    private ModelFactory()
    {
    }

    public static ModelFactory getInstance()
    {
        if (modelFactory == null)
        {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }



    public IClientModel getModel() {
        if (clientModel == null)
        {
            try {
                clientModel = new ClientModel(
                        ClientFactory.getInstance().getClient());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return clientModel;
    }

}
