import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class PeerImpl implements Peer, Serializable
{

  private String name;
  private Registry registry;

  @Override public void start()
      throws RemoteException, NotBoundException, AlreadyBoundException
  {
    UnicastRemoteObject.exportObject(this, 0);

    Scanner scanner = new Scanner(System.in);

    System.out.println("What name do you go by?");
    name = scanner.nextLine();


      registry = LocateRegistry.getRegistry(1099);

   try
   {
     registry.bind(name, this);

   } catch (Exception e){
     registry = LocateRegistry.createRegistry(1099);
     registry.bind(name, this);

   }


    System.out.println("PEER UP! " + name);


    while (true){
      System.out.println("Who do you wanna write");
      String nameWannaLookup = scanner.nextLine();
      System.out.println("What do you wanna send them?");
      String msg = scanner.nextLine();
      sendMessage(nameWannaLookup, msg);

    }
  }

  @Override public void sendMessage(String nameWannaWrite, String message)
      throws RemoteException, NotBoundException
  {

    Peer peer = (Peer) registry.lookup(nameWannaWrite);
    peer.receiveMessage("    " + name + ": " + message);
  }

  @Override public void receiveMessage(String message)
  {
    System.out.println(message);

  }

  public String getName()
  {
    return name;
  }
}
