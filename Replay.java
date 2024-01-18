import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Replay represents the replay button displays in the gameOver class
 * Press it in order to replay the game
 * 
 * @author Yuvia Liu 
 * @version Janurary 2024
 */
public class Replay extends Actor
{
    private GreenfootImage replay;
    
    /**
     * Constuctor - Initializes the replay button image
     */
    public Replay()
    {
        replay = new GreenfootImage("replay.png");
        replay.scale(70, 70);
        setImage(replay);
    }

    /**
     * Act - do whatever the Replay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // A press animation
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth() + 0.9), (int)Math.round(getImage().getHeight()*0.9));
        }
        
        // Press to restart the game
        if(Greenfoot.mouseClicked(this))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
