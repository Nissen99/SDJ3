package client.model;

import client.network.IClient;
import shared.Person;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ClientModel implements IClientModel, PropertyChangeListener{

    private IClient client;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);


    public ClientModel(IClient client)
    {
        this.client = client;
        client.addPropertyChangeListener(this::propertyChange);
    }

    @Override
    public void deposit( int amount) {
        client.deposit(amount);

    }

    @Override
    public void withdraw(int amount) {
         client.withdraw(amount);
    }

    @Override
    public Person login(String username, String password) {
        return client.login(username, password);
    }

    @Override
    public void sendMoney(int amount, int accountNumberReceiver) {
         client.sendMoney(amount, accountNumberReceiver);
    }

    @Override
    public int checkBalance() {
        return client.checkBalance();
    }

    @Override
    public void registeruser(String username, String password) {
    client.registerUser(username, password);
    }

    @Override
    public Person getLoggedIn() {
        return client.getLoggedIn();
    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
        System.out.println("PropertyChange ClientModel");

    }
}
