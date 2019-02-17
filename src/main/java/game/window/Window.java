package game.window;

import java.awt.Dimension;
import javax.swing.JFrame;


/**
 * Window class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Window {
    
/**
 * Constructor
 * Create window
 * @param width of the window
 * @param height of the window
 * @param title 
 * @param game object of the Game class
 */    
    public Window(int width, int height, String title, Game game){

        game.setPreferredSize(new Dimension(width, height));
        game.setMaximumSize(new Dimension(width, height));
        game.setMinimumSize(new Dimension(width, height));
        
        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();        
    }
    
}
