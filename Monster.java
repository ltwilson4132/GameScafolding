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
    protected boolean alive;

    public Monster(String enemyType, int hp, int def)
    {
        super(hp, def);
        this.enemyType = enemyType;
        alive = true;
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

    public String Inventory()
    {
        String monsterItem = "";
        if (!cInventory.isEmpty())
        {
            for (String name : cInventory.keySet())
            {
                monsterItem += name;
            }
        }
        return monsterItem;
    }
    
    public boolean isAlive()
    {
        return alive;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }
}//end class Monster
