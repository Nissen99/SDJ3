package businessServer.network;

import businessServer.model.IServerModel;
import client.network.CallBackClient;
import databaseServer.network.IDatabaseServer;
import shared.Person;
import shared.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BusinessServer implements IBusinessServer, PropertyChangeListener {


    private IDatabaseServer databaseServer;
    private IServerModel serverModel;
    private ArrayList<CallBackClient> callBackClients = new ArrayList<>();

    public BusinessServer(IServerModel serverModel) {
        this.serverModel = serverModel;
        this.serverModel.addPropertyChangeListener(this::propertyChange);
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
            Person subject = databaseServer.getPerson(accountNumber);
            serverModel.withdraw(subject, amount);
            databaseServer.updatePerson(subject);

        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deposit(int accountNumber, int amount) {
        try {
            Person subject = databaseServer.getPerson(accountNumber);
            serverModel.deposit(subject, amount);
            databaseServer.updatePerson(subject);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int checkBalance(int accountNumber) {
        try {
            Person subject = databaseServer.getPerson(accountNumber);
            return serverModel.checkBalance(subject);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No Such user exsits");
    }

    @Override
    public void sendMoney(int accountNumberSender, int amount, int accountNumberReceiver) {
        try {
            Person sender = databaseServer.getPerson(accountNumberSender);
            Person receiver = databaseServer.getPerson(accountNumberReceiver);
            serverModel.sendMoney(sender, amount, receiver);
            databaseServer.updatePerson(sender);
            databaseServer.updatePerson(receiver);
            serverModel.done();


        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerCallBackClient(CallBackClient client) throws RemoteException {
        callBackClients.add(client);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ArrayList<CallBackClient> failers = new ArrayList<>();
        for (CallBackClient callBackClient : callBackClients) {
            try {
                callBackClient.update(evt);
            } catch (RemoteException e) {
                failers.add(callBackClient);
            }
        }

        for (CallBackClient callBackClient :
                failers) {
            failers.remove(callBackClient);
        }
    }
}
