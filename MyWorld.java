import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class MyWorld extends World
{
    Background bg1 = new Background("background1.jpg");
    Background bg2 = new Background("background2.jpg");
    private static int speedVertical = 1;
    private static int speedHorizontal = 2; 
    private String[] carImages = {"car1.png","car2.png","car3.png","car4.png","car5.png","car6.png"};
    private int carCounter = 0;
    private int lastYPosition = 0;
    private static int verticalSpacing = 70;
    private static int delay  = 150;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        Greenfoot.start(); // Start the Greenfoot environment
        Greenfoot.setWorld(new TitleScreen()); // Set TitleScreen as the initial world
        addObject(bg1, getWidth() / 2, bg1.getImage().getHeight() / 2);
        addObject(bg2, getWidth() / 2, bg1.getImage().getHeight() + bg2.getImage().getHeight() / 2);
        
        // Set each backrgound to know about the other
        bg1.setOtherBackground(bg2);
        bg2.setOtherBackground(bg1);
    }
    
    public void act()
    {
        // Add cars periodically
        if(carCounter <= 0)
        {
            addCar();
            carCounter = delay;
        }
        carCounter--;
    }
    
    private void addCar()
    {
        Vehicle car = new Vehicle(speedHorizontal, speedVertical, carImages);
        int yPosition = getNextYPosition();
        
        // all cars start at the leftmost of the screen
        addObject(car, 0, yPosition);  
    }
    
    private int getNextYPosition()
    {
        lastYPosition += verticalSpacing;
        if(lastYPosition >= getHeight())
        {
            lastYPosition = 0;
        }
        return lastYPosition;
    }
    
}



