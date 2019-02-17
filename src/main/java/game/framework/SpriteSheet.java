package game.framework;

import java.awt.image.BufferedImage;

/**
 * Class that load some image from the sprite sheet
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class SpriteSheet {
    private BufferedImage image;

    /**
     * Constructor
     * @param image that contain a lot of images
     */
    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }
    
    /**
     * load needed image from the sprite sheet
     * @param col column of the needed image
     * @param row of the needed image
     * @param width of the needed image
     * @param height of the needed image
     * @return needed image
     */
    public BufferedImage grabImage(int col, int row, int width, int height){
        BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
        return img;
    }
    
}
