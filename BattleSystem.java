public class BattleSystem //extends Dice Should not extend Dice. BattleSystem uses Dice.
{
    private String battleType;

    public String startBattle(Entity entity1, Entity entity2)
    {
        //Method that starts a battle between 2 entities
        return "";
    }

    public void Turn()
    {
        //Give player options for their turn. Heal or Attack.
    }

    public void Heal(Entity player)
    {
        //Will heal the player and/or use item.
    }

    public void Attack(Entity attacker, Entity defender)
    {
        //Roll twenty dice to decide attack power and then do damage to opposing entity.
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
