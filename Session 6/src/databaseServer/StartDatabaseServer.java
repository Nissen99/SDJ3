package databaseServer;

import databaseServer.model.DatabaseServerModel;
import databaseServer.model.IDatabaseServerModel;
import databaseServer.network.DatabaseServer;
import databaseServer.network.IDatabaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StartDatabaseServer {
    public static void main(String[] args) throws SQLException, AlreadyBoundException, RemoteException {

        DriverManager.registerDriver(new org.postgresql.Driver());

        IDatabaseServerModel serverModel = new DatabaseServerModel();

        IDatabaseServer server = new DatabaseServer(serverModel);

        server.startServer();
    }

}
