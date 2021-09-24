package client.network;

import businessServer.network.IBusinessServer;
import shared.Person;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client implements IClient, Remote {

    IBusinessServer businessServer;


    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            businessServer = (IBusinessServer) registry.lookup("businessServer");
            System.out.println("Client Started....");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deposit(int accountNumber, int amount) {
        try {
            businessServer.deposit(accountNumber, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void withdraw(int accountNumber, int amount) {
        try {
             businessServer.withdraw(accountNumber, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person login(String username, String password) {
        try {

            return businessServer.login(username, password);

        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void sendMoney(int accountNumberSender, int amount, int accountNumberReceiver) {
        try {
            businessServer.sendMoney( accountNumberSender ,amount, accountNumberReceiver);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int checkBalance(int accountNumber) {
        try {
            return businessServer.checkBalance(accountNumber);
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


}
