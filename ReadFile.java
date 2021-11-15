/*
 * -------------------------------------------------------------------------------
 * File name: ReadFile.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1260-003
 * Creation Date: 11/11/21
 * Last modified: 11/14/21
 * -------------------------------------------------------------------------------
 */
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Class Name: ReadFile<br>
 * Class Purpose:  load game from file, ready up player's character and map location<br>
 *
 * <hr>
 * Date created: 11/11/21<br>
 * Last modified: 11/13/21
 * @author Steven Caleb Rains
 */
public class ReadFile
{
    public static void LoadGame(Character player, HashMap<String, Location> map)
    {
        Character savedPlayer = player;
        HashMap<String, Location> savedMap = map;
       try
       {
           File savedFile = new File("saveFile.txt"); //opens the file to be read from
           Scanner saveReader = new Scanner(savedFile); // creates a Scanner to read from the file

           while (saveReader.hasNextLine()) //while there is another line, the reader will read the data and then print it
           {
               String saveData = saveReader.nextLine();
               System.out.println(saveData);
           }

           saveReader.close(); // close the save file
           System.out.println("Save loaded!");
       }
       catch (IOException notFound) // handles exception when save file is not found
       {
           System.out.println("Save data not found!");
       }
       //Print loaded data
       //System.out.println("Save data loaded: \n");
       //System.out.println("Player: " + savedPlayer + "\n");
       //System.out.println("Location: " + savedMap);
    }
}


