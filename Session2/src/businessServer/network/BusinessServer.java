package businessServer.network;

import businessServer.model.IServerModel;
import databaseServer.network.IDatabaseServer;
import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BusinessServer implements IBusinessServer{


    private IDatabaseServer databaseServer;
    private IServerModel serverModel;

    public BusinessServer(IServerModel serverModel) {
        this.serverModel = serverModel;
    }

    @Override
    public void startServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);

        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            registry.bind("businessServer", this);
            databaseServer = (IDatabaseServer) registry.lookup("databaseServer");
            System.out.println("BusinessServer Started....");
        } catch (AlreadyBoundException | NotBoundException e) {
            e.printStackTrace();
        }


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
        Person loggedIn = null;
        try {
            loggedIn = databaseServer.login(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return loggedIn;
    }

    @Override
    public boolean registerUser(String username, String password) {
        try {
            return databaseServer.registerUser(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        return false;
        }

    }

    @Override
    public void withdraw(int accountNumber, int amount) {
        try {
            databaseServer.withdraw(accountNumber, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deposit(int accountNumber, int amount) {
        try {
            databaseServer.deposit(accountNumber, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int checkBalance(int accountNumber) {
        try {
            return databaseServer.checkBalance(accountNumber);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void sendMoney(int accountNumberSender, int amount, int accountNumberReceiver) {
        try {
            databaseServer.withdraw(accountNumberSender, amount);
            databaseServer.deposit(accountNumberReceiver, amount);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
