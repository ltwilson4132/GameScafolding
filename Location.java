/*
 * -------------------------------------------------------------------------------
 * File name: Location.java
 * Project name: Semester Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Logan Wilson wilsonlt@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Nov 12, 2021
 * Last modified: Logan Wilson wilsonlt@etsu.edu Nov 29, 2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Location<br>
 * Class Purpose:  The class is used to define a location object used in the game. Has name, description, size, and
 * an ArrayList of Monsters<br>
 *
 * <hr>
 * Date created: Nov 14, 2021<br>
 * Last modified: Nov 29, 2021
 * @author Logan Wilson
 */
import java.util.ArrayList;

public class Location
{
    private String locationName, locationDescription;
    final int size; //How many enemies it can hold. Final so that it won't change
    private ArrayList<Monster> monsters;

    public Location(String locationName, String locationDescription, int size)
    {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.size = size;
        monsters = new ArrayList<>(size);//Equals max size that location can hold

    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    public String getLocationDescription()
    {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription)
    {
        this.locationDescription = locationDescription;
    }

    public int getSize()
    {
        return size;
    }

    /*
     * Method Name: getMonsters<br>
     * Method Purpose: This method returns a string representing all the monsters in the monster ArrayList<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns String that represents all the monster in location
     */
    public String getMonsters()
    {
        String monsterList = "";
        for (Monster monster:monsters)
        {
            if(monster.isAlive())
            {
                monsterList += monster.getEnemyType() + "\n";
            }
        }
        return monsterList;
    }


    public ArrayList<Monster> getMonstersArray()
    {
        return monsters;
    }

    public void AddMonster(Monster monster)
    {
        //Adds a new monster to the location's ArrayList
        monsters.add(monster);
    }

    /*
     * Method Name: removeMonster<br>
     * Method Purpose: This method sets the monster passed in alive attribute to false.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param monster: the monster to change the alive attribute of.
     * @returns N/A
     */
    public void removeMonster(Monster monster)
    {
        //Sets a monsters Alive attribute to false
        monster.setAlive(false);
    }


    public void ClearMonsters()
    {
        monsters.clear();
    }
}
