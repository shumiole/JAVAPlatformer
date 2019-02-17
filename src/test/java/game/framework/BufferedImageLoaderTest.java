package game.framework;

/**
 * 
 * @autor shumiole
 */

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.Test;

public class BufferedImageLoaderTest {
    
    BufferedImageLoader instance = new BufferedImageLoader();
    
    @Test
    public void testLoadImage() throws IOException {
        System.out.println("loadImage");
        String path = "/level1.png";
        
        BufferedImage expResult = ImageIO.read(getClass().getResource(path));
      
        BufferedImage result = instance.loadImage(path);       
        Assert.assertArrayEquals(imageToArray(expResult), imageToArray(result));
    }
    
    private int[][] imageToArray(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        int [][] array = new int[w][h];
        for(int i = 0; i < w; i++)
            for(int j = 0; j < h; j++)
                array[i][j] = image.getRGB(i, j);
        
        return array;
    }
}
