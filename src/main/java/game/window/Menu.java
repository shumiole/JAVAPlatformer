package game.window;

import game.framework.Texture;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 * Menu class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Menu {
    
    private Texture tex = Game.getInstance();
    
    /**
     * draw menu
     * @param g graphic object 
     */
    public void render(Graphics g){
        
        Font fnt0 = new Font("Berlin Sans FB Demi", Font.BOLD, 70);
        g.setFont(fnt0);
        g.setColor(new Color(255, 206, 15));
        g.drawString("BOODIEBOOK's", 150, 100);
        g.drawString("ADVENTURE", 200, 200);
        
        Font fnt1 = new Font("Arial Rounded MT Bold", Font.BOLD, 35);
        g.setFont(fnt1);
        g.setColor(Color.DARK_GRAY);
        g.drawImage(tex.button[0], 305, 250, null);
        g.drawString("PLAY", 352, 284);
        
        g.drawImage(tex.button[0], 305, 350, null);
        g.drawString("HELP", 352, 384);
        
        g.drawImage(tex.button[0], 305, 450, null);
        g.drawString("QUIT", 352, 484);
    }
}
