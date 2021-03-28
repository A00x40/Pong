import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel implements KeyListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private pongGame Game;
    private Player Player1 , Player2;
    private Ball Ball;

    Panel( pongGame Game ) {
        this.setBackground( Color.BLACK );
        this.Game = Game;
        this.Player1 = new Player( KeyEvent.VK_UP , KeyEvent.VK_DOWN);
        this.Player2 = new Player( KeyEvent.VK_W  , KeyEvent.VK_S);
        this.Ball = new Ball();
    }

    public Player getPlayer(int PlayerNo) {
        if( PlayerNo == 1) return Player1;
        else               return Player2;
    }

    @Override
    public void keyPressed(KeyEvent e) {
         
    }

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {;}
    
}
