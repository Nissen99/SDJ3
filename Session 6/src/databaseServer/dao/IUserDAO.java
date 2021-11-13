package databaseServer.dao;

import shared.Person;

public interface IUserDAO {

    Person login(String username, String password);
    boolean registerUser(String username, String password);
}
