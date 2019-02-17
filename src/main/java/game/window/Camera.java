package game.window;

import game.framework.GameObject;

/**
 * Camera class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Camera {

    private float x, y;
    
    /**
     * Constructor
     * set the coordinates of the camera
     * @param x coordinate
     * @param y coordinate
     */
    public Camera(float x, float y){
        this.x = x;
        this.y = y;
    }

    /**
     * change coordinates of the camera
     * @param player object of the Player class
     */
    public void tick(GameObject player) {
        x = Game.WIDTH/2 - player.getX();
    }
    
    /**
     * set x coordinate for the camera
     * @param x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * set y coordinate for the camera
     * @param y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }
    
    /**
     * @return x coordinate of the camera
     */
    public float getX() {
        return x;
    }

     /**
     * @return y coordinate of the camera
     */
    public float getY() {
        return y;
    }
    
}
