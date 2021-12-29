package businessServer.model;

import shared.Person;
import shared.PropertyChangeSubject;

public interface IServerModel extends PropertyChangeSubject {

    Person login(String username, String password);
    boolean registerUser(String username, String password);
    void deposit(Person person, int amount);
    void withdraw(Person person, int amount);

    int checkBalance(Person subject);
    void done();

    void sendMoney(Person sender, int amount, Person receiver);
}
