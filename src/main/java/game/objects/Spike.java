package game.objects;

import game.framework.*;
import game.window.Game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Class for the spikes
 * extends GameObject class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Spike extends GameObject {
    
    Texture tex = Game.getInstance();

    public Spike(float x, float y, ObjectId id) {
        super(x, y, id);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tex.spike, (int)x, (int)y, null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 16);
    }
    
}
