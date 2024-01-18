import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;
/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        title = new GreenfootImage("titlepage.png");
        titleWidth = title.getWidth();
        setBackground(title);
        title.scale(600, 400);
        color1 = new Color(17, 71, 240);
        prepare(); 
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Use ↑ ↓ → ← to move", 35);
        addObject(label, 300, 230);;
        label.setFillColor(new Color(255, 171, 190));
        label.setLineColor(new Color(0,0,0));
        
        Label caution = new Label("Caution: Be care for the perilous bottom edge", 27);
        caution.setFillColor(new Color(242, 44, 70));
        caution.setLineColor(new Color(0,0,0));
        addObject(caution, 295, 270);
        
        Label caution2 = new Label("DO NOT venture beneath it!!", 27); 
        caution2.setFillColor(new Color(242, 44, 70));
        caution2.setLineColor(new Color(0,0,0));
        addObject(caution2, 310, 310);
        
        Start startButton = new Start();
        addObject(startButton, 300, 360);

    }

}


