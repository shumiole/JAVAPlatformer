package game.framework;

import game.objects.Bullet;
import game.window.Game;
import game.window.Game.STATE;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Sets keyboard control
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class KeyInput extends KeyAdapter {
    
    private Handler handler;
    
    /**
     * Constructor
     * @param handler object of the Handler class
     * linked list with all objects in the game
     */
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    
    /**
     * Goes throw all objects in the handler,
     * and change some characteristic of the current object,
     * if some key is pressed
     * Exactly it is a control over the player in the game
     * @param e key event object 
     */
    @Override
    public void keyPressed(KeyEvent e){
    int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
           
            if (handler.object.get(i).getId() == ObjectId.Player){
                if(key == KeyEvent.VK_RIGHT) handler.object.get(i).setVelX(5);                
                if(key == KeyEvent.VK_LEFT) handler.object.get(i).setVelX(-5);
                if(key == KeyEvent.VK_UP && !handler.object.get(i).isJumping()){
                    handler.object.get(i).setJumping(true);
                    handler.object.get(i).setVelY(-10);
                }
                
                if(key == KeyEvent.VK_SPACE){
                    handler.addObject(new Bullet(handler.object.get(i).getX(), 
                            handler.object.get(i).getY() + 25,  
                            handler.object.get(i).getFacing() * 25, ObjectId.Bullet));
                }
                
                if(key == KeyEvent.VK_P) {
                    Game.state = STATE.PAUSE;
                }
            }
        }
    }
    
     /**
     * Goes throw all objects in the handler,
     * and change some characteristic of the current object,
     * if some key is released
     * Exactly it is a control over the player in the game
     * @param e key event object 
     */
    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ObjectId.Player){
                if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if(key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }
        }
    }
    
}
    
