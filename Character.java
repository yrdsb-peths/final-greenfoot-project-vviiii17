import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author Yuvia 
 * @version January 2024
 */
public class Character extends Actor
{
    GreenfootImage[] idleFront = new GreenfootImage[4];
    GreenfootImage[] idleRight = new GreenfootImage[4];
    GreenfootImage[] idleLeft = new GreenfootImage[4];
    
    // Speed the charater moves at
    int speed = 2;
    
    /**
     * Constructor - The code that gets run on time when object is created
     */
    public Character()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/right" + i + ".png");
            idleRight[i].scale(100,100);
        }
    }
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
