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

public class Monster extends Entity implements Damage
{
    protected MonsterType enemyType;

    public Monster(MonsterType enemyType, int hp, int def)
    {
        super(hp, def);
        this.enemyType = enemyType;
    }

    public String MonsterSpawn(Location location)
    {
        //This method will spawn monsters in a location upon location's creation.
        return "";
    }

    public MonsterType getEnemyType()
    {
        return enemyType;
    }

    public void setEnemyType(MonsterType enemyType)
    {
        this.enemyType = enemyType;
    }

    public int Attack()
    {
        return Dice.rollDiceTwenty();
    }
}//end class Monster
