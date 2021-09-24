package databaseServer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO extends BaseDAO implements IPersonDAO {


    @Override
    public int checkBalance(int accountNumber) {
        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT balance FROM person WHERE accountNumber = ?");
            statement.setInt(1, accountNumber);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                return resultSet.getInt("balance");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
}
