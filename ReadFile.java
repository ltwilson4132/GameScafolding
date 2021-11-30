/*
 * -------------------------------------------------------------------------------
 * File name: ReadFile.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1260-003
 * Creation Date: 11/11/21
 * Last modified: 11/29/21
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
 * Last modified: 11/29/21
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
     */
    public static void LoadGame()
    {
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
     * @param locations
     */
    public static void readLocations(String path, ArrayList<Location> locations) throws FileNotFoundException
    {
        locations.clear();
        String locationEntry;

        // sets up myLocationReader to read a file from path
        try(BufferedReader myLocationReader = new BufferedReader(new FileReader(path)))
        {
            // while locationEntry is not null, the reader will read the line
            while((locationEntry = myLocationReader.readLine()) != null)
            {
                String[] locationInfo = locationEntry.split(","); //breaks up string by commas

                //sets location name at index 0, location description at index 1, and size at index 2
                Location location = new Location(locationInfo[0], locationInfo[1], Integer.parseInt(locationInfo[2]));

                locations.add(location); //adds location
            }
        }
        catch(IOException exc)
        {
            System.out.println("File not found!");
        }
    }

    /**
     * Method Name: readLocations <br>
     * Method Purpose: reads file SavedPlayer.txt and loads player information <br>
     *
     * <hr>
     * Date created: 11/29/21 <br>
     * Date last modified: 11/29/21 <br>
     * <hr>
     *
     * @param player
     * @param locations
     */
    public static void loadPlayer(ArrayList<Location> locations, Character player) //throws FileNotFoundException
    {
        String entry;
        try (BufferedReader playerReader = new BufferedReader(new FileReader("SavedPlayer.txt")))
        {
            entry = playerReader.readLine();
            String[] playerInfo = entry.split(","); //breaks up the String in file by commas
            player.setName(playerInfo[0]); //sets player name at index 0
            if(playerInfo[1].equals("Archer")) //sets player character type to Archer if player is Archer
            {
                player.setType(CharacterType.ARCHER);
            } else if(playerInfo[1].equals("Knight")) //sets player character type to Knight if player is Knight
            {
                player.setType(CharacterType.KNIGHT);
            } else // sets player character type to Wizard if not Archer or Knight
            {
                player.setType(CharacterType.WIZARD);
            }
            player.setHealth(Integer.parseInt(playerInfo[2])); //sets player health at index 2
            player.setDefense(Integer.parseInt(playerInfo[3])); //sets player defense at index 3
            for (Location location: locations) //loops through locations to get the location name that matches the file and sets that at index 4
            {
                if(location.getLocationName().equals(playerInfo[4]))
                {
                    player.setCurrentLocation(location);
                }
            }
            player.setAttackBoost(Integer.parseInt(playerInfo[5])); //takes attack boost and sets it at index 5
            player.setDefenseBoost(Integer.parseInt(playerInfo[6])); // takes defense boost and sets it at index 6

            // if we have no items length will be 7, if we have 1 item length will be 8,
            // if 2 items length will be 9, and if 3 items length will be 10
            for(int i = 7; i < playerInfo.length; i++)
            {
                if(playerInfo[i].equals("Healing Potion")) //if item at index is healing potion add it to inventory
                {
                    player.addToInventory("Healing Potion", ItemType.HEALING);
                } else if (playerInfo[i].equals("Attack Boost")) //if item at index is attack boost add it to inventory
                {
                    player.addToInventory("Attack Boost", ItemType.ATTACK_BOOST);
                } else if (playerInfo[i].equals("Defense Boost")) //if item at index is defense boost add it to inventory
                {
                    player.addToInventory("Defense Boost", ItemType.DEFENSE_BOOST);
                }
            }
        }
        catch (IOException exception) //prints a statement if save not loaded
        {
            System.out.println("Could not load the Player!");
        }
    }
}
