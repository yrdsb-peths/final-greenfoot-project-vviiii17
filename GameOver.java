import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    private GreenfootImage gameover;
    private int gameWidth;

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        super(600, 400, 1); 
        gameover = new GreenfootImage("gameover.png");
        gameover.scale(600, 400);
        setBackground(gameover);
 
        Replay replayButton = new Replay();
        addObject(replayButton, 180, 300);
        
        Exit exitButton = new Exit();
        addObject(exitButton, 410, 300);
        
    }
    
}
