import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * TitleScreen class represents the world shown when the game starts.
 * It provides a brief instructions.
 * 
 * @Yuvia Liu
 * @version Janurary 2024
 */
public class TitleScreen extends World
{
    private GreenfootImage title;
    private GreenfootImage idle;
    private int titleWidth;
    private Color color1;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {   
        // Initialize background
        super(600, 400, 1); 
        title = new GreenfootImage("titlepage.png");
        titleWidth = title.getWidth();
        setBackground(title);
        title.scale(600, 400);
        
        // color setting
        color1 = new Color(17, 71, 240);
        prepare(); 
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Initialize label instruction1
        Label label = new Label("Use ↑ ↓ → ← to move", 35);
        addObject(label, 300, 230);;
        label.setFillColor(new Color(255, 171, 190));
        label.setLineColor(new Color(0,0,0));
        
        // initialize label instruction2
        Label caution = new Label("Caution: Be care for the perilous bottom edge", 27);
        caution.setFillColor(new Color(242, 44, 70));
        caution.setLineColor(new Color(0,0,0));
        addObject(caution, 295, 270);
        
        // initialize label instruction3
        Label caution2 = new Label("DO NOT venture beneath it! Don't forget to collect the coins:)", 22); 
        caution2.setFillColor(new Color(242, 44, 70));
        caution2.setLineColor(new Color(0,0,0));
        addObject(caution2, 310, 310);
        
        // Add the start button
        Start startButton = new Start();
        addObject(startButton, 300, 360);

    }

}


