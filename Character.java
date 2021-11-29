import java.util.Scanner;

//Add Enum for Character type and monster type.
public class Character extends Entity implements Damage
{
    private CharacterType type;
    private String  name;
    private Location currentLocation;
    private int attackBoost, defenseBoost;
    Scanner kb = new Scanner(System.in);
    //private int movement;
    //ArrayList<Item> inventory = new ArrayList<Item>(); Commented out because not needed. Inherits inventory from Entity.

    public Character(String name, CharacterType characterClass, int hp, int def)
    {
        super(hp, def);
        attackBoost = 0;
        if (characterClass == CharacterType.KNIGHT)
        {
            defenseBoost = 2;
        } else
        {
            defenseBoost = 0;
        }
        this.type = characterClass;
        this.name = name; //Added to set name field.
    }

    public void Inventory(Character player)//Changed because inventory is an ArrayList of Item objects.
    {
        //This method will show the user what items they currently have

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
    }

    public int Attack()
    {
        if (type.equals("ARCHER"))
        {
            return Dice.rollDiceTwenty() + 2 + attackBoost;
        } else
        {
            return Dice.rollDiceTwenty() + attackBoost;
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
    
    public Location getCurrentLocation()
    {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation)
    {
        this.currentLocation = currentLocation;
    }
    
    @Override
    public void addToInventory(String name, ItemType item)
    {
        cInventory.put(name, item);
    }

    @Override
    public ItemType dropFromInventory(String name)
    {
        ItemType item;
        item = cInventory.get(name);
        cInventory.remove(item);
        return item;
    }

    @Override
    public void UseItem(ItemType item)
    {
        if (item == ItemType.HEALING)
        {
            this.health = this.health + 20;
        } else if (item == ItemType.ATTACK_BOOST)
        {
            this.attackBoost = this.attackBoost + 2;
        } else
        {
            this.defenseBoost = this.defenseBoost + 2;
        }
        cInventory.remove(item);
    }
    
    public int getAttackBoost()
    {
        return attackBoost;
    }

    public void setAttackBoost(int attackBoost)
    {
        this.attackBoost = attackBoost;
    }

    public int getDefenseBoost()
    {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost)
    {
        this.defenseBoost = defenseBoost;
    }
}
