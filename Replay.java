import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Replay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Replay extends Actor
{
    private GreenfootImage replay;
    
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
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth() + 0.9), (int)Math.round(getImage().getHeight()*0.9));
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
