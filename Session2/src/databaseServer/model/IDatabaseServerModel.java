package databaseServer.model;

import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IDatabaseServerModel {

    void startServer() throws RemoteException, AlreadyBoundException;
    ArrayList<Person> getAllPersons();
    Person getPerson(int accountNumber);
    Person login(String username, String password);
    boolean registerUser(String username, String password);
    void withdraw(int accountNumber, int amount);
    void deposit(int accountNumber, int amount);

    int checkBalance(int accountNumber);
}
