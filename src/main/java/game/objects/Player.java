package game.objects;

import game.framework.*;
import game.window.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Class for the player
 * extends GameObject class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Player extends GameObject{

    private float width = 32, height = 64;
    private float gravity = 0.4f;
    private float MAX_SPEED = 10;
    private boolean shooting = false;
    private Handler handler;
    private Camera cam;
    private Texture tex = Game.getInstance();
    private Animation playerRWalk;
    private Animation playerLWalk;
    private Scorer score;
    
    public Player(float x, float y, Handler handler, Camera cam, Scorer score, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
        this.cam = cam;
        this.score = score;
        facing = 1;
        playerRWalk = new Animation(7, tex.player[2], tex.player[3]);
        playerLWalk = new Animation(7, tex.player[4], tex.player[5]);
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;
        
        if(velX > 0) facing = 1;
        else if(velX < 0) facing = -1; 
        
        if(falling || jumping){
            velY += gravity;
        }
        
        if(velY >= MAX_SPEED){
            velY = MAX_SPEED;
        }
        
        getCollision();
        
        playerRWalk.runAnimation();
        playerLWalk.runAnimation();
    }

    private void getCollision(){
        
        for(int i = 0; i < handler.object.size(); i++){
            
            if(handler.object.get(i).getId() == ObjectId.Coin){
                if(getBoundsTop().intersects(handler.object.get(i).getBounds()) ||
                        getBounds().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsLeft().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsRight().intersects(handler.object.get(i).getBounds()) ){
                    handler.object.remove(i);
                    score.setCoins(score.getCoins() + 1);
                }
               
            }
            
            if(handler.object.get(i).getId() == ObjectId.Spike){
                if(getBoundsTop().intersects(handler.object.get(i).getBounds()) ||
                        getBounds().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsLeft().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsRight().intersects(handler.object.get(i).getBounds()) ){
                    score.setLives(score.getLives() - 1);
                    setX(50);
                    setY(500);
                }
            }
            
            if(handler.object.get(i).getId() == ObjectId.Spider){
                if(getBounds().intersects(handler.object.get(i).getBounds())){
                    if(handler.object.get(i).isAlive()){
                        score.setLives(score.getLives() - 1);
                        setX(50);
                        setY(500);
                    }
                }
            }
            
            if(handler.object.get(i).getId() == ObjectId.Bullet){
                if(getBoundsTop().intersects(handler.object.get(i).getBounds()) ||
                        getBounds().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsLeft().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsRight().intersects(handler.object.get(i).getBounds()) )
                    shooting = true;
                    else shooting = false;
            }
            
            if(handler.object.get(i).getId() == ObjectId.Block){
                 
                if(getBoundsTop().intersects(handler.object.get(i).getBounds())){
                    if(handler.object.get(i).getType() == 1) 
                        y = handler.object.get(i).getY() + 6;                  // object = top
                    else 
                        y = handler.object.get(i).getY() + height/4;
                    velY = 0;
                 }
  
                if(getBounds().intersects(handler.object.get(i).getBounds())){ // object = blok
                    y = handler.object.get(i).getY() - height;
                    velY = 0;
                    falling = false;
                    jumping = false;
                }else
                    falling = true;
                
                if(getBoundsLeft().intersects(handler.object.get(i).getBounds())){
                    if(handler.object.get(i).getType() == 9)                        // object = wall
                        x = handler.object.get(i).getX() + width/3;    
                    else 
                        x = handler.object.get(i).getX() + width;
                    velX = 0;
                }
                    
                if(getBoundsRight().intersects(handler.object.get(i).getBounds())){
                    x = handler.object.get(i).getX() - width;
                    velX = 0;   
                }
            }
            else if(handler.object.get(i).getId() == ObjectId.Sign){
                if(getBoundsTop().intersects(handler.object.get(i).getBounds()) ||
                        getBounds().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsLeft().intersects(handler.object.get(i).getBounds()) ||
                        getBoundsRight().intersects(handler.object.get(i).getBounds())){
                    handler.switchLevel();
                    score.setLives(score.getLives() + 1);
                }
            }
        }
    }
    
    @Override
    public void render(Graphics g) {
        if(velX > 0)
            playerRWalk.drawAnimation(g, (int)x, (int)y);
        else if(velX < 0){
            playerLWalk.drawAnimation(g, (int)x, (int)y);
        }
        else if(facing == 1) g.drawImage(tex.player[0], (int) x, (int)y, null);
        else if(facing == -1) g.drawImage(tex.player[1], (int) x, (int)y, null);
    }
        
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) ((int)x + (width/2) - (width/4)), 
                (int) ((int)y + height/2), (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int)x + (width/2) - (width/4)), 
                (int)y, (int)width/2, (int)height/2);
    }
    
    public Rectangle getBoundsLeft() {
        return new Rectangle((int)x, (int)y + 5, 5, (int)height - 10);
    }
    
    public Rectangle getBoundsRight() {
        return new Rectangle((int)(x +(width) - 5), 
                (int)y + 5, 5, (int)height - 10);
    }
    
}
