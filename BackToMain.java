import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackToMain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackToMain extends Button
{
    /**
     * Act - do whatever the BackToMain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage[] backImage = new GreenfootImage[2]; //Stores "light" and "dark" of start button images

    public BackToMain()
    {
        initBackButton();
    }

    public void act() 
    {
        checkHover();
        detectClick();
    }    

    public void initBackButton()
    {
        backImage[0] = new GreenfootImage("back_to_start_dark.png"); 
        backImage[1] = new GreenfootImage("back_to_start_light.png"); 
    }

    public void detectClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            //Switch to the loading page
            TitlePage main = new TitlePage();
            Greenfoot.setWorld(main);
            Marks.currentMark = 0.0;
        }

    }

    public void checkHover()
    {
        if (Greenfoot.mouseMoved(this))
        {
            setImage(backImage[1]);
        }
        else if(Greenfoot.mouseMoved(null))
        {
            setImage(backImage[0]);
        }

    }
}
