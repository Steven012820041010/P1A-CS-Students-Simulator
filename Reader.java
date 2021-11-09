import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Reader here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reader extends Actor
{
    /**
     * Act - do whatever the Reader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    static String url = "https://gist.githubusercontent.com/sirkets/7d89492826a0d245a086e8c5c56829a8/raw/307ef87315bf0360f682bf25821fdcf4fe71db8c/nouns.txt";
    GamePlay world;
    public ArrayList<String> read(int senLength, int ranDepth, int MAX_LENGTH, GamePlay world) throws Exception {
        ArrayList<String> list = new ArrayList<String>();

        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(wordsURL.openStream()));
        String word;
        int currLength = 0;
        while ((word = in.readLine()) != null)
        {
            list.add(word);
        }
        //System.out.println("Reader: " + list);
        in.close();

        ArrayList<String> out = new ArrayList<String>();
        Random rand = new Random();

        if (world.level >= 2){
            senLength--;
        }
        int numWords = 0;
        for (int i = 0; i < senLength; i++)
        {
            String curr = list.get(rand.nextInt(ranDepth));
            //System.out.println(curr);
            
            switch (senLength){
                case 2:
                if (currLength==0)
                {
                    if (curr.length() < MAX_LENGTH-1){
                        out.add(curr); //add a word with any length
                        currLength += curr.length();
                    }else{
                        i--;
                    }
                }
                else
                {
                    if (curr.length() + currLength == MAX_LENGTH)
                    {
                        out.add(curr);
                        //System.out.println("hi");

                        //currLength += curr.length();
                    }else{
                        i--;
                    }
                }
                break;

                case 3:
                
                System.out.println("Length: " + currLength);
                 System.out.println("MAX_Length: " + MAX_LENGTH);
                 System.out.println("numWOrds: " + numWords);
                
                if (numWords==0)
                {
                    if (curr.length() < MAX_LENGTH-5){
                        out.add(curr); //add a word with any length
                        currLength += curr.length();
                        numWords++;
                    }else{
                        i--;
                    }
                    //System.out.println("Curr: " + curr);

                }
                else
                {
                    if (numWords == 1)
                    {
                        //System.out.println("Here");
                        if (curr.length() + currLength < MAX_LENGTH-3)
                        {
                            out.add(curr);
                            numWords++;
                            //System.out.println("hi");

                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                    else if (numWords == 2)
                    {
                        if (curr.length() + currLength == MAX_LENGTH)
                        {
                            System.out.println("hi");
                            out.add(curr);
                            //numWords++;
                            //System.out.println("hi");

                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                }
                break;

                case 4:
                if (numWords==0)
                {
                    if (curr.length() < MAX_LENGTH-5){
                        out.add(curr); //add a word with any length
                        currLength += curr.length();
                        numWords++;
                    }else{
                        i--;
                    }
                    //System.out.println("Curr: " + curr);

                }
                else
                {
                    if (numWords == 1)
                    {
                        //System.out.println("Here");
                        if (curr.length() + currLength < MAX_LENGTH-3)
                        {
                            out.add(curr);
                            numWords++;
                            //System.out.println("hi");

                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                    else if (numWords == 2)
                    {
                        if (curr.length() + currLength < MAX_LENGTH-1)
                        {
                            out.add(curr);
                            numWords++;
                            //System.out.println("hi");

                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                    else if (numWords == 3)
                    {
                        if (curr.length() + currLength == MAX_LENGTH)
                        {
                            out.add(curr);
                            numWords++;
                            //System.out.println("hi");

                            //currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                }
                break;
              
            }

        }
        //System.out.println("Out: " + out);
        return out;
    }
}

