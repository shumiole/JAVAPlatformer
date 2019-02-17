package game.objects;

import game.framework.*;
import game.window.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Class for the spiders
 * extends GameObject class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Spider extends GameObject {

    private static int width = 76, height = 53;
    private int bulletCount = 0;
    private float gravity = 0.4f;
    private float MAX_SPEED = 10;
    private float initialX;
    private Handler handler;
    private Texture tex = Game.getInstance();
    private Animation spiderRWalk;
    private Animation spiderLWalk;
    
    public Spider(float x, float y, int type, Handler handler, ObjectId id) {
        super(x, y, id);
        initialX = x;
        this.handler = handler;
        
        if (type == 1) velX = 2;
        else velX = 0;
        
        spiderRWalk = new Animation(3, tex.spider[1], tex.spider[2]);
        spiderLWalk = new Animation(3, tex.spider[3], tex.spider[4]);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;
        
        if(falling || jumping){
            velY += gravity;
        }
        
        if(velY >= MAX_SPEED){
            velY = MAX_SPEED;
        }
        
        Collision();
        
        if(bulletCount > 4) setAlive(false);
        if (x == initialX + 300 || x == initialX) setVelX(-getVelX());
        if(!isAlive()) velX = 0;
        
        spiderRWalk.runAnimation();
        spiderLWalk.runAnimation();
    }

    @Override
    public void render(Graphics g) {
        if(isAlive()){
            if (velX > 0) spiderRWalk.drawAnimation(g, (int)x, (int)y);
            else if(velX < 0) spiderLWalk.drawAnimation(g, (int)x, (int)y);
            else g.drawImage(tex.spider[0], (int)x, (int)y, null);
        }
        else g.drawImage(tex.spider[5], (int)x, (int)y, null);
    }
    
    private void Collision(){
        for(int i = 0; i < handler.object.size(); i++){
            
            if(handler.object.get(i).getId() == ObjectId.Block){
                if(getBounds().intersects(handler.object.get(i).getBounds())){ // object = blok
                    y = handler.object.get(i).getY() - height; 
                    velY = 0;
                    falling = false;
                    jumping = false;
                }else
                    falling = true;
            }
            if(handler.object.get(i).getId() == ObjectId.Bullet)
                if(getBounds().intersects(handler.object.get(i).getBounds())){
                    bulletCount++;
                    handler.object.remove(i);
                }
                    
            
        }   
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }
    
}


