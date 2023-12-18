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
        super(600, 400, 1, false);
        Greenfoot.start(); // Start the Greenfoot environment
        Greenfoot.setWorld(new TitleScreen()); // Set TitleScreen as the initial world
        bg1 = new Background("background1.jpg");
        addObject(bg1, getWidth()/2, getHeight()/2);
        bg2 = new Background("background2.jpg");
        addObject(bg2, getWidth()/2, -getHeight()/2);

    }
    
    public void act()
    {
        scrollBackground(bg1);
        scrollBackground(bg2);
    }
    
    private void scrollBackground(Background bg)
    {
        bg.setLocation(bg.getX(), bg.getY() + 1); 
        
        if (bg.getY() > getHeight() + bg.getImage().getHeight() / 2) 
        {
            if (bg.equals(bg1)) 
            {
                bg.setLocation(bg.getX(), bg2.getY() - bg2.getImage().getHeight() / 2 - bg.getImage().getHeight() / 2);
            } 
            else if (bg.equals(bg2)) 
            {
                bg.setLocation(bg.getX(), bg1.getY() - bg1.getImage().getHeight() / 2 - bg.getImage().getHeight() / 2);
            }
        }
    
    }
}
