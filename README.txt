PROJECT TITLE: CS Student Simulator

PURPOSE OF PROJECT: This is a fun typing game made to test your typing speeds, designed to look like a scool assignment. 

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
Time expired and wrong submission will result a mark of 0 in this task.
On the right of the screen, there is a grader shows your current mark as the game going.
Also, you might encounter an "internet outage" when you are typing out your "assignment". In that case, just like school wifi in real life, you can't do much other than waiting for the internet to fix itself. 
If that happened, you don't have to do anything except for waiting.

Hope you enjoy this game, and this can help you somewhat understand our struggle as a student :) 
(just kidding)	


DATA STRUCTURES USED:

Notable examples:

Stack<Label> letters located in Keyboard class
- Stores user input, and stack data structure allows backspace to remove the last letter typed

Arraylist<String> list in Reader class
- The Reader class randomly fetches a specified amount of words, totalling a specified amount of characters from a URL containing words, and puts them into the arraylist. 
