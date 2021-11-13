package databaseServer.model;

import shared.Person;

public interface IDatabaseServerModel {

    Person getPerson(int accountNumber);
    Person login(String username, String password);
    boolean registerUser(String username, String password);

    void updatePerson(Person person);
}
