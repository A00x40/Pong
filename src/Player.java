import java.awt.*;
import java.awt.event.*;
public class Player extends Rectangle {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int id , ySpeed , Speed = 10;
    Color color;

    Player( int x , int y , int PLAYER_WIDTH , int PLAYER_HEIGHT , int id , Color C) {
        super( x , y , PLAYER_WIDTH , PLAYER_HEIGHT);
        this.id = id;
        this.color = C;
    }

    public void draw( Graphics g ) {
        g.setColor( this.color );
        g.fillRect(x, y, width ,height);
    }

    public void setYDirection( int ydir ) { this.ySpeed = ydir; }

    public void update() { y += ySpeed; }

    public void KeyPressed( KeyEvent e ) {
        switch(id) {
            case 1:
                if( e.getKeyCode() == KeyEvent.VK_W) setYDirection( -Speed );
                else if( e.getKeyCode() == KeyEvent.VK_S) setYDirection( Speed );
                update();
                break;
            case 2:
                if( e.getKeyCode() == KeyEvent.VK_UP) setYDirection( -Speed );
                else if( e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection( Speed );
                update();
                break;
        }
    }

    public void KeyReleased( KeyEvent e ) {
        switch(id) {
            case 1:
                if( e.getKeyCode() == KeyEvent.VK_W) setYDirection( 0 );
                else if( e.getKeyCode() == KeyEvent.VK_S) setYDirection( 0 );
                update();
                break;
            case 2:
                if( e.getKeyCode() == KeyEvent.VK_UP) setYDirection( 0 );
                else if( e.getKeyCode() == KeyEvent.VK_DOWN) setYDirection( 0 );
                update();
                break;
        }
    }
}
