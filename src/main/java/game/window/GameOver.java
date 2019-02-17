package game.window;

import game.framework.Handler;
import game.framework.Scorer;
import game.framework.Texture;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * class for Game Over state
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class GameOver {
    private Texture tex = Game.getInstance();
    private Handler handler;
    private Scorer score;
    
    /**
     * Constructor
     * @param handler (class Handler)linked list with all objects in the game
     * @param score (class Scorer) includes lives and coins
     */
    GameOver(Handler handler, Scorer score){
        this.handler = handler;
        this.score = score;
    }
    
    /**
     * draw game over state
     * @param g graphic object
     */
    public void render(Graphics g){
        Font fnt0 = new Font("Berlin Sans FB Demi", Font.BOLD, 70);
        g.setFont(fnt0);
        g.setColor(new Color(255, 206, 15));
        g.drawString("GAME OVER", 190, 300);
        
        Font fnt1 = new Font("Arial Rounded MT Bold", Font.BOLD, 35);
        g.setFont(fnt1);
        
        if (handler.GetLevelIter() == handler.GetNumberOfLevels())
            g.drawString("You have reached the last level!", 100, 400);
        
        g.drawString("You have collected " + score.getCoins() + " coins!", 130, 450);
        
        g.setColor(Color.DARK_GRAY);
        g.drawImage(tex.button[0], 305, 550, null);
        g.drawString("MENU", 350, 584);
    }
}
