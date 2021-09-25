package client.model;

import shared.Person;
import shared.PropertyChangeSubject;

public interface IClientModel extends PropertyChangeSubject {

        void deposit(int amount);
        void withdraw(int amount);
        Person login(String username, String password);
        void sendMoney(int amount, int accountNumberReceiver);
        int checkBalance();

    void registeruser(String username, String password);

        Person getLoggedIn();
}


