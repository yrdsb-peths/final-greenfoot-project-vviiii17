import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    private GreenfootImage start;
    
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
