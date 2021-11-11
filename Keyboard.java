import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Keyboard here.
 * 
 * @Steven Zhu, Bill wei, Eric Chen
 * @Version Oct 28, 2021
 */
public class Keyboard extends Actor
{
    /**
     * Act - do whatever the Keyboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound keyboardSound = new GreenfootSound("KBClick.mp3");
    SimpleTimer timer = new SimpleTimer(); // control the typing speed
    SimpleTimer removeTimer = new SimpleTimer();

    GamePlay world;
    static int word_X_Index = 300;
    static int word_Y_Index = 350;
    static int indexOfCurrentLetter = 0; // record the index of current letter
    static int numberOfPressingTime = 0; // record number of time user that presses the keyboard
    static String currWord = ""; //record the letters the user typed

    int numOfMistakeLetters = 0; // record the numbers of mistake letter
    Stack<Label> letters = new Stack<Label>(); // store user's input

    /**
     * Set the word index based on different level
     */
    public void setWordX(GamePlay world)
    {
        switch (world.level)
        {
            case 1:
            word_X_Index = 280;
            break;

            case 2:
            word_X_Index = 250;
            break;

            case 3:
            word_X_Index = 215;
            break;

            case 4:
            word_X_Index = 165;
            break;

        }

    }

    public int numOfSpace()
    {
        //Level 1: 1 space
        //Level 2: 1 space
        //Level 3: 2 sapce
        //Level 4: 3 space
        return world.level >= 3 ? world.level - 2 : 0;
    }

    /**
     * Receive a input from user and display on the screen
     */
    public void type(GamePlay world, String str)
    {   
        if (timer.millisElapsed()>30)
        {
            keyboardSound.play();
            timer.mark();
            int numberOfSpace = numOfSpace();
            if (numberOfPressingTime <= world.lettersSize[world.level] + numberOfSpace)
            {
                
                Label currentLetter = new Label(str, 25); //Set the current letter into a label
                letters.add(currentLetter);
                if (checkCorrectSpelling(world, str) && numOfMistakeLetters == 0)
                {
                    currentLetter.setFillColor(greenfoot.Color.BLACK);
                }
                else
                {
                    currentLetter.setFillColor(greenfoot.Color.RED);
                    numOfMistakeLetters++; //Because user has a wrong input from the previous
                }
                increaseTheIndexAndVariable(str);
                world.addObject(currentLetter, word_X_Index, word_Y_Index);
            }
        }
    }

    /**
     * Remove the previous letter while user presses backspace
     */
    public void remove(GamePlay world)
    {
        if (removeTimer.millisElapsed()>60){
            if (!letters.isEmpty()){ //Check if there's letter in stack that can be removed
                world.removeObject(letters.pop());//remove the letter
                decreaseTheIndexAndVariable();
            }
        }
        removeTimer.mark();
    }

    public void increaseTheIndexAndVariable(String str)
    {
        currWord += str;
        word_X_Index += 20;
        world.cursor_X += 20;
        indexOfCurrentLetter++;
        numberOfPressingTime++;

    }

    public void decreaseTheIndexAndVariable()
    {
        currWord = currWord.substring(0, currWord.length()-1); //remove the last letter from the user's input
        word_X_Index -= 20;
        world.cursor_X-=20;
        indexOfCurrentLetter--;
        numberOfPressingTime--;
        if (numOfMistakeLetters > 0)
        {
            numOfMistakeLetters--;
        }
    }

    /**
     * Check if the input letter matches the current letter of ans key
     */
    public boolean checkCorrectSpelling(GamePlay world, String str)
    {
        return str.charAt(0) == world.ansKey.charAt(indexOfCurrentLetter);
    }
}
