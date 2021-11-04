import java.util.ArrayList;

public class Entity
{
    //protected String entityType;
    protected int health;
    protected int defense;
    protected ArrayList<Item> inventory = new ArrayList<Item>();//Changed to an ArrayList of Item objects instead of just Objects.

    public Entity(String entityType, int health, int defense, ArrayList<Item> inventory)
    {
        //this.entityType = entityType;
        this.health = health;
        this.defense = defense;
        this.inventory = inventory;
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

    public void addToInventory(Item item)
    {
        //adds an item to entities inventory
        inventory.add(item);
    }

    public void dropFromInventory(Item item)
    {
        //drops an item from entities inventory
        inventory.remove(item);
    }

}
