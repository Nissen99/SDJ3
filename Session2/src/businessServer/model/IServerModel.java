package businessServer.model;

import shared.Person;
import shared.PropertyChangeSubject;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IServerModel extends PropertyChangeSubject {

    Person login(String username, String password);
    boolean registerUser(String username, String password);
    void deposit(Person person, int amount);
    void withdraw(Person person, int amount);

    int checkBalance(Person subject);
    void done();

    void sendMoney(Person sender, int amount, Person receiver);
}
