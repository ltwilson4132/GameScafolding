/*
 * -------------------------------------------------------------------------------
 * File name: Boss.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1260-003
 * Creation Date: 11/11/21
 * Last modified: 11/28/21
 * -------------------------------------------------------------------------------
 */
import java.util.ArrayList;

/*
 * Class Name: Boss<br>
 * Class Purpose:  Boss inherits from Monster and implements damage<br>
 *
 * <hr>
 * Date created: 11/11/21<br>
 * Last modified: 11/28/21
 * @author Steven Caleb Rains
 */
public class Boss extends Monster implements Damage
{

    /**
     * Method Name: Boss <br>
     * Method Purpose: Constructor for Boss that inherits from Monster <br>
     *
     * <hr>
     * Date created: 11/11/2021 <br>
     * Date last modified: 11/14/2021 <br>
     * <hr>
     *
     * @param enemyType
     * @param hp
     * @param def
     */
    public Boss(String enemyType, int hp, int def)
    {
        super(enemyType, hp, def);
    }

    /**
     * Method Name: Attack<br>
     * Method Purpose: boss attack <br>
     *
     * <hr>
     * Date created: 11/11/2021 <br>
     * Date last modified: 11/28/2021 <br>
     * <hr>
     *
     */
    @Override
    public int Attack()
    {
        //Boss has stronger attacks, so DiceTwenty and DiceSix are each rolled and added together
        int damage = Dice.rollDiceTwenty() + Dice.rollDiceSix();

        return damage;
    }

    /**
     * Method Name: setEnemyType<br>
     * Method Purpose: setterForEnemyType <br>
     *
     * <hr>
     * Date created: 11/8/2021 <br>
     * Date last modified: 11/18/2021 <br>
     * <hr>
     *
     */
    public void setEnemyType(String monsterType)
    {
        this.enemyType = enemyType;
    }

    /**
     * Method Name: getEnemyType<br>
     * Method Purpose: getter for EnemyType <br>
     *
     * <hr>
     * Date created: 11/18/2021 <br>
     * Date last modified: 11/18/2021 <br>
     * <hr>
     *
     */
    @Override
    public String getEnemyType()
    {
        return super.getEnemyType();
    }
}