public class Item
{
    //Need to add attributes. Changed name to just Item. Makes more sense and fixed issues elsewhere.
    //private Item item;

    //Added Attributes, Constructor, getters, and setters
    private String itemName;
    private ItemType itemType;

    public Item(String itemName, ItemType itemType)
    {
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public ItemType getItemType()
    {
        return itemType;
    }

    public void setItemType(ItemType itemType)
    {
        this.itemType = itemType;
    }

    /*
    public void addToInventory(Item item)
    {

    }


    public void removeUponUse(Item item)
    {

    }

    public void cancel()
    {

    }
    */
}
