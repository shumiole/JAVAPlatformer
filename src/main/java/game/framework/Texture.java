package game.framework;

import java.awt.image.BufferedImage;

/**
 * Class contain all of the textures
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Texture {
    
    SpriteSheet bs, ps, ib, cs, ns, hs, es, ss, uis;
    
    private BufferedImage invisibleBlock = null;
    private BufferedImage blockSheet = null;
    private BufferedImage playerSheet = null;
    private BufferedImage coinSheet = null;
    private BufferedImage numberSheet = null;
    private BufferedImage hearthSheet = null;
    private BufferedImage enemySheet = null;
    private BufferedImage signSheet = null;
    private BufferedImage uiSheet = null;
    
    public BufferedImage[] block = new BufferedImage[10];
    public BufferedImage[] player = new BufferedImage[6];
    public BufferedImage[] coin = new BufferedImage[10];
    public BufferedImage[] number = new BufferedImage[10];
    public BufferedImage[] hearth = new BufferedImage[2];
    public BufferedImage spike;
    public BufferedImage[] spider = new BufferedImage[6];
    public BufferedImage sign;
    public BufferedImage[] button = new BufferedImage[3];
    
    /**
     * Constructor
     * Contain all of the textures
     */
    public Texture() {
        
        BufferedImageLoader loader = new BufferedImageLoader();
        
        invisibleBlock = loader.loadImage("/invisibleBlock.png");
        blockSheet = loader.loadImage("/blocksSheet.png");
        playerSheet = loader.loadImage("/hero.png");
        coinSheet = loader.loadImage("/coins.png");
        numberSheet = loader.loadImage("/numbers.png");
        hearthSheet = loader.loadImage("/hearths.png");
        enemySheet = loader.loadImage("/spider.png");
        signSheet = loader.loadImage("/sign.png");
        uiSheet = loader.loadImage("/gui.png");
        
        
        ib = new SpriteSheet(invisibleBlock);
        bs = new SpriteSheet(blockSheet);
        ps = new SpriteSheet(playerSheet);
        cs = new SpriteSheet(coinSheet);
        ns = new SpriteSheet(numberSheet);
        hs = new SpriteSheet(hearthSheet);
        es = new SpriteSheet(enemySheet);
        ss = new SpriteSheet(signSheet);
        uis = new SpriteSheet(uiSheet);
        
        getTextures();
    }
    
    private void getTextures(){
        block[0] = ib.grabImage(1, 1, 32, 32);  // invisible block
        block[1] = ib.grabImage(1, 1, 32, 1);   // invisible top
        
        block[2] = bs.grabImage(2, 1, 32, 32);  // center block with grass
        block[3] = bs.grabImage(1, 1, 32, 32);  // left block with grass
        block[4] = bs.grabImage(3, 1, 32, 32);  // right block with grass
        
        block[5] = bs.grabImage(2, 2, 32, 32);  // center halfblock with grass
        block[6] = bs.grabImage(1, 2, 32, 32);  // left halfblock with grass
        block[7] = bs.grabImage(3, 2, 32, 32);  // right halfblock with grass
        block[8] = bs.grabImage(4, 2, 32, 32);  // center round halfblock with grass 
        
        block[9] = bs.grabImage(1, 3, 11, 32);  // wall
        
        sign = ss.grabImage(1, 1, 63, 84);      // sign next level
        
        spike = bs.grabImage(6, 1, 32, 32);     // spike
        
        player[0] = ps.grabImage(1, 1, 32, 64); // player look right
        player[1] = ps.grabImage(2, 1, 32, 64); // player look left
        
        player[2] = ps.grabImage(1, 2, 32, 64); // player's walk animation 1 (right)
        player[3] = ps.grabImage(2, 2, 32, 64); // player's walk animation 2 (right)
        
        player[4] = ps.grabImage(1, 3, 32, 64); // player's walk animation 1 (left)
        player[5] = ps.grabImage(2, 3, 32, 64); // player's walk animation 2 (left)
        
        spider[0] = es.grabImage(1, 1, 76, 53); // spider
        spider[1] = es.grabImage(2, 1, 76, 53); // spider's walk animation 1 (right)
        spider[2] = es.grabImage(3, 1, 76, 53); // spider's walk animation 2 (right)
        spider[3] = es.grabImage(4, 1, 76, 53); // spider's walk animation 1 (left)
        spider[4] = es.grabImage(5, 1, 76, 53); // spider's walk animation 2 (left)
        spider[5] = es.grabImage(6, 1, 76, 53); // spider dead
        
        
        coin[0] = cs.grabImage(1, 1, 50, 50); // coin's animation
        coin[1] = cs.grabImage(1, 2, 50, 50); // coin's animation
        coin[2] = cs.grabImage(1, 3, 50, 50); // coin's animation
        coin[3] = cs.grabImage(1, 4, 50, 50); // coin's animation
        coin[4] = cs.grabImage(1, 5, 50, 50); // coin's animation
        coin[5] = cs.grabImage(1, 6, 50, 50); // coin's animation
        coin[6] = cs.grabImage(1, 7, 50, 50); // coin's animation
        coin[7] = cs.grabImage(1, 8, 50, 50); // coin's animation
        coin[8] = cs.grabImage(1, 9, 50, 50); // coin's animation
        coin[9] = cs.grabImage(1, 10, 50, 50); // coin's animation
        
        number[0] = ns.grabImage(1, 1, 50, 72);  // 0
        number[1] = ns.grabImage(2, 1, 50, 72);  // 1
        number[2] = ns.grabImage(3, 1, 50, 72);  // 2
        number[3] = ns.grabImage(4, 1, 50, 72);  // 3
        number[4] = ns.grabImage(5, 1, 50, 72);  // 4
        number[5] = ns.grabImage(6, 1, 50, 72);  // 5
        number[6] = ns.grabImage(7, 1, 50, 72);  // 6
        number[7] = ns.grabImage(8, 1, 50, 72);  // 7
        number[8] = ns.grabImage(9, 1, 50, 72);  // 8
        number[9] = ns.grabImage(10, 1, 50, 72); // 9   
        
        hearth[0] = hs.grabImage(1, 1, 53, 45);  // empty
        hearth[1] = hs.grabImage(2, 1, 52, 45);  // full
        
        button[0] = uis.grabImage(1, 1, 190, 49);   //yellow button
        button[1] = uis.grabImage(1, 2, 310, 49);   //space buttons
        button[2] = uis.grabImage(1, 2, 100, 100);   //move button
        
    }
    
}
