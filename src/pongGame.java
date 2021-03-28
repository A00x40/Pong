import javax.swing.*;
import java.awt.*;

public class pongGame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Panel P;

    public pongGame() {
        P = new Panel();
        add(P);

        setTitle( "Pong" );

        setResizable(false);
        setBackground(Color.BLACK);

        pack();
        setLocationRelativeTo(null);

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
    }

    public static void main( String[] args ) {
        new pongGame(); 
    }  
}
