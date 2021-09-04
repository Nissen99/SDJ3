package Peer;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class PeerMain
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException, AlreadyBoundException
  {
    Peer peer = new PeerImpl();
    peer.start();

  }
}
