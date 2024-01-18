import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Coin class represents the coin in the game that character get to collect
 * 
 * @author Yuvia Liu
 * @version Janurary 2024
 */
public class Coin extends Actor
{
    private int vertical;
    
    /**
     * Constructor - The code that gets run on time when object is created
     * 
     * @param vertical The vertical speed of the coin.
     */
    public Coin(int vertical)
    {
        this.vertical = vertical;
        GreenfootImage coin = new GreenfootImage("coin.png");
        coin.scale(30, 30);
        setImage(coin);
    }
    
    /**
     * Act - do whatever the coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Check if the coin goes off the bottom of the screen
        setLocation(getX(), getY() + vertical); 
        if (getY() > getWorld().getHeight() && getWorld() != null) 
        {
            ((MyWorld)getWorld()).removeCoin(this);
        }
    }
    
    
}
