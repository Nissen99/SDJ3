package client.network;

import shared.Person;

public interface IClient {

    void startClient();

    void deposit(int accountNumber, int amount) ;
    void withdraw(int accountNumber, int amount) ;
    Person login(String username, String password) ;
    void sendMoney(int accountNumberSender, int amount, int accountNumberReceiver);
    int checkBalance(int accountNumber) ;

    boolean registerUser(String username, String password);

}
