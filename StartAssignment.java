import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class StartAssignment here.
 * 
 * @Steven, Bill
 * @Oct 29, 2021
 */
public class StartAssignment extends Button
{
    /**
     * Act - do whatever the StartAssignment wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    GreenfootImage[] startImage = new GreenfootImage[2]; //Stores "light" and "dark" of start button images

    public StartAssignment()
    {
        initStartButton();
    }

    public void act() 
    {
        checkHover();
        detectClick();
    }    

    public void initStartButton()
    {
        startImage[0] = new GreenfootImage("Start_Dark.png"); 
        startImage[1] = new GreenfootImage("Start_Light.png"); 
    }

    public void detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //Switch to the loading page
            LoadingPage loading = new LoadingPage();
            Greenfoot.setWorld(loading);
        }

    }

    public void checkHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(startImage[1]);
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(startImage[0]);
        }

    }
}
