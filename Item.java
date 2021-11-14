public class Item
{
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

    @Override
    public String toString()
    {
        //String describing Item.
        return "";
    }
}
