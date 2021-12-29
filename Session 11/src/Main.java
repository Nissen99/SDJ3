import peer.PeerController;
import peer.PeerFrame;
import peer.PeerView;

public class Main {
    public static void main( String[] args )
    {
        try {
            PeerController controller = new PeerController();
            PeerView view = new PeerFrame( controller );

            controller.setView( view );
            controller.begin();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
    }
}
