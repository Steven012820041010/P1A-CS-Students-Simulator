import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Marks here.
 * 
 * @Steven Zhu, Bill Wei, Eric Chen
 * @Nov 8, 2021
 */
public class Marks extends Actor
{
    /**
     * Act - do whatever the Marks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static double currentMark = 0.0; //record the current mark show on the screen
    static double totalMark = 0.0; // record the total mark
    static int numAssignFinished = 0; // record the number of assignment that is correct
    static int numAssignMissed = 0; // record the number of assignment that is late or wrong

    //Correspond to the top, Show on screen
    Label currentMarks = new Label (String.valueOf(currentMark), 39); 
    Label numberOfAssignmentsFinished = new Label(numAssignFinished, 28);
    Label numberOfAssignmentsMissed = new Label(numAssignMissed, 28);

    GamePlay world; 
    public void update(GamePlay world)
    {
        if(world.nextLevelChoice == 0 || world.nextLevelChoice == 1)
        {
            numAssignMissed++; 
            currentMark = totalMark / (numAssignMissed+numAssignFinished);
            round();
            currentMarks.setValue(String.valueOf(currentMark));
            numberOfAssignmentsMissed.setValue(numAssignMissed); //Update the number of assignments that is missed or wrong
        }
        else if (world.nextLevelChoice == 2)
        {
            numAssignFinished++;
            totalMark += 100.0;
            currentMark = totalMark / (numAssignMissed+numAssignFinished);
            round();
            currentMarks.setValue(String.valueOf(currentMark));
            numberOfAssignmentsFinished.setValue(numAssignFinished); //Update the number of assignments that is correct
        }
    }

    /**
     * Round the current mark to one decimal place
     */
    public void round()
    {
        currentMark = Math.round(currentMark * 10.0) / 10.0;
    }

}
