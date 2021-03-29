import java.awt.*;

public class Score extends Rectangle {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int score1 = 0 , score2 = 0 , x , y;

    Score( int x , int y ) {
       this.x = x;
       this.y = y;
    }

    public void draw(Graphics g) {
        g.setFont ( new Font ("Courier New", 3, 20) );
        g.setColor(Color.ORANGE);
        g.drawString( String.valueOf(score1) , x - 40 , y);
        g.setColor(Color.GREEN);
        g.drawString( String.valueOf(score2)  , x + 40 , y);
    }

    public void update( int id ) {
        if( id == 1 ) score1++;
        else score2++; 
    }
    
}
