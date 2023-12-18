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

}

// public class Background extends Actor
// {
    // private int imageWidth;
    // private int offset = 100;
    // private Background otherBackground;
    // private int speed = 4;
    
    // public Background() {
        // imageWidth = getImage().getWidth();    
    // }
    
    // public void setOtherBackground(Background otherBackground) {
        // this.otherBackground = otherBackground;
    // }
    
    // public void increaseSpeed() {
        // speed += 1;
    // }
    
    // public void act()
    // {
        // if(getX() < -imageWidth + offset) {
            // int newX = otherBackground.getX() + imageWidth;
            // setLocation(newX, getY());
        // }
        // move(-speed);
    // }
// }
