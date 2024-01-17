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
    private int speedHorizontal = 2; 
    private String[] carImages = {"car1.png","car2.png","car3.png","car4.png","car5.png","car6.png"};
    private int[] laneFrames = {333, 404, 467, 534, -91, -3, 90, 177}; //mouse-tracked positions of the lanes 
    private int[] locations_i = {59, 71, 67, 66, 88, 93, 93, 88};
    private int[] locations = {327, 267, 200, 132, 58, 93, 93, 88};
    private boolean[] can_spawn = {true, true, true, true, false, false, false, false};
    private int carCounter = 0;
    private int lastYPosition = 0;
    private int verticalSpacing = 120;
    private int delay  = 150;   
    GreenfootSound bgm;
    
    // scoring system
    private int score = 0;
    private int hp = 1;
    private SimpleTimer scoreTimer;
    private Label scoreLabel;
    private Label hpLabel;
    private int maxCoins = 5;
    private int initialCoins = 3;
    private Label coinCountLabel;
    private int currentCoin = 0;
    private int currentCoinCount = 0;
    
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
        addObject(character, 300, 300);
        
        // initialize the socring system
        scoreLabel = new Label("Score: " + score, 45);
        addObject(scoreLabel, 100, 50);
        hpLabel = new Label("hp: " + hp, 45);
        addObject(hpLabel, 200, 50);
        setPaintOrder(Label.class);
        scoreTimer = new SimpleTimer();
        scoreTimer.mark();
        
        //background music
        bgm = new GreenfootSound("bgm1.mp3");
        bgm.playLoop();
        bgm.setVolume(40);
        
        // initialize coins
        coinCountLabel = new Label("Coins: " + currentCoin, 24);
        addObject(coinCountLabel, 100, 30);
        addInitialCoins();
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
    
    /**
     * End the game and draw 'Game Over'
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        bgm.stop();
        
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
            
            // increase speed of the car every 5 scores
            if (score % 5 == 0) 
            {
                speedHorizontal += 1;
                updateVehicleSpeed();
            }
        }
        
    }
    
    /**
     * make sure that once speed of cars increase, all exsisting cars speed increase
     */
    private void updateVehicleSpeed()
    {
        List<Vehicle> vehicles = getObjects(Vehicle.class);
        for(int i = 0; i < vehicles.size(); i++)
        {
            Vehicle v = vehicles.get(i);
            v.setSpeedHorizontal(speedHorizontal);
        }
    }
    
    public void spawnCoin() 
    {
        if (currentCoin < maxCoins) 
        {
            int x = Greenfoot.getRandomNumber(600);
            int y = Greenfoot.getRandomNumber(400);
            addObject(new Coin(), x, y);
            currentCoin++;
        }
    }
    
    private void addInitialCoins()
    {
        for(int i = 0; i < maxCoins; i++)
        {
            currentCoin--;
            spawnCoin();
        }
    }
    
    private void hpIncrease()
    {
        hp++;
        hpLabel.setValue("hp: " + hp);
        
    }
    
    public void hpDecrease()
    {
        hp--;
        hpLabel.setValue("hp: " + hp);
        if(hp == 0)
        {
            gameOver();
        }
    }
    
    private void updateCoinCount() 
    {  
        currentCoin++;
        coinCountLabel.setValue("Coins: " + currentCoin);
    }
    
    public void collectCoin()
    {
        updateCoinCount();
        spawnCoin();
        if (currentCoin == 5) 
        {
            hpIncrease();
            currentCoin = 0;
            coinCountLabel.setValue("Coins: " + currentCoin);
        }
        
    }
}
