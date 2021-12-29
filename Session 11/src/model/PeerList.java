package model;

import java.rmi.RemoteException;
import java.util.*;


public class PeerList
{
    private TreeMap< String, Peer > list = new TreeMap< String, Peer >();


    public boolean exists( Peer peer )
    {
        return list.containsKey( peer.getAlias() );
    }


    public void add( Peer peer )
    {
        list.put( peer.getAlias(), peer );
    }


    public Peer find( String alias )
    {
        return list.get( alias );
    }


    public Peer lookUp(String alias) {
        for (String aliasOfPeer : list.keySet()) {
            try {
                Peer lookedUp = list.get(aliasOfPeer).getServant().lookUp(alias );
                if (lookedUp != null){
                    return lookedUp;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
