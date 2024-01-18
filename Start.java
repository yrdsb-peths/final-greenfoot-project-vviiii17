import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start class represents the button on the TitleScreen 
 * Press it to start the game
 * 
 * @author Yuvia Liu
 * @version Janurary 2024
 */
public class Start extends Actor
{
    private GreenfootImage start;
    
    /**
     * Consturctor - Initializes the start button image.
     */
    public Start()
    {
        start = new GreenfootImage("start.png");
        start.scale(120, 40);
        setImage(start);
    }
    
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Pressing animation
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth() + 0.9), (int)Math.round(getImage().getHeight()*0.9));
        }
        
        // Set the world to game world if it got pressed.
        if(Greenfoot.mouseClicked(this))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
