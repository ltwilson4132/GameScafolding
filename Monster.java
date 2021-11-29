import java.util.ArrayList;
/*
 * -------------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Monster
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: 10/27/21
 * Last modified: 11/28/21
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
    private int attackBoost;
    private int defenseBoost;
    private ItemType item;

    /**
     * Method Name: Monster <br>
     * Method Purpose: Constructor for Monster that inherits from Entity <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     * @param enemyType
     * @param hp
     * @param def
     * @param inventory
     */
    public Monster(String enemyType, int hp, int def, ArrayList<Item> inventory) //constructor that calls the super
    {
        super(hp, def);
        this.enemyType = enemyType;
    }

    /**
     * Method Name: getEnemyType <br>
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
     * Method Name: setEnemyType <br>
     * Method Purpose: setter for EnemyType <br>
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
     * Method Name: Attack <br>
     * Method Purpose: Attack method for monster, rolls a dice twenty<br>
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
     * Method Purpose: adds item to inventory <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     * @param name
     * @param item
     */
    public void addToInventory (String name, Item item)
    {
        cInventory.put(name, item);
    }

    /**
     * Method Name: dropFromInventory<br>
     * Method Purpose: drops item from inventory <br>
     *
     * <hr>
     * Date created: 11/27/2021 <br>
     * Date last modified: 11/27/2021 <br>
     * <hr>
     *
     * @param name
     */
    public Item dropFromInventory(String name)
    {
        Item item;
        item = cInventory.get(name);
        cInventory.remove(item);
        return item;
    }

}//end class Monster