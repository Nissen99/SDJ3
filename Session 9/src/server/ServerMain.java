package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class ServerMain {
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        IRMIServer rmiServer = new RMIServer();

        rmiServer.startServer();

    }
}
