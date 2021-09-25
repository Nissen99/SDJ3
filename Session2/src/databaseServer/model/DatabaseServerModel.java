package databaseServer.model;

import databaseServer.dao.*;
import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class DatabaseServerModel implements IDatabaseServerModel {

    IUserDAO userDAO = new UserDAO();
    IPersonDAO personDAO = new PersonDAO();



    @Override
    public Person getPerson(int accountNumber) {
        return personDAO.getPerson(accountNumber);
    }

    @Override
    public Person login(String username, String password) {
        return userDAO.login(username, password);
    }

    @Override
    public boolean registerUser(String username, String password) {
        return userDAO.registerUser(username, password);
    }

    @Override
    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }


}
