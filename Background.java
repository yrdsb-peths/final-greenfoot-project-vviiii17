import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    private GreenfootImage image;
    
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Background(String image)
    {
        this.image = new GreenfootImage(image);
        this.image.scale(600, 400);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
        scroll();
    }
    
    public void scroll()
    {
        if (getY() >= getWorld().getHeight() + getImage().getHeight() / 2) 
        {
            setLocation(getX(), getY() - getImage().getHeight() * 2);
        }
        setLocation (getX(), getY() + 1);        
    }
}
