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
     *
     */
    public static void readLocations(String path, ArrayList<Location> locations) throws FileNotFoundException
    {
        locations.clear();
        //ArrayList<Location> locations = new ArrayList<>();
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
    }

    public static void loadPlayer(ArrayList<Location> locations, Character player) //throws FileNotFoundException
    {
        String entry;
        try (BufferedReader playerReader = new BufferedReader(new FileReader("SavedPlayer.txt")))
        {
            entry = playerReader.readLine();
            String[] playerInfo = entry.split(",");
            player.setName(playerInfo[0]);
            if(playerInfo[1].equals("Archer")) //sets character type to Archer if player is Archer
            {
                player.setType(CharacterType.ARCHER);
            } else if(playerInfo[1].equals("Knight")) //sets character type to Knight if player is Knight
            {
                player.setType(CharacterType.KNIGHT);
            } else // sets character type to Wizard if not Archer or Knight
            {
                player.setType(CharacterType.WIZARD);
            }
            player.setHealth(Integer.parseInt(playerInfo[2]));
            player.setDefense(Integer.parseInt(playerInfo[3]));
            for (Location location: locations)
            {
                if(location.getLocationName().equals(playerInfo[4])){
                    player.setCurrentLocation(location);
                }
            }
            player.setAttackBoost(Integer.parseInt(playerInfo[5]));
            player.setDefenseBoost(Integer.parseInt(playerInfo[6]));
            for(int i = 7; i < playerInfo.length; i++) // if we have no items length will be 7, if we have 1 item length will be 8, if 2 items length will be 9, and if 3 items length will be 10
            {
                if(playerInfo[i].equals("Healing Potion"))
                {
                    player.addToInventory("Healing Potion", ItemType.HEALING);
                } else if (playerInfo[i].equals("Attack Boost"))
                {
                    player.addToInventory("Attack Boost", ItemType.ATTACK_BOOST);
                } else if (playerInfo[i].equals("Defense Boost"))
                {
                    player.addToInventory("Defense Boost", ItemType.DEFENSE_BOOST);
                }
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
