import java.util.Locale;
import java.util.Scanner;

public class BattleSystem //extends Dice Should not extend Dice. BattleSystem uses Dice.
{
    //private String battleType;
    Scanner kb = new Scanner(System.in);
    String winnerText = "";
    public String startBattle(Character player, Monster enemy)
    {
        //Method that starts a battle between 2 entities
        while(player.health > 0 || enemy.health > 0)
        {
            testDeath(player, enemy);
            Turn(player, enemy);
            testDeath(player, enemy);
            Attack(enemy, player);
        }
        //Check to see if either entity is dead.
        //While neither entity is dead do battle.
        //If there are no more enemies move character to the next location
        //Outputs string that says the results of the battle.
        return winnerText;
    }

    public void testDeath(Character player, Monster enemy)
    {
        if(player.health == 0)
        {
            player.Respawn(player);
            winnerText = "The winner is: " + enemy;
        }
        else if(enemy.health == 0)
        {
            /* player. location.size - 1?*/;
            winnerText = "The winner is: " + player;
        }
    }

    public void Turn(Character player, Monster enemy)
    {
        int testVar = 0;
        System.out.println("What would you like to do?");
        System.out.printf("1. Attack");
        System.out.println("2. Inventory");
        testVar = kb.nextInt();
        while(testVar != 1 || testVar != 2)
        {
            System.out.println("Please enter a valid choice");
            testVar = kb.nextInt();
        }
        if (testVar == 1)
        {
            Attack(player, enemy);
        } else if(testVar == 2)
        {
            System.out.println("Please select an item:");
            for (String name:player.cInventory.keySet()) {
                System.out.println(name);
            }
            String userInput = kb.nextLine().toLowerCase();
            if (player.cInventory.get(userInput) != null) { // checks against null, if not null, will work
                player.UseItem(player, player.cInventory.get(userInput));
            }
        }
    }

    public void Attack(Entity attacker, Entity defender)
    {
        //Roll twenty dice to decide attack power, take attack power minus defenders defense and take that amount of health from the defender.
        Dice d20 = new Dice();

        int testDice = d20.rollDiceTwenty();
        if(testDice < defender.defense)//miss
        {
            System.out.println("Miss...");
            attacker.doDamage(0, defender);
        } else if(testDice >= defender.defense)
        {
            Dice d6 = new Dice();
            int dmgRoll;
            if (testDice == 20) // crit
            {
                System.out.println("Critcal!");
                dmgRoll = d6.rollDiceSix();
                attacker.doDamage(dmgRoll, defender);
                System.out.println("Hit for " + dmgRoll);
                dmgRoll = d6.rollDiceSix();
                attacker.doDamage(dmgRoll, defender);
                System.out.println("Hit for " + dmgRoll);
            } else
                {
                    System.out.println("Landed.");
                    dmgRoll = d6.rollDiceSix();
                    attacker.doDamage(dmgRoll, defender);
                    System.out.println("Hit for " + dmgRoll);
                }
        }
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
