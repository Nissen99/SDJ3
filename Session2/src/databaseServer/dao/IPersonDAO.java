package databaseServer.dao;

import shared.Person;

public interface IPersonDAO {

    Person getPerson(int accountNumber);
    void updatePerson(Person person);

}
