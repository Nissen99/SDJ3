package client.model;

import shared.Person;

public interface IClientModel {

        void deposit(int amount);
        void withdraw(int amount);
        Person login(String username, String password);
        void sendMoney(int amount, int accountNumberReceiver);
        int checkBalance();

    void registeruser(String username, String password);
    Person getLoggedIn();

}


