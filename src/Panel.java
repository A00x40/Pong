import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements Runnable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static final int GAME_WIDTH = 900 , GAME_HEIGHT = (int)( GAME_WIDTH * 5 / 9 );
    static final Dimension screen_size = new Dimension( GAME_WIDTH , GAME_HEIGHT);

    //private static final int BallSize = 20;
    //private Ball ball ;

    static final int PLAYER_WIDTH  = 10 , PLAYER_HEIGHT = 70;
    Player P1 ;
    Player P2 ;

    Thread gameThread;

    Image image;
    Graphics graphics;

    Panel() {
        P1 = new Player(0 , (GAME_HEIGHT/2) - (PLAYER_HEIGHT) , PLAYER_WIDTH , PLAYER_HEIGHT , 1 , Color.RED);
        P2 = new Player(GAME_WIDTH-PLAYER_WIDTH , (GAME_HEIGHT/2) - (PLAYER_HEIGHT) , PLAYER_WIDTH , PLAYER_HEIGHT , 2 , Color.BLUE);
        //ball = new Ball( 20 , 20 );
        setFocusable(true);
        addKeyListener( new AL() );
        setPreferredSize( screen_size );

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paint( Graphics g ) {
        image = createImage( getWidth() , getHeight() );
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage( image , 0 , 0 , this); 
    }

    public void draw( Graphics g ) {
        P1.draw(g);
        P2.draw(g);
    }


    public void update() {
        
    }

    public void checkCollision() {
        
    }

    @Override
    public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				update();
				checkCollision();
				repaint();
				delta--;
            }
        }
    }
    public class AL extends KeyAdapter {
        public void KeyPressed() {
            
        }
        public void KeyReleased() {
            
        }
    }
}
