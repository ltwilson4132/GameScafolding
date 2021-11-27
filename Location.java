import java.util.ArrayList;

public class Location
{
    private String locationName, locationDescription;
    final int size; //How many enemies it can hold
    private ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Location(String locationName, String locationDescription, int size)
    {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.size = size; //Equals max size that location can hold
        //Generates random number of Monsters between 0 and the max size of the location and adds them to the ArrayList
    }

    public String getLocationName()
    {
        return locationName;
    }

    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    public String getLocationDescription()
    {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription)
    {
        this.locationDescription = locationDescription;
    }

    public int getSize()
    {
        return size;
    }

    public String getMonsters()
    {
        //Outputs String representing all monster at location.
        return "";
    }

    public void AddMonster(Monster monster)
    {
        //Adds a new monster to the location's ArrayList
    }

    public void removeMonster(Monster monster)
    {
        //Removes a monster from the ArrayList when one is killed
    }
    
    public void ClearMonsters()
    {
        monsters.clear();
    }
}
