package game.framework;

import game.objects.*;
import game.window.Camera;
import game.window.Game.STATE;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

/**
 * Add all object in the game into a linked list
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Handler {
    
    /**
     * linked list for all object in the game
     */
    public LinkedList<GameObject> object = new LinkedList<>();
    
    /**
     * levels number
     */
    public int levelIter = 0;
    private GameObject tempObject;
    private Camera cam;
    private Scorer score;
    private BufferedImage[] level = new BufferedImage[3];
    private STATE state;
    
    /**
     * Constructor
     * create handler and load current level from the image
     * 
     * @param cam object of the Camera class
     * @param score object of the scorer class
     * @param state of the game
     */
    public Handler(Camera cam, Scorer score, STATE state){
        this.cam = cam;
        this.score = score;
        this.state = state;
        
        BufferedImageLoader loader = new BufferedImageLoader(); 
        level[0] = loader.loadImage("/level1.png");         // loading level    
        level[1] = loader.loadImage("/level2.png");
        level[2] = loader.loadImage("/level3.png");
        
        loadImageLevel(level[levelIter]);
        levelIter++;
    }
    
    /**
     * Change the characteristics of the every object in the linked list
     */
    public void tick(){
        for(int  i = 0; i < object.size(); i++){
            tempObject = object.get(i);
            tempObject.tick(object);
        }
    }
    
    /**
     * Draw every object in the linked list
     * @param g graphic object
     */
    public void render(Graphics g){
        for(int  i = 0; i < object.size(); i++){
            tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    
    /**
     * add object into a linked list with all object in the game
     * @param object 
     */
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    /**
     * special addObject for the blocks
     * add add object into a linked list with all object in the game
     * @param x coordinate 
     * @param y coordinate
     * @param type of the block
     */
    public void addBlock(int x, int y, int type){
        int xx = x * 32;
        if(type == 9 && x != 57) xx += 20;
        if (type == 9 && x == 40) xx -= 20;
            this.object.add(new Block(xx, y*32, type, ObjectId.Block));
    }
    
    /**
     * (load level)
     * add all objects into a linked list from the image)
     * @param image 
     */
    public void loadImageLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        
        System.out.println("Widht:" + w + ", height:" + h);
        
        for(int xx = 0; xx < h; xx++){
            for(int yy = 0; yy < w; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 100 & green == 100 & blue == 100) 
                    addBlock(xx, yy, 0);                
                
                if(red == 90 & green == 90 & blue == 90) 
                    addBlock(xx, yy, 1);
                
                if(red == 255 & green == 255 & blue == 255) 
                    addBlock(xx, yy, 2); 
                
                if(red == 253 & green == 253 & blue == 253) 
                    addBlock(xx, yy, 3); 
                
                if(red == 254 & green == 254 & blue == 254) 
                    addBlock(xx, yy, 4); 
                
                if(red == 200 & green == 200 & blue == 200) 
                    addBlock(xx, yy, 5); 
                
                if(red == 199 & green == 199 & blue == 199) 
                    addBlock(xx, yy, 6); 
                
                if(red == 201 & green == 201 & blue == 201) 
                    addBlock(xx, yy, 7);
                
                if(red == 225 & green == 225 & blue == 225) 
                    addBlock(xx, yy, 8);
                
                if(red == 150 & green == 150 & blue == 150)                 //wall
                    addBlock(xx, yy, 9);

                if(red == 140 & green == 200 & blue == 255)
                    addObject(new Spike(xx*32, yy*32, ObjectId.Spike));
                
                if(red == 255 & green == 216 & blue == 0) 
                    addObject(new Coin(xx*32, yy*32, ObjectId.Coin));
                
                if(red == 255 & green == 0 & blue == 0) 
                    addObject(new Spider(xx*32, yy*32, 1, this, ObjectId.Spider));
                
                if(red == 180 & green == 0 & blue == 0) 
                    addObject(new Spider(xx*32, yy*32, 0, this, ObjectId.Spider));
                
                if(red == 0 & green == 0 & blue == 255) 
                    addObject(new Player(xx*32, yy*32, this, cam, score, ObjectId.Player));
                
                if(red == 150 & green == 95 & blue == 70)
                    addObject(new Sign(xx*32, yy*32, ObjectId.Sign));
            }
        }
    }
    
    /**
     * load the next level
     */
    public void switchLevel(){
        clearLevel();
        cam.setX(0);
        
        loadImageLevel(level[levelIter]);
        levelIter++;
        //if(levelIter == level.length - 1){
          //  levelIter = 0;
        //}
        
    }
    /**
     * (clear level)
     * delete all object from the linked list
     */  
    private void clearLevel(){
        object.clear();
    }
    
    /**
     * @return number of the current level
     */
    public int GetLevelIter(){
        return levelIter;
    }
    /**
     * @return quantity of the level 
     */
    public int GetNumberOfLevels(){
        return level.length;
    }
}