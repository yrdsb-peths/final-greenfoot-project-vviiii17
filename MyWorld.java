import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class MyWorld extends World
{
    Background bg1 = new Background("background1.jpg");
    Background bg2 = new Background("background2.jpg");
    
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
        addObject(bg1, getWidth() / 2, bg1.getImage().getHeight() / 2);
        addObject(bg2, getWidth() / 2, bg1.getImage().getHeight() + bg2.getImage().getHeight() / 2);
        
        // Set each backrgound to know about the other
        bg1.setOtherBackground(bg2);
        bg2.setOtherBackground(bg1);

    }
    
    public void act()
    {
    
    }
    
}


// public class ScrollingWorld extends World
// {
    // Background bg1 = new Background();
    // Background bg2 = new Background();
    
    // public ScrollingWorld()
    // {    
        // super(600, 400, 1, false); 

        // bg1.setOtherBackground(bg2);
        // bg2.setOtherBackground(bg1);

        // addObject(bg1, 0, 200);
        // addObject(bg2, 1024, 200);
    // }

// }
