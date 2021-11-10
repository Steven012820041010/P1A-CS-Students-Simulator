import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Keyboard here.
 * 
 * @Steven Zhu, Bill wei
 * @Version Oct 28, 2021
 */
public class Keyboard extends Actor
{
    /**
     * Act - do whatever the Keyboard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    SimpleTimer timer = new SimpleTimer();
    SimpleTimer removeTimer = new SimpleTimer();

    GamePlay world;
    static int word_X_Index = 300;
    int word_Y_Index = 350;

    //int numOfSpace = 0;

    Stack<Label> letters = new Stack<Label>(); // store user's input
    Queue<Integer> mistakeLetter = new LinkedList<Integer>(); // store

    static String currWord = ""; //record the letters the user typed
    static int indexOfCurrentLetter = 0; // record the index of current letter
   

    GreenfootSound keyboardSound = new GreenfootSound("KBClick.wav");

    static int numberOfPressingTime = 0; // record number of time user that presses the keyboard

    public Keyboard(){
        world = (GamePlay)getWorld();

    }

    public void act() 
    {

    }   

    public void setWordX(GamePlay world)
    {
        switch (world.level)
        {
            case 1:
            word_X_Index = 300;
            break;

            case 2:
            word_X_Index = 270;
            break;

            case 3:
            word_X_Index = 235;
            break;

            case 4:
            word_X_Index = 185;
            break;

        }

    }

    public void type(GamePlay world, String str)
    {   

        if (timer.millisElapsed()>30)
        {
            timer.mark();
            
            int num = world.level >= 3 ? world.level - 2 : 0;
            if (numberOfPressingTime <= world.lettersSize[world.level] + num)
            {
                keyboardSound.play();
                //keyboardSound.play();
                Label label = new Label(str, 25);
                letters.add(label);
                if (checkCorrectSpelling(world, str) && mistakeLetter.isEmpty())
                {
                    label.setFillColor(greenfoot.Color.BLACK);

                }
                else
                {
                    label.setFillColor(greenfoot.Color.RED);
                    mistakeLetter.add(indexOfCurrentLetter);
                }
                numberOfPressingTime++;

                currWord += str;
                world.cursor_X += 20;
                //label.setFillColor(greenfoot.Color.BLACK);
                indexOfCurrentLetter++;
                world.addObject(label, word_X_Index, word_Y_Index);
                word_X_Index += 20;
                
                
            }

        }

    }

    public void remove(GamePlay world)
    {
        if (removeTimer.millisElapsed()>60){
            if (!letters.isEmpty()){

                world.removeObject(letters.pop());
                currWord = currWord.substring(0, currWord.length()-1);
                word_X_Index -= 20;
                indexOfCurrentLetter--;
                world.cursor_X-=20;
                numberOfPressingTime--;

                if (!mistakeLetter.isEmpty())
                {
                    mistakeLetter.poll();
                }
            }
            //System.out.println(word_X_Index);
        }
        removeTimer.mark();
    }


    public boolean checkCorrectSpelling(GamePlay world, String str)
    {
        //System.out.println(str.charAt(0) == world.ansKey.charAt(indexOfCurrentLetter));
        return str.charAt(0) == world.ansKey.charAt(indexOfCurrentLetter);
    }
}
