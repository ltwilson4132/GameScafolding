import java.util.Locale;
import java.util.Scanner;

public class BattleSystem //extends Dice Should not extend Dice. BattleSystem uses Dice.
{
    //private String battleType;
    static Scanner kb = new Scanner(System.in);
    static String winnerText = "";
    public static String startBattle(Character player, Monster enemy)
    {
        //Method that starts a battle between 2 entities
        while(player.health >= 0 && enemy.health >= 0)
        {
            if (testDeath(player, enemy) == true)
            {
                break;
            }
            System.out.println(player.getName() + " turn.");
            Turn(player, enemy);
            testDeath(player, enemy);
            if (testDeath(player, enemy) == true)
            {
                break;
            }
            System.out.println(enemy.getEnemyType() + " turn.");
            kb.nextLine();
            Attack(enemy, player);
        }
        //Check to see if either entity is dead.
        //While neither entity is dead do battle.
        //If there are no more enemies move character to the next location
        //Outputs string that says the results of the battle.
        return winnerText;
    }


    public static boolean testDeath(Character player, Monster enemy)
    {
        if(player.health <= 0)
        {
            player.Respawn(player);
            winnerText = enemy.getEnemyType();
            return true;
        }
        else if(enemy.health <= 0)
        {
            /* player. location.size - 1?*/;
            winnerText = player.getName();
            return true;
        }
        return false;
    }

    public static void Turn(Character player, Monster enemy)
    {
        String testVar = "";
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println(" 2. Inventory");;
        while(!testVar.equals("attack") && !testVar.equals("inventory"))
        {
            System.out.println("Please enter a valid choice");
            testVar = kb.nextLine().toLowerCase();
        }
        if (testVar.equals("attack"))
        {
            Attack(player, enemy);
        } else if(testVar.equals("inventory"))
        {
            System.out.println("Please select an item:");
            /*for (String name:player.cInventory.keySet()) {
                System.out.println(name);
            }*/
            player.Inventory(player);
            String userInput = kb.nextLine();
            if (player.cInventory.get(userInput) == null)
            {
                System.out.println("Selection Invalid");
                System.out.println("\n");
                Turn(player, enemy);
            } else if (player.cInventory.get(userInput.toUpperCase()) != null)
            { // checks against null, if not null, will work
                player.UseItem(player, player.cInventory.get(userInput));
            }
        }
    }

    public static void Attack(Entity attacker, Entity defender)
    {
        //Roll twenty dice to decide attack power, take attack power minus defenders defense and take that amount of health from the defender.
        Dice d20 = new Dice();

        int testDice = attacker.Attack();
        if(testDice < defender.defense)//miss
        {
            kb.nextLine();
            System.out.println("Miss...");
            attacker.Attack();
            System.out.println("\n");
        } else if(testDice >= defender.defense)
        {
            Dice d6 = new Dice();
            int dmgRoll;
            if (testDice >= 20) // crit
            {
                System.out.println("Critcal!");
                kb.nextLine();
                System.out.println("\n");

                dmgRoll = d6.rollDiceSix();
                defender.setHealth(defender.health -= dmgRoll);
                System.out.println("Hit for " + dmgRoll);
                System.out.println("defender's health " + defender.getHealth());
                kb.nextLine();
                System.out.println("\n");

                dmgRoll = d6.rollDiceSix();
                defender.setHealth(defender.health -= dmgRoll);
                System.out.println("Hit for " + dmgRoll);
                System.out.println("defender's health " + defender.getHealth());
                kb.nextLine();
                System.out.println("\n");

            } else
                {
                    System.out.println("Landed.");
                    kb.nextLine();
                    System.out.println("\n");

                    dmgRoll = d6.rollDiceSix();
                    defender.setHealth(defender.health -= dmgRoll);
                    System.out.println("Hit for " + dmgRoll);
                    System.out.println("Defender's health " + defender.getHealth());
                    kb.nextLine();
                    System.out.println("\n");
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
