import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadingPage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoadingPage extends World
{

    /**
     * Constructor for objects of class LoadingPage.
     * 
     */
    GreenfootImage loadingRec = new GreenfootImage("redRectangle.png"); // A red rectangle to show the loading process
    SimpleTimer loadingTimer = new SimpleTimer(); // To control the loading speed
    static boolean canType = false;

    public LoadingPage()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        //Greenfoot.delay(40);
        canType = false;
        setBackground(new GreenfootImage("loading.png"));
        getBackground().drawImage(loadingRec,93,58); //Shows the red rectangle

    }

    public void act(){
        updateLoadingSign();
    }

    public void updateLoadingSign()
    {
        if (loadingTimer.millisElapsed() > 50)
        {
            loadingRec.scale(loadingRec.getWidth() + 30, loadingRec.getHeight());
            ifFinishLoading();
            getBackground().drawImage(loadingRec,93,58);
            loadingTimer.mark();
        }

    }

    /**
     *  Switch to the game after loading 
     */

    public void ifFinishLoading()
    {
        if (loadingRec.getWidth() > 1309) 
        {
           GamePlay game = new GamePlay();
           
           Greenfoot.setWorld(game);
           game.entireTimer.mark();
           canType = true;
        }
    }

}
