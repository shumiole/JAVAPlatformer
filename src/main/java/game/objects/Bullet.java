package game.objects;

import game.framework.GameObject;
import game.framework.ObjectId;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Class for the bullets
 * extends GameObject class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Bullet extends GameObject{

    public Bullet(float x, float y, int velX, ObjectId id) {
        super(x, y, id);
        this.velX = velX;
    }

    @Override
    public void tick(LinkedList<GameObject> object){
        x += velX;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval((int)x, (int)y, 5, 5);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 5, 5);
    }

}
