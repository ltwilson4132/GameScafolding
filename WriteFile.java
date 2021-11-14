/*
 * -------------------------------------------------------------------------------
 * File name: WriteFile.java
 * Project name: WriteFile
 * -------------------------------------------------------------------------------
 * Author's name and email: Alex Byars byarss1@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Nov 05, 2021
 * Last modified: Alex Byars 11/14/2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: WriteFile<br>
 * Class Purpose:  <br>
 *
 * <hr>
 * Date created: Nov 05, 2021<br>
 * Last modified: Nov 05, 2021
 * @author Alex Byars
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WriteFile
{
    public static void SaveGame(Character player, HashMap<String, Location> map)
    {
        //Writes the info of the player's character and the map to a text file to save the game.
        try {
            FileWriter savePlayer = new FileWriter("saveFile.txt");
            savePlayer.write(String.valueOf(player));
            savePlayer.write(String.valueOf(map));
            savePlayer.close();
            System.out.println("Game Saved");
        } catch (IOException e) {
            System.out.println("Could Not Save Game");
            e.printStackTrace();
        }
    }
}//end class WriteFile
