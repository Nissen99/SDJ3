package client.model;

import client.network.IClient;
import shared.Person;

public class ClientModel implements IClientModel{

    private IClient client;
    private Person loggedIn;


    public ClientModel(IClient client)
    {
        this.client = client;
    }

    @Override
    public void deposit( int amount) {
        client.deposit(loggedIn.getAccountNumber(), amount);

    }

    @Override
    public void withdraw(int amount) {
         client.withdraw(loggedIn.getAccountNumber(), amount);
    }

    @Override
    public Person login(String username, String password) {
        loggedIn = client.login(username, password);
        return loggedIn;
    }

    @Override
    public void sendMoney(int amount, int accountNumberReceiver) {
         client.sendMoney(loggedIn.getAccountNumber(), amount, accountNumberReceiver);
    }

    @Override
    public int checkBalance() {
        return client.checkBalance(loggedIn.getAccountNumber());
    }

    @Override
    public void registeruser(String username, String password) {
    client.registerUser(username, password);
    }

    @Override
    public Person getLoggedIn() {
        return loggedIn;
    }


}
