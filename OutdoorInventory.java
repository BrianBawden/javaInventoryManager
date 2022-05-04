
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class OutdoorInventory 

{//opening OutdoorInventory class
    public static String path = "C:\\Users\\brian\\BYU-I\\Spring 2022\\CSE 310\\W02\\javaInventoryManager\\outdoorSupplies.csv";

    private static Scanner sc; // set Scanner to sc.

    public static void main(String[] args)
    {//Start main
        addItem();
    }//end main

///////////////////////Methods/////////////////////


    //The addItem method is used to append new items to the list.
    static void addItem()
    {//Start addItem
        try
        {//Start try
            FileWriter addWriter = new FileWriter(path, true);

            addWriter.write("\n"); //start on next line of file
            System.out.println("Enter new item number: ");
            addWriter.write(userInput());
            System.out.println("Enter new item name: ");
            addWriter.write(userInput());
            System.out.println("Enter new item quantity: ");
            addWriter.write(userInput());
            System.out.println("Enter new item Price: ");
            addWriter.write(userInput());
            addWriter.close();
        }//End try
        catch(IOException exception)
        {//start catch
            exception.printStackTrace();
        }//end catch
    }//end addItem


    static String userInput()
    {//Start userInput
        Scanner userI = new Scanner(System.in);
        return userI.nextLine();
    }//End userInput
}//closing JavaInventoryManager class
