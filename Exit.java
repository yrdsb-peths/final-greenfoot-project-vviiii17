import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends Actor
{
    private GreenfootImage exit;
    
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
        if(Greenfoot.mousePressed(this))
        {
            getImage().scale((int)Math.round(getImage().getWidth() + 0.9), (int)Math.round(getImage().getHeight()*0.9));
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            TitleScreen titlePage = new TitleScreen();
            Greenfoot.setWorld(titlePage);
            Greenfoot.stop();
        }
    }
}
