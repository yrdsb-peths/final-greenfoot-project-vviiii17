import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private GreenfootImage title;
    private int titleWidth;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        title = new GreenfootImage("titlepage1.jpg");
        titleWidth = title.getWidth();
        setBackground(title);
        title.scale(600, 400);
        prepare();    
    }
    
    /**
     * The main world act loop
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Use ↑ ↓ → ← to move", 35);
        addObject(label, 200, 257);
        label.setLocation(300, 250);
        
        Label caution = new Label("Caution: Be care for the perilous bottom edge", 23);
        addObject(caution, 280, 300);

    }

}


