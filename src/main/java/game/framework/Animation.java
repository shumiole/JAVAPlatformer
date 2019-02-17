package game.framework;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Drawing animation using images
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Animation {
    
    private int speed;
    private int frames;
    
    private int index = 0;
    private int count = 0;
    
    private BufferedImage[] images;
    private BufferedImage currentImg;

    /**
     * Constructor, copy all images into array
     * 
     * @param speed of the frames change
     * @param args images that make up the animation
     */
    
    public Animation(int speed, BufferedImage... args) {
        this.speed = speed;
        images = new BufferedImage[args.length];
        
        System.arraycopy(args, 0, images, 0, args.length);
        
        frames = args.length;
    }
    
    /**
     * run animation
     */
    public void runAnimation(){
        index++;
        if(index > speed){
            index = 0;
            nextFrame();
        }
    }
    
    /**
     * changing current image to the next image
     */
    public void nextFrame(){
        for(int i = 0; i < frames; i++)
            if(count == i) currentImg = images[i];
        
        count++;
        if(count > frames)
            count = 0;
    }
    
    /**
     * draw current image
     * @param g graphic object
     * @param x coordinate
     * @param y coordinate
     */
    public void drawAnimation(Graphics g, int x, int y){
        g.drawImage(currentImg, x, y, null);
    }
    
    /**
     * draw current image using scale
     * @param g graphic object
     * @param x coordinate
     * @param y coordinate
     * @param scaleX scale for x
     * @param scaleY scale for y
     */
    public void drawAnimation(Graphics g, int x, int y, int scaleX, int scaleY){
        g.drawImage(currentImg, x, y, scaleX, scaleY, null);
    }
    
}
