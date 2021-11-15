/*
 * -------------------------------------------------------------------------------
 * File name: Boss.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1260-003
 * Creation Date: 11/11/21
 * Last modified: 11/14/21
 * -------------------------------------------------------------------------------
 */
import java.util.ArrayList;

public class Boss extends Monster implements Damage
{
    public Boss(MonsterType enemyType, int hp, int def, ArrayList<Item> inventory)
    {
        super(enemyType, hp, def, inventory);
        //String bossName = "The Boss";
    }

    @Override
    public int Attack()
    {
        int damage;
        Character player = null;

        //Boss has stronger attacks, so DiceTwenty and DiceSix are rolled and added together
        // before subtracting player defense to return damage dealt
        damage = Dice.rollDiceTwenty() + Dice.rollDiceSix() - (player.defense);

        return damage;
    }

}