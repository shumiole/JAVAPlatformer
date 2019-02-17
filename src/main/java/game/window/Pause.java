package game.window;

import game.framework.Texture;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Class for pause state
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Pause {
    Texture tex = Game.getInstance(); 

    /**
     * draw pause
     * @param g graphic object
     */
    public void render(Graphics g){
        Font fnt0 = new Font("Berlin Sans FB Demi", Font.BOLD, 70);
        g.setFont(fnt0);
        g.setColor(new Color(255, 206, 15));
        g.drawString("PAUSE", 300, 300);
        
        Font fnt1 = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.DARK_GRAY);
        g.drawImage(tex.button[0], 305, 500, null);
        g.drawString("CONTINUE", 308, 534);
    }
}
