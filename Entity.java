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

    public abstract void addToInventory(String name, ItemType item);

    public abstract ItemType dropFromInventory(String name);

    public abstract void UseItem(Character player, ItemType item);
    /*
    {
        if(item == ItemType.HEALING)
        {
            System.out.println(player.getHealth());
            System.out.println(player.getName() + " used " + item + " item.");
            player.setHealth(health += Dice.rollDiceSix());
            System.out.println(player.getHealth());
            System.out.println("\n");
            dropFromInventory(item.name());
        }
        //Need to wait for more itemes
    }
    */
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
