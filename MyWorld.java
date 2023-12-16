import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class MyWorld extends World
{
    private Background bg1, bg2;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Greenfoot.start(); // Start the Greenfoot environment
        Greenfoot.setWorld(new TitleScreen()); // Set TitleScreen as the initial world
        bg1 = new Background("background1.jpg");
        addObject(bg1, getWidth()/2, getHeight()/2);
        bg2 = new Background("background2.jpg");
        addObject(bg2, getWidth(),bg1.getY() + getHeight());

    }
}
