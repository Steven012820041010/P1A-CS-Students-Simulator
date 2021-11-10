import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LoadingPage here.
 * 
 * @Steven Zhu, Bill Wei
 * @Nov 5, 2021
 */
public class LoadingPage extends World
{

    /**
     * Constructor for objects of class LoadingPage.
     * 
     */
    GreenfootImage loadingRec = new GreenfootImage("redRectangle.png"); // A red rectangle loading bar to show the loading process
    SimpleTimer loadingTimer = new SimpleTimer(); // To control the loading speed
    

    public LoadingPage()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        setBackground(new GreenfootImage("loading.png"));
        getBackground().drawImage(loadingRec, 93, 58); //Shows the red rectangle loading bar

    }

    public void act(){
        updateLoadingSign();
    }

    /**
     * Keeps the red progress rectangle moving forward
     */
    public void updateLoadingSign()
    {
        if (loadingTimer.millisElapsed() > 50)
        {
            loadingRec.scale(loadingRec.getWidth() + 30, loadingRec.getHeight());
            ifFinishLoading(); //To check if finished loading
            getBackground().drawImage(loadingRec,93,58);
            loadingTimer.mark();
        }

    }

    /**
     *  Switch to the game after finishing loading 
     */
    public void ifFinishLoading()
    {
        if (loadingRec.getWidth() > 1309) 
        {
           GamePlay game = new GamePlay();
           Greenfoot.setWorld(game);
           game.entireTimer.mark();
          
        }
    }

}
