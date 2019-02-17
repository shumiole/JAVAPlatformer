package game.objects;

import game.framework.*;
import game.window.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Class for the coins
 * extends GameObject class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Coin extends GameObject {

    private Texture tex = Game.getInstance();
    private Animation coinAnimation;
    
    public Coin(float x, float y, ObjectId id) {
        super(x, y, id);
        coinAnimation = new Animation(3, tex.coin[0],tex.coin[1],tex.coin[2],tex.coin[3],
                tex.coin[4],tex.coin[5],tex.coin[6],tex.coin[7],tex.coin[8],
                tex.coin[9]);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        coinAnimation.runAnimation();
    }

    @Override
    public void render(Graphics g) {
        coinAnimation.drawAnimation(g, (int)x, (int)y, 20, 20);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 20, 20);
    }
    
}
