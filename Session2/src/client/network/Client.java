package client.network;

import businessServer.network.IBusinessServer;
import shared.Person;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements IClient, CallBackClient {

    private IBusinessServer businessServer;
    private Person loggedIn;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            businessServer = (IBusinessServer) registry.lookup("businessServer");
            businessServer.registerCallBackClient(this);
            System.out.println("Client Started....");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(int amount) {
        try {
            businessServer.deposit(loggedIn.getAccountNumber(), amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int amount) {
        try {
             businessServer.withdraw(loggedIn.getAccountNumber(), amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person login(String username, String password) {
        try {
            loggedIn = businessServer.login(username, password);
            return loggedIn;

        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void sendMoney(int amount, int accountNumberReceiver) {
        try {
            businessServer.sendMoney( loggedIn.getAccountNumber() ,amount, accountNumberReceiver);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int checkBalance() {
        try {
            return businessServer.checkBalance(loggedIn.getAccountNumber());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean registerUser(String username, String password) {
        try {
            return businessServer.registerUser(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Person getLoggedIn() {
        return loggedIn;
    }


    @Override
    public void update(PropertyChangeEvent event) throws RemoteException {
        businessServer.checkBalance(loggedIn.getAccountNumber());
        support.firePropertyChange(event);
        System.out.println("PropertyChange Client");
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
