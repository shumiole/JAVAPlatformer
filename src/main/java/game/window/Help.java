package game.window;

import game.framework.Texture;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Help state class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Help {
    Texture tex = Game.getInstance();
    
    /**
     * Draw help state
     */
    public void render(Graphics g){
    
        Font fnt0 = new Font("Berlin Sans FB Demi", Font.BOLD, 70);
        g.setFont(fnt0);
        g.setColor(new Color(255, 206, 15));
        g.drawString("HELP", 320, 100);
        
        Font fnt1 = new Font("Arial Rounded MT Bold", Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(new Color(255, 206, 15));
        g.drawString("You can move using", 100, 180);
        g.drawImage(tex.button[2], 450, 115, null);
        
        g.drawString("and shoot using", 100, 260);
        g.drawImage(tex.button[1], 380, 213, null);
        
        g.drawString("Collect", 100, 340);
        g.drawImage(tex.coin[1], 240, 295, null);
        
        g.drawString("Avoid", 100, 410);
        g.drawImage(tex.spider[0], 210, 365, null);
        g.drawString("and", 300, 410);
        g.drawImage(tex.spike, 380, 380, null);
        
        g.drawString("You can pause the game using P key.", 100, 475);
        
        Font fnt2 = new Font("Arial Rounded MT Bold", Font.BOLD, 25);
        g.setFont(fnt2);
        g.drawString("The game will end if you die or if you reach the last level.", 45, 520);
        
        g.setFont(fnt1);
        g.setColor(Color.DARK_GRAY);
        g.drawImage(tex.button[0], 305, 550, null);
        g.drawString("MENU", 352, 584);

    }
}
