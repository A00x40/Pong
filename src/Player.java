import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Player extends Rectangle {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int id , ySpeed ;
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

    public void update() {
        
    }
}
