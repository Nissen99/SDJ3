package businessServer.model;

import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServerModel {

    ArrayList<Person> getAllPersons();
    Person getPerson(int accountNumber);
    Person login(String username, String password);
    boolean registerUser(String username, String password);
    int deposit(int accountNumber, int amount);

}
