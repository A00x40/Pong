import javax.swing.*;
import java.awt.*;

public class pongGame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Panel P;

    public pongGame() {
        P = new Panel(this);
        add(P);

        setTitle( "Pong" );

        setResizable(false);
        setBackground(Color.BLACK);

        pack();
        setLocationRelativeTo(null);

        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setVisible(true);
    }

    public void Finish( int id ) {
        dispose();
        int choice = JOptionPane.showConfirmDialog(null, "Player " + id + " Won" , null , JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (choice == JOptionPane.OK_OPTION || choice == JOptionPane.CANCEL_OPTION){
            System.exit(0);
        }
    }

    public static void main( String[] args ) {
        new pongGame(); 
    }  
}
