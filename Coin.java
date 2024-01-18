import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private int vertical;
    
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
        setLocation(getX(), getY() + vertical);
        if (getY() > getWorld().getHeight() && getWorld() != null) 
        {
            ((MyWorld)getWorld()).removeCoin(this);
        }
    }
    
    
}
