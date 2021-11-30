/*
 * -------------------------------------------------------------------------------
 * File name: Game.java
 * Project name: Semester Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Logan Wilson wilsonlt@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Nov 12, 2021
 * Last modified: Logan Wilson wilsonlt@etsu.edu Nov 29, 2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Game<br>
 * Class Purpose:  The class is used to run the majority of the game. Sets up the objects to start the game and then
 * runs the game.<br>
 *
 * <hr>
 * Date created: Nov 14, 2021<br>
 * Last modified: Nov 29, 2021
 * @author Logan Wilson
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
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
        //Adds type of forest monsters to choose from.
        forestMonsters.add("Gremlin");
        forestMonsters.add("Zombie");
        forestMonsters.add("Spider");

        //Adds type of desert monsters to choose from.
        desertMonsters.add("Mummy");
        desertMonsters.add("Sand Worm");
        desertMonsters.add("Evil Cactus");

        //Adds type of cave monsters to choose from.
        caveMonsters.add("Shadow Creature");
        caveMonsters.add("Rock Golem");
        caveMonsters.add("Ghost");

        //Adds type of castle monsters to choose from.
        castleMonsters.add("Shadow Knight");
        castleMonsters.add("Witch");
        castleMonsters.add("Shadow Archer");

        //Adds type of moon monsters to choose from.
        moonMonsters.add("Mickey Mouse");
        moonMonsters.add("Cheese Monster");
        moonMonsters.add("Cosmonaut");

        //Adds different types of items to randomly generate.
        items.add("Healing Potion");
        items.add("Attack Boost");
        items.add("Defense Boost");
    }

    /*
     * Method Name: StartGame<br>
     * Method Purpose: This method is used to setup the game. It loads the game map from a text file, spawns the monsters,
     * creates the player's character, and moves them to the first location<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public void StartGame()
    {
        try
        {
            //Loads the game map from a text file. Changing the text file can change or add locations.
            ReadFile.readLocations("GameMap.txt", gameMap);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex);
        }
        //This fills all of the locations with a random number of monsters.
        SpawnMonsters();
        //Prints welcome message to the player.
        System.out.println("Welcome to the game. You will have to fight your way through " + gameMap.size() + " locations with a boss at the end of each location." + "\n" +
                "To get started create your character\n");
        //Creates a new Character object called player
        player = CreateCharacter();
        //Prints out player's initial stats.
        System.out.println("Character Name: " + player.getName() + "\n" +
                "Character Class: " + player.getType().value + "\n" +
                "Character Health: " + player.getHealth() + "\n" +
                "Character Defense: " + player.getDefense());
        //Moves player to the first location in the game map to start the game.
        player.setCurrentLocation(gameMap.get(0));
    }

    /*
     * Method Name: PlayGame<br>
     * Method Purpose: This method is used to run the game. This is where the battle methods is called, players are give
     * the chance to pickup items, and then they are moved on to the next location when they defeat all of the monsters.
     * Once they defeat the final boss the win.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public void PlayGame()
    {
        boolean playTheGame = true;
        String userInput = "";
        do{
            //Prints out the player's current location name and description.
            System.out.println("\n" + player.getCurrentLocation().getLocationName());
            System.out.println("\n" + player.getCurrentLocation().getLocationDescription());
            for (Monster monster:player.getCurrentLocation().getMonstersArray())
            {
                //Outputs a list of monsters that are still alive in the location
                System.out.println("You see the following monsters before you \n" +
                        player.getCurrentLocation().getMonsters());
                //Outputs who the player does battle with.
                System.out.println("You meet a " + monster.getEnemyType() + ". You engage in battle.");
                //Starts battle between player and the monster and stores winner.
                String winner = BattleSystem.startBattle(player, monster);

                //If the winner is the player then we output that they won and their current stats.
                if (winner.equals(player.getName()))
                {
                    System.out.println("Congratulations! You defeated the " + monster.getEnemyType());
                    System.out.println("Here are your current stats.\n" +
                            "Health: " + player.getHealth() + "\n" +
                            "Total Defense: " + (player.getDefense() + player.getDefenseBoost()) + "\n" +
                            "Attack Boost: +" + player.getAttackBoost() + " per roll");

                    //If the monster's inventory has items in it then the monster drops the item and the player is given a chance to take the item.
                    if (!(monster.cInventory.isEmpty()))
                    {
                        ItemType droppedItem = monster.dropFromInventory(monster.Inventory());
                        System.out.println("The monster dropped a " + droppedItem.value + ".\n");
                        //If they already have an item of this type then they cannot pick up another item.
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
                                System.out.println("You added a " + droppedItem.value + " to your inventory\n");
                            }
                        }
                    }
                    //The monster is removed from the location.
                    player.getCurrentLocation().removeMonster(monster);
                }
                //If the winner of the battle is the monster then the player is told and is given a chance to respawn.
                else
                {
                    System.out.println("You were defeated by a " + monster.getEnemyType() + ".");
                    Respawn();
                }
            }

            //After all the monsters in the current location are defeated the player is notified and move to the next location.
            //They are then given a prompt to save their game if they want to.
            if(player.getCurrentLocation().getLocationName().equals("Forest"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(1));
                SaveGamePrompt();
            }
            else if(player.getCurrentLocation().getLocationName().equals("Desert"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(2));
                SaveGamePrompt();
            }
            else if(player.getCurrentLocation().getLocationName().equals("Cave"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(3));
                SaveGamePrompt();
            }//end lse if(player.getCurrentLocation().getLocationName().equals("Cave"))
            else if(player.getCurrentLocation().getLocationName().equals("Castle"))
            {
                System.out.println("Congratulations! You have defeated all of the monster in the " + player.getCurrentLocation().getLocationName() + ". You will now move on to the next location.");
                player.setCurrentLocation(gameMap.get(4));
                SaveGamePrompt();
            }//end else if(player.getCurrentLocation().getLocationName().equals("Castle"))
            //If the player defeated all of the monsters in the moon location then they win and are told so.
            //They are then given the option to play again if they wish
            else
            {
                while(!(userInput.equals("yes") && !(userInput.equals("no"))))
                {
                    System.out.println("Congratulations! You defeated the final boss.\nWould you like to play again yes or no?");
                    userInput = input.nextLine().toLowerCase();
                    if(userInput.equals("yes"))
                    {
                        StartGame();
                    }//end if(userInput.equals("yes"))
                    else if(userInput.equals("no"))
                    {
                        System.out.println("Thank you for playing!");
                        playTheGame = false;
                    }//end else if(userInput.equals("no"))
                    else
                    {
                        System.out.println("Please choose a valid option.");
                    }//end else
                }//end while

            }//end else
        }while(playTheGame);
    }//end PlayGame method

    /*
     * Method Name: SaveGamePrompt<br>
     * Method Purpose: This method is used to ask the user if they want to save their game. If they say yes then the
     * details of their character are saved to a text file. If not then the game continues.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public void SaveGamePrompt()
    {
        String userInput = "";
        while(!(userInput.equals("yes") && !(userInput.equals("no"))))
        {
            //User is prompted to save the game if they wish.
            System.out.println("Would you like to save your game yes or no?");
            userInput = input.nextLine().toLowerCase();
            //If yes then the details of their Character are saved to a text file.
            if (userInput.equals("yes"))
            {
                WriteFile.SavePlayer(player);
                System.out.println("You may now close the game or keep playing");
            }//end if (userInput.equals("yes"))
            //If no then the game continues
            else if(userInput.equals("no"))
            {
                System.out.println("Your game has not been saved");
            }//end else if(userInput.equals("no"))
            else
            {
                System.out.println("Please choose a valid option");
            }//end else
        }//end while
    }//end SaveGamePrompt method

    /*
     * Method Name: Respawn<br>
     * Method Purpose: This method is used to reset the player if they die and decide to respawn. It resets their health,
     * respawns the monsters, and moves the player to the previous location.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public void Respawn()
    {
        String userInput = null;
        while(!(userInput.equals("yes") && !(userInput.equals("no"))))
        {
            //The user is asked if they would like to respawn or not.
            System.out.println("Would you like to continue?" + "\n" + "Yes or No");
            userInput = input.nextLine().toLowerCase();
            //If the player chooses to continue then their health is reset and they are moved to the previous location
            if (userInput.equals("yes"))
            {
                //If the player is a Wizard then we reset their health to 120, else it is set to 100
                if (player.getType() == CharacterType.WIZARD) player.setHealth(120);
                else player.setHealth(100);
                //Respawns monsters in all the locations
                SpawnMonsters();
                System.out.println("New monsters will be respawned and you will have to go back to the previous location");
                if(player.getCurrentLocation().getLocationName().equals("Desert")) player.setCurrentLocation(gameMap.get(0));
                else if(player.getCurrentLocation().getLocationName().equals("Cave")) player.setCurrentLocation(gameMap.get(1));
                else if(player.getCurrentLocation().getLocationName().equals("Castle")) player.setCurrentLocation(gameMap.get(2));
                else if(player.getCurrentLocation().getLocationName().equals("Moon")) player.setCurrentLocation(gameMap.get(3));
                System.out.println("You respawned back at the beginning of the" + player.getCurrentLocation().getLocationName() +
                        "The battle continues");
            }//end if (userInput.equals("yes"))
            //If the player chooses not to respawn then they can save and then program closes.
            else if (userInput.equals("no"))
            {
                SaveGamePrompt();
                System.out.println("Thank you for playing!");
                System.exit(0);
            }//end else if (userInput.equals("no"))
            else
            {
                System.out.println("Please choose a valid option.");
            }//end else
        }//end while
    }//end Respawn method

    /*
     * Method Name: SpawnMonsters<br>
     * Method Purpose: This method is used to spawn randomized monsters. A random number of monsters is generated based
     * on the size of each location. Monsters in every location a range that there health can be in and a set defense.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public void SpawnMonsters()
    {
        //Clears out any monsters in the locations before respawning new ones
        for (Location location:gameMap)
        {
            location.ClearMonsters();
        }//end for

        for (Location location : gameMap)
        {
            //used to determine how many monsters to spawn at random from 1 to the max size of a location minus 1.
            int numMonsters = (Dice.generateRandomNum(location.getSize()-1) + 1);

            for (int i = 0; i < numMonsters; i++)
            {
                //Used to randomly create a monster from the defined ArrayList for each location.
                int monsterSelection = Dice.generateRandomNum(3);

                //Monster are created with randomized health and set defense and items are randomly generated.
                if(location.getLocationName().equals("Forest"))
                {
                    //System.out.println("Forrest");
                    Monster monster = new Monster(forestMonsters.get(monsterSelection), Dice.RandomRange(5, 10), 2);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }//end if(location.getLocationName().equals("Forest"))
                else if(location.getLocationName().equals("Desert"))
                {
                    //System.out.println("Desert");
                    Monster monster = new Monster(desertMonsters.get(monsterSelection), Dice.RandomRange(10, 15), 3);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }//end else if(location.getLocationName().equals("Desert"))
                else if(location.getLocationName().equals("Cave"))
                {
                    //System.out.println("Cave");
                    Monster monster = new Monster(caveMonsters.get(monsterSelection), Dice.RandomRange(15, 20), 4);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }//end else if(location.getLocationName().equals("Cave"))
                else if(location.getLocationName().equals("Castle"))
                {
                    //System.out.println("Castle");
                    Monster monster = new Monster(castleMonsters.get(monsterSelection), Dice.RandomRange(20, 25), 5);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }//end else if(location.getLocationName().equals("Castle"))
                else if(location.getLocationName().equals("Cheese Moon"))
                {
                    //System.out.println("Cheese Moon");
                    Monster monster = new Monster(moonMonsters.get(monsterSelection), Dice.RandomRange(25, 30), 10);
                    GenerateItem(monster);
                    location.AddMonster(monster);
                }//end else if(location.getLocationName().equals("Cheese Moon"))
                else
                {
                    break;
                    //System.out.println("Error");
                    //Monster monster = new Monster(moonMonsters.get(monsterSelection), Dice.RandomRange(25, 30), 10);
                    //GenerateItem(monster);
                    //location.AddMonster(monster);
                }//end else
            }//end for
        }//end for
        //At the end the bosses are spawned.
        SpawnBosses();
    }//end SpawnMonsters method

    /*
     * Method Name: CreateCharacter<br>
     * Method Purpose: This method is used to create the character the player will play as. The player chooses their name
     * and then chooses their class.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public Character CreateCharacter()
    {
        String userInput = "";
        Character character;

        //The user types in the name of their character.
        System.out.println("What would you like the name of your character to be?");
        String playerName = input.nextLine();

        do
        {
            //User is prompted to choose a character.
            System.out.println("Please choose which character you would like to be:" + "\n" +
                    CharacterType.ARCHER.value + "\n" +
                    CharacterType.KNIGHT.value + "\n" +
                    CharacterType.WIZARD.value);
            userInput = input.nextLine().toLowerCase();

            if (userInput.equals("archer"))
            {
                //Creates a Archer object if the user chooses archer
                character = new Character(playerName, CharacterType.ARCHER, 100, Dice.rollDiceSix());
            }//end if (userInput.equals("archer"))
            else if(userInput.equals("knight"))
            {
                //Creates a Knight object if the user chooses archer
                character = new Character(playerName, CharacterType.KNIGHT, 100, (Dice.rollDiceSix() + 2));
            }//end else if(userInput.equals("knight"))
            else if(userInput.equals("wizard"))
            {
                //Creates a Wizard object if the user chooses archer
                character = new Character(playerName, CharacterType.WIZARD, 120, Dice.rollDiceSix());
            }//end else if(userInput.equals("wizard"))
            else
            {
                System.out.println("Error you did not choose a valid option.\n");
                userInput = "";
                character = new Character(null, null, 0, 0);
            }//end else
        }while(userInput.equals(""));
        return character;
    }//end CreateCharacter method

    /*
     * Method Name: GenerateItem<br>
     * Method Purpose: This method is used generate randomized items for each monster. There is a 50% chance that the monster
     * will not be given an item to drop.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param Monster monster: the monster that will receive the randomly generated item.
     * @returns void
     */
    public void GenerateItem(Monster monster)
    {
        //Generates a random number used for generating item.
        //0 to 2 will generate an item. 3 to 5 will cause an item to not be generated.
        int itemSelection = Dice.generateRandomNum(6);

        if (itemSelection >= 3)
        {

        }//end if (itemSelection >= 3)
        else if(items.get(itemSelection).equals("Healing Potion"))
        {
            monster.addToInventory(items.get(itemSelection), ItemType.HEALING);
            //monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.HEALING));
        }//end else if(items.get(itemSelection).equals("Healing Potion"))
        else if(items.get(itemSelection).equals("Attack Boost"))
        {
            monster.addToInventory(items.get(itemSelection), ItemType.ATTACK_BOOST);
            //monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.ATTACK_BOOST));
        }//end else if(items.get(itemSelection).equals("Attack Boost"))
        else if(items.get(itemSelection).equals("Defense Boost"))
        {
            monster.addToInventory(items.get(itemSelection), ItemType.DEFENSE_BOOST);
            //monster.addToInventory(items.get(itemSelection), new Item(items.get(itemSelection), ItemType.DEFENSE_BOOST));
        }//end else if(items.get(itemSelection).equals("Defense Boost"))
    }//end GenerateItem method

    /*
     * Method Name: SpawnBosses<br>
     * Method Purpose: This method is used to spawn the bosses. Each location gets one boss at the end. The bosses have
     * a health stat that is randomly generated between a certain range and a specified defense. Each boss is also given
     * an item that they can drop upon death.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns void
     */
    public void SpawnBosses()
    {
        //Spawns forest boss with randomized health and set defense
        Boss forestBoss = new Boss("Grizzly Bear", Dice.RandomRange(50, 75), 10);
        GenerateItem(forestBoss);
        gameMap.get(0).AddMonster(forestBoss);

        //Spawns desert boss with randomized health and set defense
        Boss desertBoss = new Boss("Giant Skeleton", Dice.RandomRange(75, 100), 10);
        GenerateItem(desertBoss);
        gameMap.get(1).AddMonster(desertBoss);

        //Spawns cave boss with randomized health and set defense
        Boss caveBoss = new Boss("The Mutant Batman: Half Bat, Half Man", Dice.RandomRange(100, 150), 10);
        GenerateItem(caveBoss);
        gameMap.get(2).AddMonster(caveBoss);

        //Spawns castle boss with randomized health and set defense
        Boss castleBoss = new Boss("Dragon", Dice.RandomRange(150, 175), 10);
        GenerateItem(castleBoss);
        gameMap.get(3).AddMonster(castleBoss);

        //Spawns moon boss with randomized health and set defense
        Boss moonBoss = new Boss("King Rat", Dice.RandomRange(175, 200), 1);
        GenerateItem(moonBoss);
        gameMap.get(4).AddMonster(moonBoss);
    }//end SpawnBosses method

    public ArrayList<Location> getGameMap()
    {
        return gameMap;
    }//end getGameMap method

    public void setPlayer(Character player)
    {
        this.player = player;
    }//end setPlayer method
}//end class Game
