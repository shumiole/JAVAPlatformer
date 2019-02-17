package game.framework;

/**
 * 
 * @autor shumiole
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class ScorerTest {

    @Test
    public void testGetCoins() {
        System.out.println("getCoins");
        Scorer instance = new Scorer();
        int expResult = 0;
        int result = instance.getCoins();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLives() {
        System.out.println("getLives");
        Scorer instance = new Scorer();
        int expResult = 3;
        int result = instance.getLives();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCoins() {
        System.out.println("setCoins");
        int coins = 0;
        Scorer instance = new Scorer();
        instance.setCoins(coins);
    }

    @Test
    public void testSetLives() {
        System.out.println("setLives");
        int lives = 0;
        Scorer instance = new Scorer();
        instance.setLives(lives);
    }
    
}
