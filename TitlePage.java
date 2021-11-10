import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @Steven, Bill
 * @Oct 28, 2021
 */
public class TitlePage extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    StartAssignment start; //Pressing button "start" to start the game

    public TitlePage()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        initializeVarible();
        start = new StartAssignment();
        addObject(start, 785, 199); //The blue "Start Assignment" button on the screen

    }

    /**
     * Initialize all the static variables from each class while the user replays the game
     */
    public void initializeVarible()
    {
        GamePlay.current = 20;
        GamePlay.cursor_X = 295;
        GamePlay.currentAssignment = 1;
        GamePlay.level = 1;
        GamePlay.wifiBrokenTime = 0;
        
        Marks.currentMark = 0.0;
        Marks.totalMark = 0.0;
        Marks.numAssignFinished = 0;
        Marks.numAssignMissed = 0;
        
        Keyboard.word_X_Index = 300;
        Keyboard.numberOfPressingTime = 0;
        
        Keyboard.currWord = "";
        Keyboard.indexOfCurrentLetter = 0;
        
        
    }

}
