/*
 * -------------------------------------------------------------------------------
 * File name: ReadFile.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1260-003
 * Creation Date: 11/11/21
 * Last modified: 11/13/21
 * -------------------------------------------------------------------------------
 */
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

/*
 * Class Name: ReadFile<br>
 * Class Purpose:  load game from file, ready up player's character and map location<br>
 *
 * <hr>
 * Date created: 11/11/21<br>
 * Last modified: 11/14/21
 * @author Steven Caleb Rains
 */
public class ReadFile
{
    /**
     * Method Name: LoadGame <br>
     * Method Purpose: read a file containing save information and load that information (load save) <br>
     *
     * <hr>
     * Date created: 11/11/2021 <br>
     * Date last modified: 11/14/2021 <br>
     * <hr>
     *
     * @param player
     * @param map
     */
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

    /**
     * Method Name: readLocations <br>
     * Method Purpose: reads file from given path and puts sets the location name and location description
     * into array list and closes when finished<br>
     *
     * <hr>
     * Date created: 11/22/21 <br>
     * Date last modified: 11/22/21 <br>
     * <hr>
     *
     * @param path
     * @throws FileNotFoundException
     */
    public static void readLocations(String path, ArrayList<Location> locations) throws FileNotFoundException
    {
        String locationEntry;

        try(BufferedReader myLocationReader = new BufferedReader(new FileReader(path)))
        {
                while((locationEntry = myLocationReader.readLine()) != null)
                {
                    String[] locationInfo = locationEntry.split(",");

                    Location location = new Location(locationInfo[0], locationInfo[1], Integer.parseInt(locationInfo[2]));

                    locations.add(location);
                }//end while
        }//end try
        catch(IOException exc)
        {
            System.out.println("File not found!");
        }

        return locations;
    }
}


