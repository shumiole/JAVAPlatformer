package game.window;

/**
 * 
 * @autor shumiole
 */

import org.junit.Test;

public class GameTest {
    
    Game instance = new Game();
     
    @Test
    public void testInit() {
        System.out.println("init");
        instance.init();
    }

    @Test
    public void testStart() {
        System.out.println("start");
        instance.start();
    }

    @Test
    public void testRun() {
        System.out.println("run");
        instance.run();
    }
}