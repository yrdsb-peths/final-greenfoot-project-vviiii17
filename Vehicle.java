import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class Vehicle here.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class Vehicle extends Actor
{
    private int speedHorizontal;
    private int speedVertical;
    
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Vehicle(int speedHorizontal, int speedVertical, String[]carImages)
    {
        this.speedHorizontal = speedHorizontal;
        this.speedVertical = speedVertical;
        Random rand = new Random();
        int index = rand.nextInt(carImages.length);
        setImage(carImages[index]);
    }
    
    public void act()
    {
        // Add your action code here.
        
    }

    
    
    
    
     
    
    
}
