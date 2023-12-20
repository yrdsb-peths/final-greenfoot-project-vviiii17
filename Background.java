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
}

// import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// /**
 // * Write a description of class Background here.
 // * 
 // * @author (your name) 
 // * @version (a version number or a date)
 // */
// public class Background extends Actor
// {
    // private int imageHeight;
    // private Background otherBackground;
    // private int speed = 1;
    
    // /**
     // * Act - do whatever the Background wants to do. This method is called whenever
     // * the 'Act' or 'Run' button gets pressed in the environment.
     // */
    
    // public Background(String image)
    // {
        // GreenfootImage img = new GreenfootImage(image);
        // img.scale(600, 400);  // Scale the background
        // setImage(image);
        // imageHeight = img.getHeight();
    // }
    
    // public void setOtherBackground(Background otherBackground) 
    // {
        // this.otherBackground = otherBackground;
    // }
    
    // public void act()
    // {
        // setLocation(getX(), getY() + speed);
        // // check if the image has scrolled out of view
        // if(getY() - imageHeight/2 >= getWorld().getHeight())
        // {
            // int newY = otherBackground.getY() - otherBackground.imageHeight/2;
            // setLocation(getX(), newY);
        // }
    // }
    
//}

// sample codes

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
