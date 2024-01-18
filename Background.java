import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Background class represents a vertically scrolling backrgound in the game by using two images
 * 
 * @author Yuvia Liu
 * @version Janurary 2024
 */

public class Background extends Actor
{
    private int imageHeight;
    private Background otherBackground;
    private int speed = 1; // Speed of vertical scrolling
    
    /**
     * Constructor for objects of class Background
     * 
     * @param image The image file name for the background
     */
    public Background(String image) 
    {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(600, 400); // Scale to fit the world size
        setImage(img);
        imageHeight = img.getHeight();    
    }
    
    /**
     * Sets a reference to another background object for scrolling background
     * 
     * @param otherBackrgound Another background object to link with this one.
     */
    public void setOtherBackground(Background otherBackground) 
    {
        this.otherBackground = otherBackground;
    }
    
    /**
     * Act method, handles the movement and responsitioning of the background
     */
    
    public void act()
    {
        // move the background vertically
        setLocation(getX(), getY() + speed);

        // When the background moves out of view, reposition it
        if (getY() > getWorld().getHeight() + imageHeight / 2) {
            setLocation(getX(), otherBackground.getY() - imageHeight);
        }
    }
    
    /**
     * Gets the current Y position
     */
    
    public int getYPosition()
    {
        return getY();
    }
}

