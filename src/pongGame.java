import javax.swing.*;
import java.awt.*;

public class pongGame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private static final int gameWidth = 500 , gameHeight = (int)(gameWidth * 5 / 9) ;
    Dimension screen_size = new Dimension ( gameWidth , gameHeight );

    private Panel P;

    public pongGame() {
        this.setTitle( "Pong" );

        this.setSize(screen_size);
        this.setResizable(false);

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible(true);

        this.P = new Panel( this );
        this.add( P );
    }

    public Panel getPanel() { return this.P; }

    public void run() {
        while( true ) {

        }
    }

    public static void main( String[] args ) {
        pongGame Game =  new pongGame(); 
        Game.run();
    }  
}
