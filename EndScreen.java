import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class EndScreen here.
 * 
 * @Steven Zhu, Bill Wei
 * @Nov 8, 2021
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */

    BackToMain startAgain; //Button to main page
    Marks mark;
    Percentage percentage;

    static List<Double> highScores = new ArrayList<Double>(); //Stores the top 5 scores from the user

    //Based on the mark, teacher will give three comments
    String Mr_Chan_First_Comment;
    String Mr_Chan_Second_Comment;
    String Mr_Chan_Third_Comment;

    Label teacher_first_comment;
    Label teacher_second_comment;
    Label teacher_third_comment;

    Label finalMark; //Shows the final mark for this round
    public EndScreen()
    {    
        // Create a new world with 1280x720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        //Initialzing the Objects
        mark = new Marks();
        percentage = new Percentage();
        startAgain = new BackToMain();
        finalMark = new Label (String.valueOf(Marks.currentMark) + " ", 30);
        finalMark.setFillColor(greenfoot.Color.BLACK);

        finalComments(); //Shows the final comments from the teacher

        showTheFinalMark(); //Shows the final mark in percentage, number of assignments finished, and number of assignments late or miss

        //Display the teacher's comments on screen by converting them to labels
        teacher_first_comment = new Label (Mr_Chan_First_Comment, 21);
        teacher_second_comment = new Label (Mr_Chan_Second_Comment, 21);
        teacher_third_comment = new Label (Mr_Chan_Third_Comment, 21);

        //Set the color comments to gray
        teacher_first_comment.setFillColor(greenfoot.Color.GRAY);
        teacher_first_comment.setLineColor(greenfoot.Color.GRAY);
        teacher_second_comment.setFillColor(greenfoot.Color.GRAY);
        teacher_second_comment.setLineColor(greenfoot.Color.GRAY);
        teacher_third_comment.setFillColor(greenfoot.Color.GRAY);
        teacher_third_comment.setLineColor(greenfoot.Color.GRAY);

        displayComments();
        updateHighscore();
    }

    /**
     * Display the comments based on the different marks 
     */
    public void displayComments()
    {
        if (Marks.currentMark < 60)
        {
            addObject(teacher_first_comment, 405, 290);
            addObject(teacher_second_comment, 459, 330);
            addObject(teacher_third_comment, 442, 370);
        }
        else if (Marks.currentMark >= 60 && Marks.currentMark < 80)
        {
            addObject(teacher_first_comment, 443, 290);
            addObject(teacher_second_comment, 373, 330);
            addObject(teacher_third_comment, 395, 370);
        }
        else
        {
            addObject(teacher_first_comment, 318, 290);
            addObject(teacher_second_comment, 446, 330);
            addObject(teacher_third_comment, 485, 370);
        }
    }

    public void showTheFinalMark()
    {
        //Right-side
        addObject(mark.currentMarks, 1077, 395);
        addObject(percentage, 1145, 395);
        addObject(mark.numberOfAssignmentsFinished, 1132, 447);
        addObject(mark.numberOfAssignmentsMissed, 1132, 500);

        //Left-Top
        addObject(finalMark, 280,176);
        addObject(startAgain, 785,199);
    }

    /**
     * Keep updating highscores once user finishes one round
     */
    public void updateHighscore()
    {
        highScores.add(mark.currentMark); //Add the mark for this round

        Collections.sort(highScores); //Sort in ascending order
        Label [] high = new Label [5]; //Display
        int scoreX = 820; 
        int scoreY = 423;
        int index = 0;

        //Serial numbers
        for (int i=1; i<=highScores.size(); i++)
        {
            Label num = new Label (i + ". ", 25);
            num.setFillColor(greenfoot.Color.BLACK);
            addObject(num, 770, 423 + (i-1) * 39); 
        }

        //Display the highest scores from largest to lowest
        for (int i=0; i<highScores.size(); i++)
        {
            if (index > 5){
                break;
            }
            else
            {
                high[i] = new Label(String.valueOf(highScores.get(highScores.size()-i-1)) + " ", 25);
                high[i].setFillColor(greenfoot.Color.BLACK);
                addObject(high[i], scoreX, scoreY);
                scoreY += 39;
                index++;
            }

        }
    }

    /**
     * Set the values of label by putting the string
     */
    public void finalComments()
    {
        if (Marks.currentMark < 60)
        {
            Mr_Chan_First_Comment = "You still need to work on your typing speeds and accuracy! ";
            Mr_Chan_Second_Comment = "If you don't work on your typing, you will get overwelmed by the index ";
            Mr_Chan_Third_Comment = "out of bounds and null pointers and many other bugs very quickly! ";
        }
        else if (Marks.currentMark >= 60 && Marks.currentMark < 80)
        {
            Mr_Chan_First_Comment = "Not bad not bad, however if you want to become a true programmer ";
            Mr_Chan_Second_Comment= "you need to constantly improve your typing speeds. ";
            Mr_Chan_Third_Comment = "You never know when those bugs will get you, you know.";
        }
        else
        {
            Mr_Chan_First_Comment = "You did really good on this assignment. ";
            Mr_Chan_Second_Comment = "Even though you will inevitablly spend most of your time debugging ";
            Mr_Chan_Third_Comment = "literally any java program you write, at least you can spend less time to do it ";
        }
    }

}
