import java.util.ArrayList;
import java.util.HashMap;

public class Entity implements Damage
{
    //protected String entityType;
    protected int health;
    protected int defense;
    protected HashMap<String, Item> cInventory;//Changed to an ArrayList of Item objects instead of just Objects.

    public Entity(int health, int defense)
    {
        //this.entityType = entityType;
        this.health = health;
        this.defense = defense;
        cInventory = new HashMap<String, Item>();
    }

    /*
    public void doDamage(int intDamge)
    {
        //Does damage to the entity
        health -= intDamge;
    }

    public void die()
    {
       //I think it's supposed to mean: when health is 0, die() and pop up some flavor text? Because there is die and then respawn so I can only assume respawn is the real restart function
    }
    */

    public void addToInventory(String name, Item item)
    {
        //adds an item to entities inventory
        cInventory.put(name, item);
    }

    public void dropFromInventory(String name)
    {
        //drops an item from entities inventory
        cInventory.remove(name);
    }

    public void UseItem(Character player, Item item)
    {
        if(item.getItemName() == "Healing")
        {
            player.setHealth(health += 5);
        }
        //Need to wait for more itemes
    }
    //Added getters and setters
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

    @Override
    public int Attack() {
        return 0;
    }
}
