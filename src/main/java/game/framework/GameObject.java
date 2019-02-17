package game.framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Abstract class for objects in the game
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public abstract class GameObject {
   
    protected float x, y;
    protected ObjectId id;
    protected float velX = 0, velY = 0;
    protected boolean falling = true;
    protected boolean jumping = false;
    protected boolean alive = true;
    protected int type;
    protected int facing = 1;

    /**
     * Constructor
     * Create object
     * @param x coordinate
     * @param y coordinate
     * @param id unique id for specific type of object
     */
    public GameObject(float x, float y, ObjectId id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    
    /**
     * Here all the characteristics of the object
     * are somehow changing
     * (for example, speed, position 
     * or current image for animation)
     * 
     * @param object 
     */
    public abstract void tick(LinkedList<GameObject> object);
    
    /**
     * draw object
     * @param g graphic object
     */
    public abstract void render(Graphics g);
    
    /**
     * @return bounds of the object
     */
    public abstract Rectangle getBounds();
    
    /**
     * @return x coordinate 
     */
    public float getX(){
        return x;
    }
    
    /**
     * @return y coordinate
     */
    public float getY(){
        return y;
    }
    
    /**
     * set x coordinate
     * @param x 
     */
    public void setX(float x){
        this.x = x;
    }
    
    /**
     * set y coordinate
     * @param y 
     */
    public void setY(float y){
        this.y = y;
    }
    
    /**
     * @return velocity relative to the x-axis
     */
    public float getVelX(){
        return velX;
    }
    
     /**
     * @return velocity relative to the y-axis
     */
    public float getVelY(){
        return velY;
    }
    
    /**
     * set velocity relative to the x-axis
     * @param velX 
     */
    public void setVelX(float velX){
        this.velX = velX;
    }
    
     /**
     * set velocity relative to the y-axis
     * @param velY 
     */
    public void setVelY(float velY){
        this.velY = velY;
    }
    
    /**
     * @return unique id for specific type of object
     */
    public ObjectId getId(){
        return id;
    }
    
    /**
     * @return type of the object
     * (using only if object is a block)
     */
    public int getType(){
        return type;
    }
    
    /**
     * @return direction of the object
     * (using only if object is a player)
     * 1 if player looks to the right
     * -1 if player looks to the left
     */
    public int getFacing(){
        return facing;
    }

    /**
     * @return object is falling
     */
    public boolean isFalling() {
        return falling;
    }

    /**
     * @return object is jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * set object's falling
     * @param falling 
     */
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    /**
     * set object's jumping
     * @param jumping 
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    /**
     * @return object is alive 
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * set object's alive 
     * @param alive 
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
