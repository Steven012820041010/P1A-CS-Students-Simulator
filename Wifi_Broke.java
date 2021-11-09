import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wifi_Broke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wifi_Broke extends World
{

    /**
     * Constructor for objects of class Wifi_Broke.
     * 
     */
    public Wifi_Broke()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        
        
    }
    
    public void act()
    {
        Greenfoot.delay(100);
        LoadingPage loading = new LoadingPage();
        Greenfoot.setWorld(loading);
        
        
    }
}
