package peer;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class PeerFrame
        extends JFrame
        implements PeerView
{
    private PeerController controller;


    JTextArea area = new JTextArea( 20, 50 );
    JTextField toTxt = new JTextField( 5 );
    JTextField msgTxt = new JTextField( 50 );
    JButton sendBtn = new JButton( "Send" );
    JButton lookupBtn = new JButton( "Lookup" );


    public PeerFrame( PeerController controller )
    {
        super( "Peer" );

        this.controller = controller;

        Box b = Box.createVerticalBox();

        area.setEditable( false );
        b.add( new JScrollPane( area ) );

        JPanel p = new JPanel( new FlowLayout( FlowLayout.LEFT ) );

        p.add( toTxt );
        p.add( msgTxt );
        p.add( sendBtn );
        p.add(lookupBtn);

        sendBtn.addActionListener( new SendHandler() );
        lookupBtn.addActionListener(controller);

        b.add( p );
        add( b );

        pack();
        setLocationRelativeTo( null );
        setVisible( true );

        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }


    public void println( String text )
    {
        area.append( text + "\n" );
        area.setCaretPosition( area.getText().length() );
    }


    public String inputAlias()
    {
        return JOptionPane.showInputDialog( "Alias" );
    }

    public String inputLookup(String whatItDisplays){
        return JOptionPane.showInputDialog( whatItDisplays );

    }


    public void displayAlias( String alias )
    {
        setTitle( "Peer [alias=" + alias + "]" );
    }


    public void error( String text )
    {
        JOptionPane.showMessageDialog( null, text, "error", JOptionPane.ERROR_MESSAGE );
    }


    private class SendHandler
            implements ActionListener
    {
        public void actionPerformed( ActionEvent ae )
        {
            controller.send( toTxt.getText(), msgTxt.getText() );
        }
    }
}