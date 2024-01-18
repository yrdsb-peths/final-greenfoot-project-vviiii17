import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * The Vehicle class represents car in the game. Each vehicle can move horizontally
 * Cars are generated randomly from the image array.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class Vehicle extends Actor
{
    private int speedHorizontal;
    private int speedVertical;
    
    /**
     * Constructor for the Vehicle class
     * Initializes a vehicel with given horizontal and vertical speeds
     * 
     * @param speedHorizontal The horizontal speed of the vehicle/
     * @param speedVertical The vertial speed of the vehicle
     * @param carImages Array of image file names to choose from.
     */
    public Vehicle(int speedHorizontal, int speedVertical, String[] carImages)
    {
        this.speedHorizontal = speedHorizontal;
        this.speedVertical = speedVertical;
        GreenfootImage img = selectRandomImage(carImages);
        img.scale(160, 65);
        setImage(img);
    }
    
    /**
     * Selects a random car image from the given array of image file
     */ 
    private GreenfootImage selectRandomImage(String[] carImages)
    {
        int index = Greenfoot.getRandomNumber(carImages.length);
        return new GreenfootImage(carImages[index]);
    }
    
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Responsible for the movement of the vehicles.
     * 
     */
    public void act()
    {
        // move horizontally
        move(speedHorizontal);
        
        // move along with the background vertically
        setLocation(getX(), getY() + speedVertical);
        
        // if the vehicles goes beyong the right edge, wrap it to the left
        if(getX() > getWorld().getWidth())
        {
            setLocation(0, getY());
        }
    }
    
    /**
     * Sets a new horizontal speed for the vehicle
     * 
     * @param newSpeed The new horizontal speed to be set
     */
    public void setSpeedHorizontal(int newSpeed)
    {
        speedHorizontal = newSpeed;
    }
}
