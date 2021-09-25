package client.network;

import shared.Person;
import shared.PropertyChangeSubject;

public interface IClient extends PropertyChangeSubject {

    void startClient();

    void deposit( int amount) ;
    void withdraw(int amount) ;
    Person login(String username, String password) ;
    void sendMoney(int amount, int accountNumberReceiver);
    int checkBalance() ;

    boolean registerUser(String username, String password);

    Person getLoggedIn();
}
