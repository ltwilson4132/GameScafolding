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

import java.io.FileNotFoundException;
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
    private ArrayList<Location> gameMap = new ArrayList<>();
    private ArrayList<String> forestMonsters = new ArrayList<>();
    private ArrayList<String> desertMonsters = new ArrayList<>();
    private ArrayList<String> caveMonsters = new ArrayList<>();
    private ArrayList<String> castleMonsters = new ArrayList<>();
    private ArrayList<String> moonMonsters = new ArrayList<>();
    private ArrayList<String> items = new ArrayList<String>();
    private Scanner input = new Scanner(System.in);
    private Character player;

    public Game()
    {
        forestMonsters.add("Gremlin");
        forestMonsters.add("Zombie");
        forestMonsters.add("Spider");

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
        try
        {
            ReadFile.readLocations("GameMap.txt", gameMap);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex);
        }
        SpawnMonsters();
        System.out.println("Welcome to the game. You will have to fight your way through " + gameMap.size() + " locations with a boss at the end of each location." + "\n" +
                "To get started create your character\n");
        player = CreateCharacter();
        System.out.println("Character Name: " + player.getName() + "\n" +
                "Character Class: " + player.getType().value + "\n" +
                "Character Health: " + player.getHealth() + "\n" +
                "Character Defense: " + player.getDefense());
        player.setCurrentLocation(gameMap.get(0));
    }

    public void PlayGame()
    {
        boolean playTheGame = true;
        String userInput = null;
        do{
            System.out.println("\n" + player.getCurrentLocation().getLocationName());
            System.out.println("\n" + player.getCurrentLocation().getLocationDescription());
            for (Monster monster:player.getCurrentLocation().getMonstersArray())
            {
                System.out.println("You see the following monsters before you \n" +
                        player.getCurrentLocation().getMonsters());
                System.out.println("You meet a " + monster.getEnemyType() + ". You engage in battle.");
                String winner = BattleSystem.startBattle(player, monster);
                if (winner.equals(player.getName()))
                {
                    System.out.println("Congratulations! You defeated the " + monster.getEnemyType());
                    System.out.println("Here are your current stats.\n" +
                            "Health: " + player.getHealth() + "\n" +
                            "Total Defense: " + (player.getDefense() + player.getDefenseBoost()) + "\n" +
                            "Attack Boost: +" + player.getAttackBoost() + " per roll");
                    if (!(monster.cInventory.isEmpty()))
                    {
                        ItemType droppedItem = monster.dropFromInventory(monster.Inventory());
                        System.out.println("The monster dropped a " + droppedItem.value + ".\n");
                        if(player.cInventory.containsKey(droppedItem.value))
                        {
                            System.out.println("You already have a " + droppedItem.value + " in your inventory and you can't carry anymore.");
                        }
                        else
                        {
                                System.out.println("Would you like to add this item to your inventory?");
                            if (input.nextLine().toLowerCase().equals("yes"))
                            {
                                player.addToInventory(droppedItem.value, droppedItem);
                                System.out.println("You added a " + droppedItem.value + " to your inventory");
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("You were defeated by a " + monster.getEnemyType() + ".");
                    Respawn();
                }
            }
            if(player.getCurrentLocation().getLocationName().equals("Forest"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(1));

            }
            else if(player.getCurrentLocation().getLocationName().equals("Desert"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(2));
            }
            else if(player.getCurrentLocation().getLocationName().equals("Cave"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(3));
            }
            else if(player.getCurrentLocation().getLocationName().equals("Castle"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(4));
            }
            else
            {
                while(!(userInput.equals("yes") && !(userInput.equals("no"))))
                {
                    System.out.println("Congratulations! You defeated the final boss.\nWould you like to play again yes or no?");
                    userInput = input.nextLine().toLowerCase();
                    if(userInput.equals("yes"))
                    {
                        StartGame();
                    }
                    else if(userInput.equals("no"))
                    {
                        System.out.println("Thank you for playing!");
                        playTheGame = false;
                    }
                    else
                    {
                        System.out.println("Please choose a valid option.");
                    }
                }

            }
        }while(playTheGame);
    }

    public void Respawn()
    {
        String userInput = null;
        while(!(userInput.equals("yes") && !(userInput.equals("no"))))
        {
            System.out.println("Would you like to continue?" + "\n" + "Yes or No");
            userInput = input.nextLine().toLowerCase();
            if (userInput.equals("yes"))
            {
                if (player.getType() == CharacterType.WIZARD) player.setHealth(120);
                else player.setHealth(100);
                SpawnMonsters();
                System.out.println("New monsters will be respawned and you will have to go back to the previous location");
                if(player.getCurrentLocation().getLocationName().equals("Desert")) player.setCurrentLocation(gameMap.get(0));
                else if(player.getCurrentLocation().getLocationName().equals("Cave")) player.setCurrentLocation(gameMap.get(1));
                else if(player.getCurrentLocation().getLocationName().equals("Castle")) player.setCurrentLocation(gameMap.get(2));
                else if(player.getCurrentLocation().getLocationName().equals("Moon")) player.setCurrentLocation(gameMap.get(3));
                System.out.println("You respawned back at the beginning of the" + player.getCurrentLocation().getLocationName() +
                        "The battle continues");
            }
            else if (userInput.equals("no"))
            {
                System.out.println("Thank you for playing!");
                System.exit(0);
            }
            else
            {
                System.out.println("Please choose a valid option.");
            }
        }
    }

    public void SpawnMonsters()
    {
        for (Location location:gameMap)
        {
            location.ClearMonsters();
        }

        for (Location location : gameMap)
        {
            int numMonsters = (Dice.generateRandomNum(location.getSize()-1) + 1);

            for (int i = 0; i < numMonsters; i++)
            {
                int monsterSelection = Dice.generateRandomNum(3);


                if(location.getLocationName().equals("Forest"))
                {
                    //System.out.println("Forrest");
                    Monster monster = new Monster(forestMonsters.get(monsterSelection), Dice.RandomRange(5, 10), 2);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Desert"))
                {
                    //System.out.println("Desert");
                    Monster monster = new Monster(desertMonsters.get(monsterSelection), Dice.RandomRange(10, 15), 3);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Cave"))
                {
                    //System.out.println("Cave");
                    Monster monster = new Monster(caveMonsters.get(monsterSelection), Dice.RandomRange(15, 20), 4);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Castle"))
                {
                    //System.out.println("Castle");
                    Monster monster = new Monster(castleMonsters.get(monsterSelection), Dice.RandomRange(20, 25), 5);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else if(location.getLocationName().equals("Cheese Moon"))
                {
                    //System.out.println("Cheese Moon");
                    Monster monster = new Monster(moonMonsters.get(monsterSelection), Dice.RandomRange(25, 30), 10);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }
                else
                {
                    break;
                    //System.out.println("Error");
                    //Monster monster = new Monster(moonMonsters.get(monsterSelection), Dice.RandomRange(25, 30), 10);
                    //GenerateItem(monster);
                    //location.AddMonster(monster);
                }
            }
        }
        SpawnBosses();
    }

    public Character CreateCharacter()
    {
        String userInput = "";
        Character character;

        System.out.println("What would you like the name of your character to be?");
        String playerName = input.nextLine();

        do
        {

            System.out.println("Please choose which character you would like to be:" + "\n" +
                    CharacterType.ARCHER.value + "\n" +
                    CharacterType.KNIGHT.value + "\n" +
                    CharacterType.WIZARD.value);
            userInput = input.nextLine().toLowerCase();

            if (userInput.equals("archer"))
            {
                character = new Character(playerName, CharacterType.ARCHER, 100, Dice.rollDiceSix());
            }
            else if(userInput.equals("knight"))
            {
                character = new Character(playerName, CharacterType.KNIGHT, 100, (Dice.rollDiceSix() + 2));
            }
            else if(userInput.equals("wizard"))
            {
                character = new Character(playerName, CharacterType.WIZARD, 120, Dice.rollDiceSix());
            }
            else
            {
                System.out.println("Error you did not choose a valid option.\n");
                userInput = "";
                character = new Character(null, null, 0, 0);
            }
        }while(userInput.equals(""));
        return character;
    }

    public void GenerateItem(Monster monster)
    {
        int itemSelection = Dice.generateRandomNum(6);

        if (itemSelection >= 3)
        {

        }
        else if(items.get(itemSelection).equals("Healing Potion"))
        {
            monster.addToInventory(items.get(itemSelection), ItemType.HEALING);
            //monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.HEALING));
        }
        else if(items.get(itemSelection).equals("Attack Boost"))
        {
            monster.addToInventory(items.get(itemSelection), ItemType.ATTACK_BOOST);
            //monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.ATTACK_BOOST));
        }
        else if(items.get(itemSelection).equals("Defense Boost"))
        {
            monster.addToInventory(items.get(itemSelection), ItemType.DEFENSE_BOOST);
            //monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.DEFENSE_BOOST));
        }
    }

    public void SpawnBosses()
    {
        Boss forestBoss = new Boss("Grizzly Bear", Dice.RandomRange(50, 75), 10);
        GenerateItem(forestBoss);
        gameMap.get(0).AddMonster(forestBoss);

        Boss desertBoss = new Boss("Giant Skeleton", Dice.RandomRange(75, 100), 10);
        GenerateItem(desertBoss);
        gameMap.get(1).AddMonster(desertBoss);

        Boss caveBoss = new Boss("The Mutant Batman: Half Bat, Half Man", Dice.RandomRange(100, 150), 10);
        GenerateItem(caveBoss);
        gameMap.get(2).AddMonster(caveBoss);

        Boss castleBoss = new Boss("Dragon", Dice.RandomRange(150, 175), 10);
        GenerateItem(castleBoss);
        gameMap.get(3).AddMonster(castleBoss);

        Boss moonBoss = new Boss("King Rat", Dice.RandomRange(175, 200), 10);
        GenerateItem(moonBoss);
        gameMap.get(4).AddMonster(moonBoss);
    }

    public ArrayList<Location> getGameMap()
    {
        return gameMap;
    }

    public ArrayList<String> getForrestMonsters()
    {
        return forestMonsters;
    }

    public ArrayList<String> getDesertMonsters()
    {
        return desertMonsters;
    }

    public ArrayList<String> getCaveMonsters()
    {
        return caveMonsters;
    }

    public ArrayList<String> getCastleMonsters()
    {
        return castleMonsters;
    }

    public ArrayList<String> getMoonMonsters()
    {
        return moonMonsters;
    }

    public ArrayList<String> getItems()
    {
        return items;
    }
}//end class Game
