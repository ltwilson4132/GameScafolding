/*
 * -------------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Monster
 * -------------------------------------------------------------------------------
 * Author's name and email: Logan Wilson wilsonlt@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Oct 27, 2021
 * Last modified: Logan Wilson wilsonlt@etsu.edu Oct 27, 2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Monster<br>
 * Class Purpose:  <br>
 *
 * <hr>
 * Date created: Oct 27, 2021<br>
 * Last modified: Oct 27, 2021
 * @author Logan Wilson
 */

import java.util.ArrayList;

public class Monster extends Entity
{
    private String enemyType;

    public Monster(String enemyType, String entityType, int hp, int def, ArrayList<Item> inventory)
    {
        super(enemyType, hp, def, inventory);
        this.enemyType = enemyType;
    }

    public String MonsterSpawn(Location location)
    {
        //This method will spawn monsters in a location.
        return "";
    }
}//end class Monster
