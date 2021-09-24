package databaseServer.model;

import databaseServer.dao.*;
import shared.Person;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class DatabaseServerModel implements IDatabaseServerModel {

    IUserDAO userDAO = new UserDAO();
    IMoneyDAO moneyDAO = new MoneyDAO();
    IPersonDAO personDAO = new PersonDAO();

    @Override
    public void startServer() throws RemoteException, AlreadyBoundException {

    }

    @Override
    public ArrayList<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person getPerson(int accountNumber) {
        return null;
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
    public void withdraw(int accountNumber, int amount) {
        moneyDAO.withdraw(accountNumber, amount);
    }

    @Override
    public void deposit(int accountNumber, int amount) {
        moneyDAO.deposit(accountNumber, amount);
    }

    @Override
    public int checkBalance(int accountNumber) {
        return personDAO.checkBalance(accountNumber);
    }
}
