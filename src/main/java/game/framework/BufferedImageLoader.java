package game.framework;

import static game.window.Game.log;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import javax.imageio.ImageIO;

/**
 * Loading image
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class BufferedImageLoader {
    
    private BufferedImage image;
    
    /**
     * load image
     * @param path to the image
     * @return image
     */
    public BufferedImage loadImage(String path){
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException ex) {
           log.log(Level.SEVERE, "Can't open(find) file!", ex);
        }
    return image;
    }
    
}
