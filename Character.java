import java.util.ArrayList;

//Add Enum for Character type and monster type.
public class Character extends Entity
{
    private CharacterType type;
    private String  name;
    //private int movement;
    //ArrayList<Item> inventory = new ArrayList<Item>(); Commented out because not needed. Inherits inventory from Entity.

    public Character(String name, CharacterType characterClass, int hp, int def, ArrayList<Item> inventory)
    {
        super(hp, def, inventory); //Removed name
        this.type = characterClass;
        this.name = name;//Added to set name field.
    }

    /*
    public String Move(Location location)
    {
        //Not sure what this method would do as we discussed not having movement
        this.movement = movement;
        return "";
    }
    */

    public String useItem(Item item)
    {
        //This method will use an item
        return "";
    }

    public String Inventory(ArrayList<Item> inventory)//Changed because inventory is an ArrayList of Item objects.
    {
        //This method will show the user what items they currently have
        return "";//Changed to return statement. For one method needs to return a String and two should not print from methods.
    }

    public String Respawn(Entity entity)
    {
        //Player should get an option to respawn or quit.
        //Respawn will set players health back to full and move them to the previous location
        return "";
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
