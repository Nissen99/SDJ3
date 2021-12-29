package businessServer;

import businessServer.model.IServerModel;
import businessServer.model.ServerModel;
import businessServer.network.BusinessServer;
import businessServer.network.IBusinessServer;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class StartBuisnessServer {
    public static void main(String[] args) throws AlreadyBoundException, NotBoundException, RemoteException {

        IServerModel serverModel = new ServerModel();

        IBusinessServer businessServer = new BusinessServer(serverModel);

        businessServer.startServer();
    }
}
