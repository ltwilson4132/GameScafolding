import java.util.ArrayList;
import java.util.Scanner;

//Add Enum for Character type and monster type.
public class Character extends Entity implements Damage
{
    private CharacterType type;
    private String  name;
    private Location currentLocation;
    Scanner kb = new Scanner(System.in);
    //private int movement;
    //ArrayList<Item> inventory = new ArrayList<Item>(); Commented out because not needed. Inherits inventory from Entity.

    public Character(String name, CharacterType characterClass, int hp, int def)
    {
        super(hp, def); //Removed name
        this.type = characterClass;
        this.name = name;//Added to set name field.
    }

    public String Inventory()//Changed because inventory is an ArrayList of Item objects.
    {
        //This method will show the user what items they currently have
        Entity player = null;
        if (!cInventory.isEmpty())
        {
            for (String name : player.cInventory.keySet())
            {
                System.out.println("You have a " + name);
            }
        } else
            {
            System.out.println("Your inventory is empty");
            }
        return name;
    }

    public String Respawn(Character player)
    {
        //Player should get an option to respawn or quit.
        //Respawn will set players health back to full and move them to the previous location
        System.out.println("Would you like to continue?" + "\n" + "Yes or No");
        if (kb.nextLine().contains("yes"))
        {
            player.health = 100;
            Game.SpawnMonsters();
        } else
        {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
        return "";
    }

    public int Attack()
    {
        if (type.equals("ARCHER"))
        {
            return Dice.rollDiceTwenty() + 2;
        } else
        {
            return Dice.rollDiceTwenty();
        }
    }

    //Added getters and setters
    public CharacterType getType()
    {
        return type;
    }

    public void setType(CharacterType type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
