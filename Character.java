import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author Yuvia 
 * @version January 2024
 */
public class Character extends Actor
{
    GreenfootImage[] idleFront = new GreenfootImage[3];
    GreenfootSound carCrashing = new GreenfootSound("crashing.mp3");
    
    // Direction the character is facing
    String facing = "front";
    SimpleTimer animationTimer = new SimpleTimer();
    // Speed the charater moves at
    int speed = 2;
    int imageIndex = 0;
    
    /**
     * Constructor - The code that gets run on time when object is created
     */
    public Character()
    {  
        for(int i = 0; i < 3; i++)
        {
            idleFront[i] = new GreenfootImage("character" + i + ".png");
            idleFront[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        // Set the initial character image to be the front image
        setImage(idleFront[0]);
    }
    
    public void animateCharacter()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("front"))
        {
            // update animation images
            setImage(idleFront[imageIndex]); 
            imageIndex = (imageIndex + 1) % idleFront.length;
        
        }   
    }
    
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // press keys
        if(Greenfoot.isKeyDown("left"))
        {
            move(-speed);
        }
        
        else if(Greenfoot.isKeyDown("right"))
        {
            move(speed);
        }
        
        else if(Greenfoot.isKeyDown("up"))
        {
            if(getY() >= 1) // make sure the character doesn't go off the top of the screen
            {
                setLocation(getX(), getY() - speed);
                facing = "front"; 
            }  
        }
        
        else if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + speed); 
        }
        
        // crash on cars
        if(isTouching(Vehicle.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.hpDecrease();
            carCrashing.play();
        }
        
        animateCharacter();
        
    }
    

}
