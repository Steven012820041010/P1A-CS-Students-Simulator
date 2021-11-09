import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    
    BackToMain startAgain;
    Marks mark;
    Percentage percentage;
    
    static List<Double> highScores = new ArrayList<Double>();
    
    
    GamePlay gamePlay = new GamePlay();;
    String Mr_Chan_First_Comment;
    String Mr_Chan_Second_Comment;
    String Mr_Chan_Third_Comment;

    Label teacher_first_comment;
    Label teacher_second_comment;
    Label teacher_third_comment;

    Label finalMark;
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        mark = new Marks();
        
        percentage = new Percentage();
        startAgain = new BackToMain();
       
        finalComments();
        //gamePlay.displayMark();
       addObject(mark.currentMarks, 1077, 395);
        addObject(percentage, 1145, 395);
       addObject(mark.numberOfAssignmentsFinished, 1132, 447);
       addObject(mark.numberOfAssignmentsMissed, 1132, 500);
        
        //System.out.println("Final " + Marks.currentMark); 
        finalMark = new Label (String.valueOf(Marks.currentMark) + " ", 30);
        finalMark.setFillColor(greenfoot.Color.BLACK);
        addObject(finalMark, 280,176);
        addObject(startAgain, 785,199);
        
        
        
        teacher_first_comment = new Label (Mr_Chan_First_Comment, 21);
        teacher_second_comment = new Label (Mr_Chan_Second_Comment, 21);
        teacher_third_comment = new Label (Mr_Chan_Third_Comment, 21);

        teacher_first_comment.setFillColor(greenfoot.Color.GRAY);
        teacher_first_comment.setLineColor(greenfoot.Color.GRAY);
        teacher_second_comment.setFillColor(greenfoot.Color.GRAY);
        teacher_second_comment.setLineColor(greenfoot.Color.GRAY);
        teacher_third_comment.setFillColor(greenfoot.Color.GRAY);
        teacher_third_comment.setLineColor(greenfoot.Color.GRAY);

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
        //highScores.add(60.0);
        //highScores.add(5.0);
       // highScores.add(100.0);
       // highScores.add(70.0);
        //highScores.add(63.0);
        updateHighscore();
    }

    public void updateHighscore()
    {
       
        highScores.add(mark.currentMark);
        
        Collections.sort(highScores);
        Label [] high = new Label [5];
        int scoreX = 820; 
        int scoreY = 423;
        int index = 0;
        for (int i=1; i<=highScores.size(); i++)
        {
            Label num = new Label (i + ". ", 25);
            num.setFillColor(greenfoot.Color.BLACK);
            addObject(num, 770, 423+(i-1) * 39); 
        }
        
        
        for (int i=highScores.size()-1; i>=0; i--)
        {
            high[index] = new Label(String.valueOf(highScores.get(i)) + " ", 25);
            high[index].setFillColor(greenfoot.Color.BLACK);
            addObject(high[index], scoreX, scoreY);
            scoreY += 39;
            index++;
            
        }
    }
    
    
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
