package game.window;

import com.sun.istack.internal.logging.Logger;
import game.framework.*;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Game class
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Game extends Canvas implements Runnable {

    public static Logger log = Logger.getLogger(Game.class.getClass());
    
    private boolean running = false;
    private Thread thread;
    
    /**
     * width and height of the game window
     */
    public static int WIDTH, HEIGHT;
    
    /**
     * background image
     */
    public BufferedImage back = null;
    
    private Handler handler;
    private Camera cam;
    private static Texture tex;
    private Scorer score;
    private Animation coinAnimation;
    private Menu menu;
    private GameOver gameOver;
    private Help help;
    private Pause pause;
    
    /**
     * Special types for game states
     */
    public static enum STATE{
        MENU,
        GAME,
        HELP,
        PAUSE,
        GAMEOVER;
    }
    /**
     * starting state
     */
    public static STATE state = STATE.MENU;
    
    /**
     * Initialize all needed classes and variables for the game
     */
    public void init(){
        
        WIDTH = getWidth();
        HEIGHT = getHeight();
        
        tex = new Texture();
        
        BufferedImageLoader loader = new BufferedImageLoader(); 
        back = loader.loadImage("/background.png");     // loading background
        
        score = new Scorer();
        cam = new Camera(0, 0);
        handler = new Handler(cam, score, state); 
        
        menu = new Menu();
        gameOver = new GameOver(handler, score);
        help = new Help();
        pause = new Pause();
        
        coinAnimation = new Animation(3, tex.coin[0],tex.coin[1],tex.coin[2],tex.coin[3],
                tex.coin[4],tex.coin[5],tex.coin[6],tex.coin[7],tex.coin[8],
                tex.coin[9]);
        
       
        this.addMouseListener(new MouseInput());
        this.addKeyListener(new KeyInput(handler));
    }
    
    /**
     * starting thread
     */
    public synchronized void start(){
        
        if (running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    /**
     * threads run
     * here implemented game loop
     */
    @Override
    public void run(){
        init();
        this.requestFocus();
        long timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while(delta >= 1){
		tick();
		updates++;
		delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
		timer += 1000;
		log.info("FPS: " + frames + " TICKS: " + updates);
		frames = 0;
		updates = 0;
            }
        }
    }

    /**
     * changes for all objects in the game
     * and for all states
     */
    private void tick() {
        if(state == STATE.GAME){
            log.info("State: " + state + " coins: " + score.getCoins() + " lives: " + score.getLives());
            handler.tick();
            coinAnimation.runAnimation();
        
            for(int i = 0; i < handler.object.size(); i++){
                if(handler.object.get(i).getId() == ObjectId.Player){
                cam.tick(handler.object.get(i)); 
                }   
            }
            
            if (score.getLives() == 0 || handler.GetLevelIter() == handler.GetNumberOfLevels()){
                state = STATE.GAMEOVER;
            }
        }
    }

    /**
     * draw frames for all objects
     * and for all states
     */
    private void render() {
        
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D)g; 

        g.drawImage(back, 0, 0, this);
        
        switch (state) {
            case GAME:
                g2d.translate(cam.getX(), cam.getY());
                    handler.render(g);
                g2d.translate(-cam.getX(), -cam.getY());
                coinAnimation.drawAnimation(g, getWidth() - 100, 10, 30, 30);
                
                for(int i = 0; i <= score.getCoins(); i++){
                    if (score.getCoins() / 100 == i) g.drawImage(tex.number[i],  getWidth() - 65, 12, 15, 25, null);
                    if (score.getCoins() / 10 == i) g.drawImage(tex.number[i],  getWidth() - 48, 12, 15, 25, null);
                    if (score.getCoins() % 10 == i ) g.drawImage(tex.number[i],  getWidth() - 31, 12, 15, 25, null);
                }   
                g.drawImage(tex.hearth[0],  getWidth() - 35, 45, 25, 20, null);
                g.drawImage(tex.hearth[0],  getWidth() - 65, 45, 25, 20, null);
                g.drawImage(tex.hearth[0],  getWidth() - 95, 45, 25, 20, null);
                if(score.getLives() >= 1) g.drawImage(tex.hearth[1],  getWidth() - 35, 45, 25, 20, null);
                if(score.getLives() >= 2) g.drawImage(tex.hearth[1],  getWidth() - 65, 45, 25, 20, null);
                if(score.getLives() >= 3) 
                {
                    g.drawImage(tex.hearth[1],  getWidth() - 95, 45, 25, 20, null);
                    score.setLives(3);
                }
                break;
            
            case MENU:
                menu.render(g);
                newGame();
                break;
            
            case GAMEOVER:
                gameOver.render(g);
                break;
            
            case HELP:
                help.render(g);
                break;
            case PAUSE:
                pause.render(g);
                break;
        }
        g.dispose();
        bs.show();
        
    }
    
    /**
     * set the game on the starting point
     */
    public void newGame(){
        handler.levelIter = 0;
        score.setCoins(0);
        score.setLives(3);
    }
    
    /**
     * @return all of the textures 
     */
    public static Texture getInstance() {
        return tex;
    }
    
}
