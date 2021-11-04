import java.util.ArrayList;

//Add Enum for Character type and monster type.
public class Character extends Entity
{
    private String characterClass, name;
    //private int movement;
    //ArrayList<Item> inventory = new ArrayList<Item>(); Commented out because not needed. Inherits inventory from Entity.

    public Character(String name, String characterClass, int hp, int def, ArrayList<Item> inventory)
    {
        super(characterClass, hp, def, inventory); //Removed name
        this.characterClass = characterClass;
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
        return "";//Changed to return statement. For one method needs to return an ArrayList and two should not print from methods.
    }

    public String Respawn(Entity entity)
    {
        //This method will respawn the character at the previous location
        return "";
    }
}
