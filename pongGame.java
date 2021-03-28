import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class pongGame extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static JFrame frame;
    static JPanel panel;

    public static void main( String[] args ) {

        frame = new JFrame( "Pong" );
        panel = new JPanel();
        panel.setBackground(Color.CYAN);

        frame.add( panel );
        frame.setSize( 500 , 500 );
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
