import java.util.ArrayList;
import java.util.HashMap;

public abstract class Entity implements Damage
{
    //protected String entityType;
    protected int health;
    protected int defense;
    protected HashMap<String, ItemType> cInventory;//Changed to an ArrayList of Item objects instead of just Objects.

    public Entity(int health, int defense)
    {
        //this.entityType = entityType;
        this.health = health;
        this.defense = defense;
        cInventory = new HashMap<String, ItemType>();
    }

    public abstract void addToInventory(String name, ItemType item);

    public abstract ItemType dropFromInventory(String name);

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getDefense()
    {
        return defense;
    }

    public void setDefense(int defense)
    {
        this.defense = defense;
    }
}
