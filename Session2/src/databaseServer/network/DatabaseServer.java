package databaseServer.network;

import databaseServer.model.IDatabaseServerModel;
import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
    public ArrayList<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person getPerson(int accountNumber) {
        return null;
    }

    @Override
    public Person login(String username, String password) {
        return model.login(username, password);
    }

    @Override
    public boolean registerUser(String username, String password) {
        return model.registerUser(username, password);
    }

    @Override
    public void withdraw(int accountNumber, int amount) {
         model.withdraw(accountNumber, amount);
    }

    @Override
    public void deposit(int accountNumber, int amount) {
         model.deposit(accountNumber, amount);
    }

    @Override
    public int checkBalance(int accountNumber) {
        return model.checkBalance(accountNumber);
    }
}
