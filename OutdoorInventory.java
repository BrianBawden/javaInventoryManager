
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;

public class OutdoorInventory

{// opening OutdoorInventory class
    public static String path = "C:\\Users\\brian\\BYU-I\\Spring 2022\\CSE 310\\W02\\javaInventoryManager\\outdoorSupplies.csv";

    private static Scanner sc; // set Scanner to sc.

    public static void main(String[] args) {// Start main
        // addItem();
        printFile();
        searchFile();
    }// end main

    /////////////////////// Methods/////////////////////

    // The addItem method is used to append new items to the list.
    static void addItem() {// Start addItem
        try {// Start try
            FileWriter addWriter = new FileWriter(path, true);

            addWriter.write("\n"); // start on next line of file
            //The next few lins are used to get user input and append it to the file.
            System.out.println("Enter new item number: ");
            addWriter.write(userInput() + ", ");
            System.out.println("Enter new item name: ");
            addWriter.write(userInput() + ", ");
            System.out.println("Enter new item quantity: ");
            addWriter.write(userInput() + ", ");
            System.out.println("Enter new item Price: ");
            addWriter.write(userInput());
            addWriter.close();
        } // End try
        catch (IOException exception) {// start catch
            exception.printStackTrace();
        } // end catch
    }// end addItem

    // The printFile method is called when you want to print the file in path.
    static void printFile()
    {//start of printFile
        try{//start try catch
            File objFile = new File(path); //opens file saved in path
            Scanner objReader = new Scanner(objFile);//gives access to the objFile 
            while(objReader.hasNextLine())// iterates through objFile until the end of the file and prints out each line.
            {
                String data = objReader.nextLine();
                System.out.println(data);
            }
            objReader.close();
        } catch(FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }//end try catch
    }// end if printFile

    static void searchFile() 
    {
        String itemNu = "";
        String itemNa = "";
        String itemQu = "";
        String itemPr = "";
        boolean found = false;

        System.out.println("To search by:\n1 = Item Number\n2 = Item Name\n3 = Item Quantity\n4 = Item Price ");
        String userNum = userInput();
        System.out.println("Enter item to search for: ");
        String userSearch = userInput();

        try
        {
            sc = new Scanner(new File(path));
            sc.useDelimiter("[,\n]");

            while(sc.hasNext() && !found)
            {
                itemNu = sc.next();
                itemNa = sc.next();
                itemQu = sc.next();
                itemPr = sc.next();

                if (userNum == "1")
                {
                    if(itemNu.equals(userSearch))
                    {
                        found = true;
                        System.out.print(itemNu + itemNa + itemQu + itemPr);
                    }
                }
                else if (userNum == "2")
                {
                    if(itemNa.equals(userSearch))
                    {
                        found = true;
                        System.out.print(itemNu + itemNa + itemQu + itemPr);
                    }
                }
                else if (userNum == "3")
                {
                    if(itemQu.equals(userSearch))
                    {
                        found = true;
                        System.out.print(itemNu + itemNa + itemQu + itemPr);
                    }
                }
                else if (userNum == "4")
                {
                    if(itemPr.equals(userSearch))
                    {
                        found = true;
                        System.out.print(itemNu + itemNa + itemQu + itemPr);
                    }
                }
                else
                {
                    System.out.println("Invalid entry try again? ('y/n') ");
                    String searchAgain = userInput();
                    if(searchAgain == "y")
                    {
                        searchFile();
                    }
                    else
                    {
                        break;
                    }

                }
            }
        }
        catch (Exception e)
        {
            System.out.println("An error occurred while searching.");
        }
        
    }

    //userInput method is used to get string input from user.
    static String userInput() {// Start userInput
        Scanner userI = new Scanner(System.in);
        return userI.nextLine();
    }// End userInput
}// closing JavaInventoryManager class
