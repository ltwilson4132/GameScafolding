import java.util.ArrayList;
/*
 * -------------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Monster
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: 10/27/21
 * Last modified: 11/29/21
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Monster<br>
 * Class Purpose:  <br>
 *
 * <hr>
 * Date created: 11/27/21<br>
 * Last modified: 11/27/21
 * @author S Caleb Rains
 */
public class Monster extends Entity implements Damage
{
    protected String enemyType;
    protected int attackBoost;
    protected int defenseBoost;
    protected ItemType item;

    /**
     * Method Name: Monster<br>
     * Method Purpose: constructor for Monster, parent class Entity <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     * @param enemyType
     * @param hp
     * @param def
     */
    public Monster(String enemyType, int hp, int def)
    {
        super(hp, def);
        this.enemyType = enemyType;
    }

    /**
     * Method Name: getEnemyType<br>
     * Method Purpose: getter for enemy type <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     */
    public String getEnemyType()
    {
        return enemyType;
    }

    /**
     * Method Name: setEnemyType<br>
     * Method Purpose: setter for enemy type <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     * @param enemyType
     */
    public void setEnemyType(String enemyType)
    {
        this.enemyType = enemyType;
    }

    /**
     * Method Name: Attack<br>
     * Method Purpose: monster attack method <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     */
    public int Attack()
    {
        return Dice.rollDiceTwenty();
    }

    /**
     * Method Name: addToInventory<br>
     * Method Purpose: adds item to monster's inventory <br>
     *
     * <hr>
     * Date created: 11/11/2021 <br>
     * Date last modified: 11/28/2021 <br>
     * <hr>
     *
     */
    @Override
    public void addToInventory (String name, ItemType item)
    {
        cInventory.put(name, item);
    }

    /**
     * Method Name: dropFromInventory<br>
     * Method Purpose:  drops item from monster's inventory<br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     * @param name
     */
    @Override
    public ItemType dropFromInventory(String name)
    {
        ItemType item;
        item = cInventory.get(name);
        cInventory.remove(item);
        return item;
    }

    /**
     * Method Name: Inventory<br>
     * Method Purpose: gives monster an item in inventory <br>
     *
     * <hr>
     * Date created: 11/29/2021 <br>
     * Date last modified: 11/29/2021 <br>
     * <hr>
     *
     */
    public String Inventory()
    {
        String monsterItem = ""; //initializing monsterItem
        if (!cInventory.isEmpty()) //if the monster has an item it returns an item, if it has no item it returns a null
        {
            for (String name : cInventory.keySet()) //takes all the keys from the inventory hashmap and puts them in a set and goes through every item in the set and adds it to monsterItem
            {
                monsterItem += name;
            }
        }
        return monsterItem;
    }
}
