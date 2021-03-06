import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements Runnable , KeyListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    static final int GAME_WIDTH = 900 , GAME_HEIGHT = (int)( GAME_WIDTH * 5 / 9 );
    static final Dimension screen_size = new Dimension( GAME_WIDTH , GAME_HEIGHT);
    final int maxScore = 10;

    static final int BallSize = 20;
    Ball ball ;

    static final int PLAYER_WIDTH  = 20 , PLAYER_HEIGHT = 100;
    Player P1 ;
    Player P2 ;

    Score score;

    Thread gameThread;

    Image image;
    Graphics graphics;

    pongGame Game ;
    Panel(pongGame Game) {
        this.Game = Game;
        P1 = new Player(0 , (GAME_HEIGHT/2) - (PLAYER_HEIGHT) , PLAYER_WIDTH , PLAYER_HEIGHT , 1 , Color.RED);
        P2 = new Player(GAME_WIDTH-PLAYER_WIDTH , (GAME_HEIGHT/2) - (PLAYER_HEIGHT) , PLAYER_WIDTH , PLAYER_HEIGHT , 2 , Color.BLUE);
        ball = new Ball( (GAME_WIDTH/2) - (BallSize/2) , (GAME_HEIGHT/2) - (BallSize/2) , BallSize );
        score = new Score( GAME_WIDTH/2 , 20 );
        setFocusable(true);
        addKeyListener(this);
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
        ball.draw(g);
        score.draw(g);
    }

    public void update() {
        P1.update();
        P2.update();
        ball.update();
    }

    public void checkCollision() {
        if ( P1.y <= 0 ) P1.y = 0;
        else if( P1.y >= GAME_HEIGHT - P1.height) P1.y = GAME_HEIGHT - P1.height;

        if ( P2.y <= 0 ) P2.y = 0;
        else if( P2.y >= GAME_HEIGHT - P2.height) P2.y = GAME_HEIGHT - P2.height;

        if( ball.y <= 0 || ball.y >= GAME_HEIGHT - ball.height) {
            ball.setYDirection( -ball.ySpeed );
            
        }
        if( ball.x <= 0 || ball.x >= GAME_WIDTH - ball.width) {
            ball.setXDirection( -ball.xSpeed );

            if( ball.x <= 0 ) score.update( P2.id );
            else score.update( P1.id );
        }

        if( ball.intersects(P1) ) {
            ball.xSpeed = Math.abs( ball.xSpeed );
            ball.xSpeed++;
            if( ball.ySpeed > 0) ball.ySpeed++; else ball.ySpeed--;
            ball.setXDirection(ball.xSpeed); ball.setYDirection(ball.ySpeed);
        }

        if( ball.intersects(P2) ) {
            ball.xSpeed = Math.abs( ball.xSpeed );
            ball.xSpeed++;
            if( ball.ySpeed > 0) ball.ySpeed++; else ball.ySpeed--;
            ball.setXDirection(-ball.xSpeed); ball.setYDirection(ball.ySpeed);
        }
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

                if( score.score1 == maxScore ) this.Game.Finish(1);
                else if( score.score2 == maxScore ) this.Game.Finish(2);

				repaint();
				delta--;
            }
        }
    }


    @Override
    public void keyPressed( KeyEvent e ) {
        P1.KeyPressed(e);
        P2.KeyPressed(e);
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        P1.KeyReleased(e);
        P2.KeyReleased(e);
    }

    @Override
    public void keyTyped(KeyEvent e) { ; }
}
