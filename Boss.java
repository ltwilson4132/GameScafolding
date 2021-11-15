/*
 * -------------------------------------------------------------------------------
 * File name: Boss.java
 * Project name: RNG Warriors Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Steven Caleb Rains rainss@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: 11/11/21
 * Last modified: 11/13/21
 * -------------------------------------------------------------------------------
 */
import java.util.ArrayList;

public class Boss extends Monster implements Damage
{
    public Boss(MonsterType enemyType, int health, int defense, ArrayList<Item> inventory)
    {
        super(enemyType, health, defense, inventory);
        String bossName = "The Boss";
    }

    @Override
    public void Attack(Character character)
    {
        int damage;
        //int additionalBossDamage;
        //int bossDamage;

        while (Character.health > 0)
        {
            //need to roll dice twenty and dice six, and add those values together
            // then subtract the player's defense from that for the damage dealt
            //damage dealt is then subtracted from the Character's health
            damage = (int)((rollDiceTwenty() + rollDiceSix()) - (character.defense));
            character.subtractHealth(damage);
            System.out.println("The Boss dealt " + damage + " damage!");
        }

    }

}