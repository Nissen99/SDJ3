package databaseServer.network;

import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IDatabaseServer extends Remote {

    void startServer() throws RemoteException, AlreadyBoundException;
    void updatePerson(Person person) throws RemoteException;
    Person getPerson(int accountNumber)throws RemoteException;
    Person login(String username, String password) throws RemoteException;
    boolean registerUser(String username, String password)throws RemoteException;

}
