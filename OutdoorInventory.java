
import java.util.Scanner;
import java.io.File;  
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


public class OutdoorInventory

{// opening OutdoorInventory class
    public static String path = "C:\\Users\\brian\\BYU-I\\Spring 2022\\CSE 310\\W02\\javaInventoryManager\\outdoorSupplies.csv";

    private static Scanner sc; // set Scanner to sc.

    public static void main(String[] args) {// Start main
        printFile();
        addItem();
        searchFileItemNum();
        editFile();
    }// end main

    /////////////////////// Methods/////////////////////

    // The addItem method is used to append new items to the list.
    static void addItem() {// Start addItem

        String tempFile = "C:\\Users\\brian\\BYU-I\\Spring 2022\\CSE 310\\W02\\javaInventoryManager\\addTemp.csv;";//A temp file is used to copy the old info to except for the info to be edited then continues copying the file until the end
        File oldFile = new File(path);//designate path for the file to read from and to be replaced.
        File newFile = new File(tempFile);// new file that will replace old file after copying information and replacing desired info
        String itemNu = "";//Starting blank variable for future use.
        String itemNa = "";//Starting blank variable for future use.
        String itemQu = "";//Starting blank variable for future use.
        String itemPr = "";//Starting blank variable for future use.
        System.out.println("Enter new item number: ");
        String newNum = userInput();
        System.out.println("Enter new item name: ");
        String newNam = userInput();
        System.out.println("Enter new item quantity: ");
        String newQua = userInput();
        System.out.println("Enter new item price: ");
        String newPri = userInput();

        try {// Start try
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            sc = new Scanner(new File(path));
            sc.useDelimiter("[,\n]");
           
            while(sc.hasNext())
            {
                itemNu = sc.next();
                itemNa = sc.next();
                itemQu = sc.next();
                itemPr = sc.next();
                pw.print(itemNu + "," + itemNa + "," + itemQu + "," + itemPr + "\n");
            }
            pw.print(newNum + "," + newNam + "," + newQua + "," + newPri + "\n");
            sc.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(path);
            newFile.renameTo(dump);
            newFile.delete();
    
        } // End try
        catch (IOException exception) {// start catch
            exception.printStackTrace();
        } // end catch
    }// end addItem

    // The printFile method is called when you want to print the file.
    static void printFile()
    {//start of printFile
        try{//start try catch
            File objFile = new File(path); //opens file saved in path
            Scanner objReader = new Scanner(objFile);//Provides methods to interact with objFile.
            while(objReader.hasNextLine())// iterates through objFile until the end of the file and prints out each line.
            {
                String data = objReader.nextLine();
                System.out.println(data);
            }
            objReader.close();
        } catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
            e.printStackTrace();
        }//end try catch
    }// end if printFile

    //The searchFileItemNum method is used to print out the specific information searched for based on the item number.
    static void searchFileItemNum() 
    {
        //The following variables are set to black because at this point in the method the file has not started searching yet.
        String itemNu = "";
        String itemNa = "";
        String itemQu = "";
        String itemPr = "";
        boolean found = false;//found will change to true when the item searched for is found.

        printFile();
        System.out.println("Enter item number to search for: ");
        String userSearch = userInput();

        try
        {
            sc = new Scanner(new File(path));// sets sc to the file being searched 
            sc.useDelimiter("[,\n]");//both , and \n are used ad delimiters because the items are seperated by ,'s and new lines.

                while(sc.hasNext() && !found)//The file is searched until the end or if found is changed to true.
                {
                    itemNu = sc.next();//These variables check the next item in the list.
                    itemNa = sc.next();//These variables check the next item in the list.
                    itemQu = sc.next();//These variables check the next item in the list.
                    itemPr = sc.next();//These variables check the next item in the list.
                
                    if(itemNu.equals(userSearch))//if the itemNu matches what the user is searching for the following is executed and the method will end.
                    {
                        found = true;
                        System.out.println(itemNu + "," + itemNa + "," + itemQu + "," + itemPr);
                    }
                }
        }
        catch (Exception e)
        {
            System.out.println("Search file failed.");
            e.printStackTrace();

        }
        
    }

    static void editFile()//editFile is used by entering the item number to be edited and new information replaces the old information
    {
        printFile();// this call to printFile shows the data in the file so the user can see the info to edit.

        String tempFile = "C:\\Users\\brian\\BYU-I\\Spring 2022\\CSE 310\\W02\\javaInventoryManager\\editTemp.csv;";//A temp file is used to copy the old info to except for the info to be edited then continues copying the file until the end
        File oldFile = new File(path);//designate path for the file to read from and to be replaced.
        File newFile = new File(tempFile);// new file that will replace old file after copying information and replacing desired info
        String itemNu = "";//Starting blank variable for future use.
        String itemNa = "";//Starting blank variable for future use.
        String itemQu = "";//Starting blank variable for future use.
        String itemPr = "";//Starting blank variable for future use.

        System.out.println("Enter the item number to edit: ");
        String editNum = userInput();
        System.out.println("Enter new item number: ");
        String newNum = userInput();
        System.out.println("Enter new item name: ");
        String newNam = userInput();
        System.out.println("Enter new item quantity: ");
        String newQua = userInput();
        System.out.println("Enter new item price: ");
        String newPri = userInput();

        try
        {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            sc = new Scanner(new File(path));
            sc.useDelimiter("[,\n]");


            while(sc.hasNext())
            {
                itemNu = sc.next();
                itemNa = sc.next();
                itemQu = sc.next();
                itemPr = sc.next();
                if(itemNu.equals(editNum))
                {
                   pw.print(newNum + "," + newNam + "," + newQua + "," + newPri + "\n");
                }
                else
                {
                    pw.print(itemNu + "," + itemNa + "," + itemQu + "," + itemPr + "\n");
                }
            }
            sc.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(path);
            newFile.renameTo(dump);
            newFile.delete();
    
          }
          catch(Exception e)
          {
            System.out.println("Error editing record.");
            e.printStackTrace();


        }

    }

    //userInput method is used to get string input from user.
    static String userInput() {// Start userInput
        Scanner userI = new Scanner(System.in);
        return userI.nextLine();
    }// End userInput
}// closing JavaInventoryManager class
