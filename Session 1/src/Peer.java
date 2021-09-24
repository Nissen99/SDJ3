import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Peer extends Remote
{

  void start() throws RemoteException, NotBoundException, AlreadyBoundException;
  void sendMessage(String name, String message)
      throws RemoteException, NotBoundException;
  void receiveMessage(String message) throws RemoteException;
}
