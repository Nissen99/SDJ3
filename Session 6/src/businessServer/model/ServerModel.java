package businessServer.model;

import shared.Person;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ServerModel implements IServerModel {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    @Override
    public Person login(String username, String password) {
        return null;
    }

    @Override
    public boolean registerUser(String username, String password) {
        return false;
    }


    @Override
    public void deposit(Person person, int amount) {
    person.setBalance(person.getBalance() + amount);
    }

    @Override
    public void withdraw(Person person, int amount) {
        person.setBalance(person.getBalance() - amount);

    }

    @Override
    public int checkBalance(Person subject) {
        return subject.getBalance();
    }

    @Override
    public void sendMoney(Person sender, int amount, Person receiver) {
        withdraw(sender, amount);
        deposit(receiver, amount);

    }

    @Override
    public void done(){
        support.firePropertyChange("moneySend", 1, 2);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
    }
}
