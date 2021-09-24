package databaseServer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoneyDAO extends BaseDAO implements IMoneyDAO{

    @Override
    public void withdraw(int accountNumber, int amount) {
    try(Connection connection = getConnection()){
        PreparedStatement statement = connection.prepareStatement("UPDATE person SET balance = balance - ? WHERE accountNumber = ?" );
        statement.setInt(1, amount);
        statement.setInt(2, accountNumber);
        statement.executeUpdate();

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    }

    @Override
    public void deposit(int accountNumber, int amount) {

        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE person SET balance = balance + ? WHERE accountNumber = ?" );
            statement.setInt(1, amount);
            statement.setInt(2, accountNumber);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
