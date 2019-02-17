package game.framework;

/**
 * Class which control number of the coins and lives
 * 
 * @version 1.0
 * 
 * @autor shumiole
 */
public class Scorer {
    private int coins;
    private int lives;

    /**
     * Constructor
     * set number of the coins on zero,
     * and number of the lives on three
     * This is the points at the beginning of the game
     */
    public Scorer() {
        this.coins = 0;
        this.lives = 3;
    }

    /**
     * @return number of the coins
     */
    public int getCoins() {
        return coins;
    }

    /**
     * @return number of lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * set number of the coins
     * @param coins 
     */
    public void setCoins(int coins) {
        this.coins = coins;
    }

    /**
     * set number of the lives
     * @param lives 
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
    
}
