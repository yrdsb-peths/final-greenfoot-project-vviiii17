import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Character class represents the player's character in the game.
 * It handles animation, movement and intractions with game plays (other classes)
 * 
 * @author Yuvia 
 * @version January 2024
 */
public class Character extends Actor
{
    // Arrays for front-facing images animations
    GreenfootImage[] idleFront = new GreenfootImage[3];
    GreenfootSound carCrashing = new GreenfootSound("crashing.mp3");
    
    // Direction the character is facing
    String facing = "front";
    SimpleTimer animationTimer = new SimpleTimer();
    
    // Speed the charater moves at
    int speed = 1;
    int imageIndex = 0;
    private boolean justHit = false;
    
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
    
    /**
     * Animate the character based on current facing direction
     */
    
    public void animateCharacter()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            // Control the animation speed
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
        if(isTouching(Vehicle.class) && !justHit) 
        {
            MyWorld world = (MyWorld) getWorld();
            carCrashing.play();
            world.gameOver();
            justHit = true;
        } 
        else if (!isTouching(Vehicle.class)) 
        {
            justHit = false;
        }
        
        // if the character goes off the bottome edge, game over
        if (getY() >= getWorld().getHeight()) 
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
        }
        animateCharacter(); // Update character animation
        
        // collection of coins
        if (isTouching(Coin.class))
        {
            removeTouching(Coin.class);
            MyWorld world = (MyWorld) getWorld();
            world.collectCoin();
        }
        
    }
    

}
