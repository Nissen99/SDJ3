package databaseServer.model;

import databaseServer.dao.IPersonDAO;
import databaseServer.dao.IUserDAO;
import databaseServer.dao.PersonDAO;
import databaseServer.dao.UserDAO;
import shared.Person;

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
