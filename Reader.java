import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Reader here.
 * 
 * @Bill Wei, Steven Zhu, Eric
 * @Nov 3, 2021
 */
public class Reader extends Actor
{
    /**
     * Act - do whatever the Reader wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    static String url = "https://gist.githubusercontent.com/sirkets/7d89492826a0d245a086e8c5c56829a8/raw/307ef87315bf0360f682bf25821fdcf4fe71db8c/nouns.txt";
    GamePlay world;

    /**
     * Get senLength numbers of word from range 0 to ranDepth. The total number of letters equal to maxLength
     */
    public ArrayList<String> read(int senLength, int ranDepth, int maxLength, GamePlay world) throws Exception {
        ArrayList<String> list = new ArrayList<String>();

        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(wordsURL.openStream()));
        String word;
        int currLength = 0; //record how many letters added
        while ((word = in.readLine()) != null)
        {
            list.add(word);
        }

        in.close();
        ArrayList<String> out = new ArrayList<String>();
        Random rand = new Random();

        //Level 1: 2 words
        //Level 2: 2 words
        //Level 3: 3 words
        //Level 4: 4 words
        if (world.level >= 2){
            senLength--;
        }
        int numWords = 0; // record the number of words added
        for (int i = 0; i < senLength; i++)
        {
            String curr = list.get(rand.nextInt(ranDepth));
            switch (senLength){
                //Level 1 and 2
                case 2:
                if (currLength==0)
                {
                    if (curr.length() < maxLength-1){ 
                        out.add(curr); //add a word with any length
                        currLength += curr.length(); //update
                    }else{
                        i--; //Not meet the requirement so check one more time
                    }
                }
                else
                {
                    if (curr.length() + currLength == maxLength)
                    {
                        out.add(curr);
                    }else{
                        i--;
                    }
                }
                break;

                //Level 3
                case 3:
                if (numWords==0)
                {
                    if (curr.length() < maxLength-5){
                        out.add(curr); //add a word with any length
                        currLength += curr.length(); //update
                        numWords++;
                    }else{
                        i--;
                    }
                }
                else
                {
                    if (numWords == 1)
                    {
                        if (curr.length() + currLength < maxLength-3)
                        {
                            out.add(curr);
                            numWords++;
                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                    else if (numWords == 2)
                    {
                        if (curr.length() + currLength == maxLength)
                        {

                            out.add(curr);
                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                }
                break;

                //Four words
                case 4:
                if (numWords==0)
                {
                    if (curr.length() < maxLength-5){
                        out.add(curr); //add a word with any length
                        currLength += curr.length();
                        numWords++;
                    }else{
                        i--;
                    }
                }
                else
                {
                    if (numWords == 1)
                    {
                        if (curr.length() + currLength < maxLength-3)
                        {
                            out.add(curr);
                            numWords++;
                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                    else if (numWords == 2)
                    {
                        if (curr.length() + currLength < maxLength-1)
                        {
                            out.add(curr);
                            numWords++;
                            currLength += curr.length();
                        }else{
                            i--;
                        }
                    }
                    else if (numWords == 3)
                    {
                        if (curr.length() + currLength == maxLength)
                        {
                            out.add(curr);
                            numWords++;

                        }else{
                            i--;
                        }
                    }
                }
                break;

            }

        }
        return out;
    }

}
