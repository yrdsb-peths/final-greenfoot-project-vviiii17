import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Exit Class represents the button in the game over screen
 * Press to end the game.
 * 
 * @author Yuvia Liu
 * @version Janurary 2024
 */
public class Exit extends Actor
{
    // Intialize variables
    private GreenfootImage exit;
    
    /**
     * Constructor - Initialize the button's image
     */
    public Exit()
    {
        exit = new GreenfootImage("exit.png");
        exit.scale(70, 70);
        setImage(exit);
    }
    
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // If the button is pressed, squeeze the image a bit for a small animation
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth() + 0.9), (int)Math.round(getImage().getHeight()*0.9));
        }
        
        // If the button is clicked, switch to the TitleScreen and stop the game
        if(Greenfoot.mouseClicked(this))
        {
            TitleScreen titlePage = new TitleScreen();
            // Switch back to title screen
            Greenfoot.setWorld(titlePage);
            Greenfoot.stop();
        }
    }
}
