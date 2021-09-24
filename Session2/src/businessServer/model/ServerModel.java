package businessServer.model;

import shared.Person;

import java.util.ArrayList;

public class ServerModel implements IServerModel {


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
        return null;
    }

    @Override
    public boolean registerUser(String username, String password) {
        return false;
    }


    @Override
    public int deposit(int accountNumber, int amount) {
        return 0;
    }


}
