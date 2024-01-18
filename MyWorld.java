import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * The MyWorld is the main program of the game, and represent the gameworld
 * It creates a crossy road game that players need to dodge the moving cars.
 * It handles the spawning of cars and coins,managing the score and game over state,
 * and initializing the game environment.
 * 
 * @author Yuvia Liu
 * @version December 2023
 */
public class MyWorld extends World
{
    // Background initialization 
    Background bg1 = new Background("bg1.jpg");
    Background bg2 = new Background("bg2.jpg");
    
    // Speed for verticle and horizontal movement of the cars
    private static int speedVertical = 1;
    private int speedHorizontal = 2; 
    
    // Image for the cars
    private String[] carImages = {"car1.png","car2.png","car3.png","car4.png","car5.png","car6.png"};
    
    // Lane positions and spawning settings
    private int[] laneFrames = {333, 404, 467, 534, -91, -3, 90, 177}; //mouse-tracked positions of the lanes 
    private int[] locations_i = {59, 71, 67, 66, 88, 93, 93, 88}; // initial position
    private int[] locations = {327, 267, 200, 132, 58, 93, 93, 88}; // actual position after movement 
    private boolean[] can_spawn = {true, true, true, true, false, false, false, false};
    
    // Counters and settings for car spawning
    private int carCounter = 0;
    private int lastYPosition = 0;
    private int verticalSpacing = 120;
    private int delay  = 150;   
    
    // Background music
    GreenfootSound bgm;
    
    // Scoring system
    private int score = 0;
    private SimpleTimer scoreTimer;
    private Label scoreLabel;
    private Label coinCountLabel;
    private int maxCoins = 5;
    private int initialCoins = 3;
    private int currentCoin = 0;
    private int coinCounter = 0;
    private int coinScore = 0;
    
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
        
        // Initializes background
        addObject(bg1, getWidth() / 2, bg1.getImage().getHeight() / 2);
        addObject(bg2, getWidth() / 2, bg1.getImage().getHeight() + bg2.getImage().getHeight() / 2);
        bg1.setOtherBackground(bg2);
        bg2.setOtherBackground(bg1);
        
        // Initializes characters
        Character character = new Character();
        addObject(character, 300, 300);
        
        // Initialize Socring system
        scoreLabel = new Label("Score: " + score, 45);
        addObject(scoreLabel, 100, 50);
        setPaintOrder(Label.class,Vehicle.class);
        scoreTimer = new SimpleTimer();
        scoreTimer.mark();
        
        //Initializes Background music
        bgm = new GreenfootSound("bgm1.mp3");
        bgm.playLoop();
        bgm.setVolume(40);
        
        // Initializes coins system
        coinCountLabel = new Label("Coins: " + coinScore, 45);
        addObject(coinCountLabel, 350, 50);
        addInitialCoins();
    }
    
    /**
     * called repteatedly to update game states
     */
    
    public void act()
    {
        // Update lane positions based on the scrolling background 
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
    
    /**
     * Add cars in a random lane
     */
    
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
    
    /**
     * Returns the next Y position for a car to sapwn
     * @return the Y position or -1 if no position is available
     */
    
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
        
        GameOver overWorld = new GameOver();
        Greenfoot.setWorld(overWorld);
        // end the game
        //Greenfoot.stop();
    }
    
    /**
     * Increases the score every 5 seconds and updates the car speed every 5 scores earned.
     */
    
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
                carCounter = delay;
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
    
    /**
     * Spawns a new coin in the world if the current count is below the maximum
     */
    public void spawnCoin() 
    {
        if (currentCoin < maxCoins) 
        {
            int x = Greenfoot.getRandomNumber(600);
            int y = Greenfoot.getRandomNumber(400);
            addObject(new Coin(speedVertical), x, y);
            currentCoin++;
        }
    }
    
    /**
     * Add the initial sets of the coins
     */
    
    private void addInitialCoins()
    {
        for(int i = 0; i < maxCoins; i++)
        {
            spawnCoin();
        }
    }
    
    /**
     * Collects coin and updates the coin score and coin count
     */

    public void collectCoin()
    {
        coinScore++;
        currentCoin--;
        coinCountLabel.setValue("Coins: " + coinScore);
        if (currentCoin % 5 == 0) 
        {
            coinCountLabel.setValue("Coins: " + coinScore);
        }
        spawnCoin();
        
    }
    
    /**
     * Removes a coin from the world and decrease the current coin count
     * @param coin the coin to be removed
     */
    public void removeCoin(Coin coin) 
    {
        removeObject(coin);
        currentCoin--;
        spawnCoin();
    }
}
