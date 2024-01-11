import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Background extends Actor
{
    private int imageHeight;
    private Background otherBackground;
    private int speed = 1; // Speed of vertical scrolling
    
    public Background(String image) {
        GreenfootImage img = new GreenfootImage(image);
        img.scale(600, 400); // Scale to fit the world size
        setImage(img);
        imageHeight = img.getHeight();    
    }
    
    public void setOtherBackground(Background otherBackground) {
        this.otherBackground = otherBackground;
    }
    
    public void act()
    {
        setLocation(getX(), getY() + speed);

        // When the background moves out of view, reposition it
        if (getY() > getWorld().getHeight() + imageHeight / 2) {
            setLocation(getX(), otherBackground.getY() - imageHeight);
        }
    }
    
    public int getYPosition()
    {
        return getY();
    }
    
    
}

