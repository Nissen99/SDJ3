package databaseServer.network;

import databaseServer.model.IDatabaseServerModel;
import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DatabaseServer implements IDatabaseServer {


    IDatabaseServerModel model;

    public DatabaseServer(IDatabaseServerModel model) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);

        this.model = model;
    }

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("databaseServer", this);
        System.out.println("DatabaseServer Started....");
    }


    @Override
    public void updatePerson(Person person) throws RemoteException {
        model.updatePerson(person);
    }

    @Override
    public Person getPerson(int accountNumber) {
        return model.getPerson(accountNumber);
    }

    @Override
    public Person login(String username, String password) {
        return model.login(username, password);
    }

    @Override
    public boolean registerUser(String username, String password) {
        return model.registerUser(username, password);
    }

}
