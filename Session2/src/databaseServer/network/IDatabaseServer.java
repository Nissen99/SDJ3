package databaseServer.network;

import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IDatabaseServer extends Remote {

    void startServer() throws RemoteException, AlreadyBoundException;
    ArrayList<Person> getAllPersons() throws RemoteException;
    Person getPerson(int accountNumber)throws RemoteException;
    Person login(String username, String password) throws RemoteException;
    boolean registerUser(String username, String password)throws RemoteException;
    void withdraw(int accountNumber, int amount)throws RemoteException;
    void deposit(int accountNumber, int amount)throws RemoteException;

    int checkBalance(int accountNumber) throws RemoteException;
}
