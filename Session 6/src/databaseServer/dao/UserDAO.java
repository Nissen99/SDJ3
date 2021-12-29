package databaseServer.dao;

import shared.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends BaseDAO implements IUserDAO{



    @Override
    public Person login(String username, String password) {
        try (Connection connection = getConnection() ) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM person WHERE username = ? AND password = ?"
            );
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            Person user;
            if (resultSet.next()){
                user = new Person(resultSet.getInt("balance"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("accountNumber"));
                return user;
            }
            throw new IllegalArgumentException("Kontoen ikke registreret");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new IllegalArgumentException("SQL FEJL");

        }
    }

    @Override
    public boolean registerUser(String username, String password) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO person (username, password, balance) VALUES(?,?,?)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, 0);
            statement.executeUpdate();

            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();        }
        return false;
    }

}
