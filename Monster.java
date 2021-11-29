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

    public Monster(String enemyType, int hp, int def, ArrayList<Item> inventory)
    {
        super(hp, def);
        this.enemyType = enemyType;
    }

    public String getEnemyType()
    {
        return enemyType;
    }

    public void setEnemyType(String enemyType)
    {
        this.enemyType = enemyType;
    }

    public int Attack()
    {
        return Dice.rollDiceTwenty();
    }

    //take out where it's expecting a character called player in the use item
    public void useItem (String name)
    {
        if (item == ItemType.HEALING)
        {
            this.health = this.health + 20;
        } else if (item == ItemType.ATTACK_BOOST)
        {
            this.attackBoost = this.attackBoost + 2;
        } else
        {
            this.defenseBoost = this.defenseBoost +2;
        }
        cInventory.remove(item);
    }

    /**
     * Method Name: addToInventory<br>
     * Method Purpose: adds item to inventory <br>
     *
     * <hr>
     * Date created: 11/18/2021 <br>
     * Date last modified: 11/28/2021 <br>
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
     * Date created: 11/18/2021 <br>
     * Date last modified: 11/28/2021 <br>
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