/*
 * -------------------------------------------------------------------------------
 * File name: ReadFile.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: 11/11/21
 * Last modified: 11/13/21
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
    public static void LoadGame() throws IOException {
        Character savedPlayer = player;  // creating Character object to restore
        HashMap<String, Location> savedMap = map; // creating HashMap to restore
       try
       {
           FileInputStream saveFile = new FileInputStream("saveFile.txt"); //opens file to read from
           ObjectInputStream saveData = new ObjectInputStream(saveFile); // creates an ObjectInputStream to get objects from the save file

           savedPlayer = (Character) saveData.readObject(); //restoring Character object
           savedMap = (HashMap<String, Location>) saveData.readObject(); //restoring the map

           saveFile.close(); // close the save file
       }
       catch (FileNotFoundException | ClassNotFoundException notFound)
       {
           System.out.println("Save data not found!");
       }
       //Print loaded data
       System.out.println("Save data loaded: \n");
       System.out.println("Player: " + savedPlayer + "\n");
       System.out.println("Location: " + savedMap);
    }
}


