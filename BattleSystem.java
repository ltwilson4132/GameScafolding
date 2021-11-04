public class BattleSystem //extends Dice Should not extend Dice. BattleSystem uses Dice.
{
    //private String battleType;

    public static String startBattle(Character player, Monster enemy)
    {
        //Method that starts a battle between 2 entities
        //Check to see if either entity is dead.
        //While neither entity is dead do battle.
        //If there are no more enemies move character to the next location
        //Outputs string that says the results of the battle.
        return "";
    }

    public void Turn()
    {
        //Give player options for their turn. Use item or attack enemy. To be used by the character/player
    }

    public void UseItem(Entity player)
    {
        //Will let the player see what items they have and then give them the chance to use an item.
        //Apply effects of item and then remove item from inventory.
    }

    public void Attack(Entity attacker, Entity defender)
    {
        //Roll twenty dice to decide attack power, take attack power minus defenders defense and take that amount of health from the defender.
    }

    /*
    public String endBattle(Entity entity1, Entity entity2)
    {
        //Method that ends a battle between 2 entities
        return "";
    }

    public Boolean gameOver()
    {
        //Method that tells if the game is over or not
        return false;
    }
    */
}//end class BattleSystem
