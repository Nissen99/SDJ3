package databaseServer.dao;

public interface IMoneyDAO {

    void withdraw(int accountNumber, int amount);

    void deposit(int accountNumber, int amount);
}
