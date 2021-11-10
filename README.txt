PROJECT TITLE: CS Student Simulator

PURPOSE OF PROJECT: This is a fun typing game made to test your typing speeds, designed to look like a school assignment. 

VERSION or DATE: Version 2.1 @ November 19, 2021

HOW TO START THIS PROJECT: Open the greenfoot file, and click the run button at the bottom to start this game. Make sure it is pointed at the title screen. 

AUTHORS: @Bill Wei  @Steven Zhu  @Eric Chen

USER INSTRUCTIONS:

This game is a typing game, requiring you to try to type as fast as you can.
To start this game, click the Start Assignment blue button first. Then the first task will appear. 
The timer is on the right top corner, you have to complete the task before the time count down to 0.
There are 12 tasks in total, and the word length and time will change in each task as the game goes harder.  
For each task, you have to type the phase that appears on the screen.
You need to type the SPACE between Words.
After you finish typing the phase, you need to press ENTER button to submit. 
Time expiring and a wrong submission will result a mark of 0 in this task.
On the right of the screen, there is a grader shows your current mark as the game going.
Also, you might encounter an "internet outage" when you are typing out your "assignment". In that case, just like school wifi in real life, you can't do much other than waiting for the internet to fix itself. 

Hope you enjoy this game, and this can help you somewhat understand our struggle as a student :) 
(just kidding)	


DATA STRUCTURES USED:

Notable examples:

Stack<Label> letters located in Keyboard class
- Stores user input, and stack data structure allows backspace to remove the last letter typed

Arraylist<String> list in Reader class
- The Reader class randomly fetches a specified amount of words, totalling a specified amount of characters from a URL containing words, and puts them into the arraylist. 

List<double> highScores located in EndScreen class
- Stores the scores generated after each playthrough, and the list is sorted so it presents the highscores in the order of high to low.




FEATURES

Base game:
Reads items from an a word list URL and generates a list of words, that gets longer and has more words in total as the level increases
Detects user keyboard input, print the input on screen and compares it with the generated word list
Generate a set of underscores and print it on the screen to indicate to the user how many letters are left to type and where should the spaces be typed
Timer for each level
Keeping track of the number of passed levels and number of failed levels (late submission or typo)
Generates a "mark" based on user performance

Additions:
A "loading screen" that looks like a browser window trying to load a webpage
An "email notification" telling the user if the assignment is correct, wrong or late
Final screen that records user's high scores
A restart button on the final screen that allows the user to play again, while keeping track of the highscores
Display a different "teacher's comment" to the user based on the score at the end screen
There is a random chance that an "internet outage" would happen when the user is typing, which would display the "connection reset" screen for a few seconds before letting the user go back into the assignment again
