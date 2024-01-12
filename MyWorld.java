import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class MyWorld extends World
{
    Background bg1 = new Background("bg1.jpg");
    Background bg2 = new Background("bg2.jpg");
    private static int speedVertical = 1;
    private static int speedHorizontal = 2; 
    private String[] carImages = {"car1.png","car2.png","car3.png","car4.png","car5.png","car6.png"};
    private int[] laneFrames = {333, 404, 467, 534, -91, -3, 90, 177}; //mouth-tracked positions of the lanes 
    private int[] locations_i = {59, 71, 67, 66, 88, 93, 93, 88};
    private int[] locations = {327, 267, 200, 132, 58, 93, 93, 88};
    private boolean[] can_spawn = {true, true, true, true, false, false, false, false};
    private int carCounter = 0;
    private int lastYPosition = 0;
    private static int verticalSpacing = 120;
    private static int delay  = 150;
    int hp = 3;
    Label hpLevel = new Label("hp: " + hp, 50);
    
    // scoring system
    private int score = 0;
    private SimpleTimer scoreTimer;
    private Label scoreLabel;
    
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
        
        Character character = new Character();
        addObject(character, 300, 200);
        
        // initialize the socre and the timer
        scoreLabel = new Label("Score: " + score, 50);
        addObject(scoreLabel, 100, 50);
        setPaintOrder(Label.class);
        scoreTimer = new SimpleTimer();
        scoreTimer.mark();
        
    }
    
    public void act()
    {
        for (int i=0; i<8; i++)
        {
            locations[i]++;
            if(locations[i] >= 400)
            {
                can_spawn[i] = false;
            }
            
            if(Math.abs(laneFrames[i] - bg2.getY()) <= 3)
            {
                can_spawn[i] = true;
                locations[i] = locations_i[i];
            }
                
        }
        // Add cars periodically
        if(carCounter <= 0)
        {
            addCar();
            carCounter = delay;
        }
        carCounter--;
        
        increaseScore();
        
    }
    
    private void addCar()
    {
        Vehicle car = new Vehicle(speedHorizontal, speedVertical, carImages);
        int yPosition = getNextYPosition();
        if(yPosition != -1)
        {
            int offset;
            if(yPosition <= 3)
            {
                offset = 30;
            }
            else
            {
                offset = 40;
            }
            // cars start at the leftmost of the screen
            addObject(car, 0, locations[yPosition] - offset);  
        }    
    }
    
    private int getNextYPosition()
    {
        int count = 0;
        for (int i = 0; i < can_spawn.length; i++) 
        {
            if (can_spawn[i]) 
            {
                count++;
            }
        }

        if (count == 0) {
            return -1;  // Return -1 if no spawn is possible
        }

    // Create an array to store possible spawn indices
        int[] spawnIndices = new int[count];
        int idx = 0;
        for (int i = 0; i < can_spawn.length; i++) 
        {
            if (can_spawn[i]) 
            {
                spawnIndices[idx++] = i;
            }
        }
    // Select a random index from spawnIndices
    int randomIndex = (int) (Math.random() * spawnIndices.length);
    return spawnIndices[randomIndex];
    }
    
    public void hpDecrease()
    {
        hp--;
        hpLevel.setValue("hp: " + hp);
        
        if(hp == 0)
        {
            gameOver();
        }
    }
    
    /**
     * End the game and draw 'Game Over'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        
        // end the game
        Greenfoot.stop();
    }
    
    public void increaseScore()
    {
        if(scoreTimer.millisElapsed() >= 5000)
        {
            score++;
            scoreLabel.setValue("Score: " + score);
            scoreTimer.mark();
        }
    }
}
