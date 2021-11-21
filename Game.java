/*
 * -------------------------------------------------------------------------------
 * File name: Game.java
 * Project name: Game
 * -------------------------------------------------------------------------------
 * Author's name and email: Logan Wilson wilsonlt@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Nov 14, 2021
 * Last modified: Logan Wilson wilsonlt@etsu.edu Nov 14, 2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Game<br>
 * Class Purpose:  <br>
 *
 * <hr>
 * Date created: Nov 14, 2021<br>
 * Last modified: Nov 14, 2021
 * @author Logan Wilson
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    /*
     * Method Name: main <br>
     * Method Purpose:  <br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 14, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param args array of Strings (not used in this program)
     * @returns void
     */
    private ArrayList<Location> gameMap;
    private ArrayList<String> forrestMonsters = new ArrayList<>();
    private ArrayList<String> desertMonsters = new ArrayList<>();
    private ArrayList<String> caveMonsters = new ArrayList<>();
    private ArrayList<String> castleMonsters = new ArrayList<>();
    private ArrayList<String> moonMonsters = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<String>();
    private Scanner input = new Scanner(System.in);
    private Character player;

    public Game()
    {
        forrestMonsters.add("Gremlin");
        forrestMonsters.add("Zombie");
        forrestMonsters.add("Spider");

        desertMonsters.add("Mummy");
        desertMonsters.add("Sand Worm");
        desertMonsters.add("Evil Cactus");

        caveMonsters.add("Shadow Creature");
        caveMonsters.add("Rock Golem");
        caveMonsters.add("Ghost");

        castleMonsters.add("Shadow Knight");
        castleMonsters.add("Witch");
        castleMonsters.add("Shadow Archer");

        moonMonsters.add("Mickey Mouse");
        moonMonsters.add("Cheese Monster");
        moonMonsters.add("Cosmonaut");

        items.add("Healing Potion");
        items.add("Attack Boost");
        items.add("Defense Boost");
    }

    public void StartGame()
    {
        gameMap = ReadFile.LoadMap("GameMap.txt");
        SpawnMonsters();
        SpawnBosses();
        System.out.println("Welcome to the game. You will have to fight your way through 5 locations with a boss at the end of each location." + "\n" +
                "To get started create your character");
        player = CreateCharacter();
        player.setCurrentLocation(gameMap.get(0));
        System.out.println(player.getCurrentLocation().getLocationName());
        System.out.println(player.getCurrentLocation().getLocationDescription());
    }

    public void PlayGame()
    {
        do{
            int i = 0;
            for (Location location:gameMap)
            {
                Monster monster = location.GetMonster(i);
                System.out.println("You meet a " + monster.getEnemyType() + ". You engage in battle.");
                String winner = BattleSystem.startBattle(player, monster);
                if (winner.equals(player.getName()))
                {
                    System.out.println("Congratulations! You defeated the " + monster.getEnemyType());
                    monster.dropFromInventory("test");
                }
            }

        }while(true);
    }

    public void SpawnMonsters()
    {
        for (Location location : gameMap)
        {
            int numMonsters = (Dice.generateRandomNum(location.getSize()) + 1);
            for (int i = 0; i < numMonsters; i++)
            {
                int monsterSelection = Dice.generateRandomNum(3);


                if(location.getLocationName().equals("Forrest"))
                {
                    Monster monster = new Monster(forrestMonsters.get(monsterSelection), Dice.RandomRange(5, 10), 2);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Desert"))
                {
                    Monster monster = new Monster(desertMonsters.get(monsterSelection), Dice.RandomRange(10, 15), 3);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Cave"))
                {
                    Monster monster = new Monster(caveMonsters.get(monsterSelection), Dice.RandomRange(15, 20), 4);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Castle"))
                {
                    Monster monster = new Monster(castleMonsters.get(monsterSelection), Dice.RandomRange(20, 25), 5);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else
                {
                    Monster monster = new Monster(moonMonsters.get(monsterSelection), Dice.RandomRange(25, 30), 10);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
            }
        }
    }

    public Character CreateCharacter()
    {
        String userInput = null;

        System.out.println("What would you like the name of your character to be?");
        String playerName = input.nextLine();

        do
        {

            System.out.println("Please choose which character you would like to be:" + "\n" +
                    CharacterType.ARCHER + "\n" +
                    CharacterType.KNIGHT + "\n" +
                    CharacterType.WIZARD);
            userInput = input.nextLine();

            if (userInput.equals("Archer"))
            {
                return new Character(playerName, CharacterType.ARCHER, 100, Dice.rollDiceSix());
            }
            else if(userInput.equals("Knight"))
            {
                return new Character(playerName, CharacterType.KNIGHT, 100, (Dice.rollDiceSix() + 2));
            }
            else if(userInput.equals("Wizard"))
            {
                return new Character(playerName, CharacterType.WIZARD, 120, Dice.rollDiceSix());
            }
            else
            {
                System.out.println("Error you did not choose a valid option.\n");
                userInput = null;
                return new Character(null, null, 0, 0);
            }
        }while(userInput.isEmpty());
    }

    public void GenerateItem(Monster monster)
    {
        int itemSelection = Dice.generateRandomNum(3);

        if(items.get(itemSelection).equals("Healing Potion"))
        {
            monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.HEALING));
        }
        else if(items.get(itemSelection).equals("Attack Boost"))
        {
            monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.ATTACK_BOOST));
        }
        else
        {
            monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.DEFENSE_BOOST));
        }
    }

    public void SpawnBosses()
    {
        Boss forrestBoss = new Boss("Grizzly Bear", Dice.RandomRange(50, 75), 10);
        gameMap.get(0).AddMonster(forrestBoss);

        Boss desertBoss = new Boss("Giant Skeleton", Dice.RandomRange(75, 100), 10);
        gameMap.get(1).AddMonster(desertBoss);

        Boss caveBoss = new Boss("The Mutant Batman: Half Bat, Half Man", Dice.RandomRange(100, 150), 10);
        gameMap.get(2).AddMonster(caveBoss);

        Boss castleBoss = new Boss("Dragon", Dice.RandomRange(150, 175), 10);
        gameMap.get(3).AddMonster(castleBoss);

        Boss moonBoss = new Boss("King Rat", Dice.RandomRange(175, 200), 10);
        gameMap.get(4).AddMonster(moonBoss);
    }
}//end class Game
