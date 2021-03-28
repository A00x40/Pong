import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Ball extends Rectangle{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Random random;

    int xSpeed , ySpeed;
    
    public Ball( int x , int y , int diameter ) {
        super( x , y , diameter , diameter);
        random = new Random();

        int randX = random.nextInt(2) , randY = random.nextInt(2);;

        if( randX == 0 ) randX = -1;
        setXDirection(randX);
        if( randY == 0 ) randY = -1;
        setYDirection(randY);
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    public void setXDirection( int randX ) { this.xSpeed = randX; }
    public void setYDirection( int randY ) { this.ySpeed = randY; }

    public void update() {
        x += xSpeed;
        y += ySpeed;
    }
}
        