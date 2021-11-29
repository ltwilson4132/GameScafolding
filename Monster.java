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
    protected int attackBoost;
    protected int defenseBoost;
    protected ItemType item;

    public Monster(String enemyType, int hp, int def)
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

    @Override
    //take out where it's expecting a character called player in the use item
    public void UseItem (ItemType item)
    {

    }

    @Override
    public void addToInventory (String name, ItemType item)
    {
        cInventory.put(name, item);
    }

    @Override
    public ItemType dropFromInventory(String name)
    {
        ItemType item;
        item = cInventory.get(name);
        cInventory.remove(item);
        return item;
    }
}//end class Monster
