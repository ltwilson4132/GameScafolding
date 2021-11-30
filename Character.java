//Add Enum for Character type and monster type.
public class Character extends Entity implements Damage
{
    private CharacterType type;
    private String  name;
    private Location currentLocation;
    private int attackBoost, defenseBoost;

    //Constructor for a new Character, this also adds the +2 defense bonus for the KNIGHT class
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

    public Character()
    {
        super(0,0);
    }

    //Shows the user what items they currently have
    public void Inventory()
    {
        if (!cInventory.isEmpty())
        {
            for (String name : cInventory.keySet())
            {
                System.out.println("You have a " + name);
            }
        } else
            {
            System.out.println("Your inventory is empty");
            }
    }

    //Adds the +2 bonus for the ARCHER class to any d20 attack rolls
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


    //Adds an item to the player's inventory
    @Override
    public void addToInventory(String name, ItemType item)
    {
        cInventory.put(name, item);
    }

    //Deletes an item from the player's inventory
    @Override
    public ItemType dropFromInventory(String name)
    {
        ItemType item;
        item = cInventory.get(name);
        cInventory.remove(item);
        return item;
    }

    //Uses an item and applies the effect to the player
    public void UseItem(ItemType item)
    {
        String name = "";
        if (item == ItemType.HEALING)
        {
            this.health += 20;
            name = "Healing Potion";
        } else if (item == ItemType.ATTACK_BOOST)
        {
            this.attackBoost = this.attackBoost + 2;
            name = "Attack Boost";
        } else
        {
            this.defenseBoost = this.defenseBoost + 2;
            name = "Defense Boost";
        }
        cInventory.remove(name);
    }

    //Added getters and setters
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
}
