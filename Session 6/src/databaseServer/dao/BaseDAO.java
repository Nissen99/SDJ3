package databaseServer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
    private static Connection connection;

    protected Connection getConnection() throws SQLException{
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=smallbank"
        ,"postgres", "123456789");
        return connection;
    }
}
