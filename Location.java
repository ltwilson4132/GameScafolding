import java.util.ArrayList;

//ArrayList of locations somewhere.
public class Location
{
    private String locationName, locationDescription;
    int size; //How many enemies it can hold?
    ArrayList<Monster> monsters = new ArrayList<Monster>();

    public void locationSize()
    {
        //This method will set the size of the location
        Dice dice = new Dice();
        this.size = dice.rollDiceSix();
    }

    public String locationName(String name)
    {
        //This method will set the name for each location
        this.locationName = name;
        return name;
    }

    public String LocationDescription(String description)
    {
        //This method will set a description for each location
        this.locationDescription = description;
        return description;
    }

    public void removeMonster(Monster monster)
    {

    }
}
