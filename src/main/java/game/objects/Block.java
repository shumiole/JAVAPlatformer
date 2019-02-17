package game.objects;

import game.framework.*;
import game.window.Game;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 * Class for the blocks
 * extends GameObject class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Block extends GameObject {
    
    Texture tex = Game.getInstance();
    private int type;
    private int boundX, boundY;
    
    public Block(float x, float y, int type, ObjectId id) {
        super(x, y, id);
        this.type = type;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        
    }

    @Override
    public void render(Graphics g) {
        
        for (int i = 0; i < 10; i++)
            if (i == type) g.drawImage(tex.block[i], (int)x, (int)y, null);
    }

    public int getType(){
        return type;
    }
    
    @Override
    public Rectangle getBounds() { 
        
        if (type == 0 || (type >= 2 && type <= 4)){
            boundX = 32;
            boundY = 32;
        }
        if (type == 1){
            boundX = 32;
            boundY = 2;
        }
        if (type >= 5 && type <= 8 ){
            boundX = 32;
            boundY = 16;
        }
        
        if(type == 9){
            boundX = 11;
            boundY = 32;
        }
        
        return new Rectangle((int)x, (int)y, boundX, boundY);
    }
    
}