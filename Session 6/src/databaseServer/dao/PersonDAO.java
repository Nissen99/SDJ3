package databaseServer.dao;

import shared.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO extends BaseDAO implements IPersonDAO {


    @Override
    public Person getPerson(int accountNumber) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE accountNumber = ?");
            statement.setInt(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();
            Person user;
            if (resultSet.next()){
            user = new Person(
                    resultSet.getInt("balance"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getInt("accountNumber")
            );
            return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new IllegalArgumentException("No such user registered");
        }
        throw new IllegalArgumentException("No such user registered");

    }

    @Override
    public void updatePerson(Person person) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE person SET username = ?, balance = ?, password = ? WHERE accountNumber = ?");
            statement.setString(1, person.getUsername());
            statement.setInt(2, person.getBalance());
            statement.setString(3, person.getPassword());
            statement.setInt(4, person.getAccountNumber());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
