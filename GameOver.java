import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameOver class represents the world shown when the game ends.
 * It displays a game over screen and provies the option to either replay or exit.
 * 
 * @author Yuvia Liu
 * @version Janurary 2024
 */
public class GameOver extends World
{
    private GreenfootImage gameover; // Background image
    private int gameWidth; 

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        super(600, 400, 1); 
        
        // Initializes the background
        gameover = new GreenfootImage("gameover.png");
        gameover.scale(600, 400);
        setBackground(gameover);
 
        // Add replay button
        Replay replayButton = new Replay();
        addObject(replayButton, 180, 300);
        
        // Add exit button
        Exit exitButton = new Exit();
        addObject(exitButton, 410, 300);
        
    }
    
}
