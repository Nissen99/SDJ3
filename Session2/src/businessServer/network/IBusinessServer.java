package businessServer.network;

import shared.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IBusinessServer extends Remote  {

    void startServer() throws RemoteException;
    ArrayList<Person> getAllPersons() throws RemoteException;
    Person getPerson(int accountNumber) throws RemoteException;
    Person login(String username, String password) throws RemoteException;
    boolean registerUser(String username, String password) throws RemoteException;
    void withdraw(int accountNumber, int amount) throws RemoteException;
    void deposit(int accountNumber, int amount) throws RemoteException;
    int checkBalance(int accountNumber) throws RemoteException;
    void sendMoney(int accountNumberSender, int amount, int accountNumberReceiver) throws RemoteException;

}
