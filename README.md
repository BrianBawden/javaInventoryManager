# Overview

A program I wrote to keep track of a pretend camping supply store to practice learning Java. I wanted to be able to access a .CSV file, read, add to, edit, and search the file to simulate a company keeping track of their inventory. 

I wrote this program using Java with VScode as my IDE. The imports I used to allow me to work with the .CSV file are:
* import java.io.FileWriter;
* import java.io.IOException;
* import java.util.Scanner;
* import java.io.BufferedWriter;
* import java.io.File;  
* import java.io.FileNotFoundException;
* import java.io.PrintWriter;

First I wrote a method to add items to the .CSV file. The file takes user input and stores them to variables. At first I tried just appending the new items to the .CSV file but later had problems working with the edit method so I changed to coping the old file to a temp file, adding the new item to the temp file, delete the old file, rename the temp to the same as the old file, and deleting the temp file. I followed a similar idea with the edit method.

To search the .CSV file I used a while loop and Scanner.next method until the item number searched for was found at which point that item number was printed or the the file ended. 

I also noticed I was writing the same code several times to get user input so I wrote a quick method that would return user input. 

[Software Demo Video](https://youtu.be/vWE0ewMQZgw)


# Useful Websites


* [CodeCadamy Java tutorial](https://www.codecademy.com/courses/learn-java/lessons/hello-world-java/exercises/introduction-to-java)
* [W3schools Java tutorial](https://www.w3schools.com/java/default.asp)
* [Edit CSV file YouTube](https://www.youtube.com/watch?v=TpyRKom0X_s)
 
# Future Work
A few things that I would like to add
* A delete method
* The ability to search by all fields not just item number
* The ability to edit a specific field only not the whole row
* An alert when ever an items quantity falls below a set value
