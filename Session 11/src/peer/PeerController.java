package peer;


import model.Message;
import model.Peer;
import model.PeerList;
import shared.PeerInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class PeerController
        extends UnicastRemoteObject
        implements PeerInterface, ActionListener
{
    private PeerView view;


    private Peer me;
    private PeerList cache = new PeerList();


    public PeerController()
            throws RemoteException
    {
    }


    public void setView( PeerView view )
    {
        this.view = view;
    }


    public Peer getMe() {
        return me;
    }

    @Override
    public Peer lookUp(String alias) {
        return findReceiver(alias);
    }

    public void begin()
    {
        try {
            String alias = view.inputAlias();
            while( alias == null || "".equals( alias ) )
                alias = view.inputAlias();


            view.displayAlias( alias );

            me = new Peer( alias, this );

            String lookup = view.inputLookup("Who to lookup");
            int port = Integer.parseInt(view.inputLookup("What port?"));

            try {

                Registry registry = LocateRegistry.getRegistry(port);
                PeerInterface peer = (PeerInterface) registry.lookup(lookup);
                cache.add(peer.getMe());
            } catch (Exception e){
                Registry registry = LocateRegistry.createRegistry(port);
                registry.bind(lookup, this);
            }


        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }


    public void send( String toAlias, String text )
    {
        try {
            Peer receiver = findReceiver( toAlias );

            if( receiver == null ) {
                view.error( "Could not find " + toAlias );

                return;
            }

            Message msg = new Message( text, me, receiver );

            receiver.getServant().deliverMessage( msg );
        } catch( Exception ex ) {
            ex.printStackTrace();

            view.error( "Trouble sending to " + toAlias );
        }
    }


    private Peer findReceiver( String alias )
    {
        Peer peer = cache.find( alias );

        if( peer == null ) {
            peer = cache.lookUp(alias);

            if( peer != null )
                cache.add( peer );
        }

        return peer;
    }


    public void deliverMessage( Message message )
            throws RemoteException
    {
        view.println( message.getFrom().getAlias() + ": " + message.getText() );

        if( cache.find( message.getFrom().getAlias() ) == null )
            cache.add( message.getFrom() );
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String lookup = view.inputLookup("Who to lookup");

        int port = Integer.parseInt(view.inputLookup("What port?"));

        try {
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind(lookup, this);
        } catch (Exception es) {
            es.printStackTrace();
        }

    }
}
