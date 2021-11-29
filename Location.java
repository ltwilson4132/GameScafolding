import java.util.ArrayList;

public class Location
{
    private String locationName, locationDescription;
    private int size;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Location(String locationName, String locationDescription, int size)
    {
        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.size = size;
    }

    //Method that gets the name of a Location;
    public String getLocationName()
    {
        return locationName;
    }

    //Method that sets the name of a Location
    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }

    //Method that gets the description of a Location
    public String getLocationDescription()
    {
        return locationDescription;
    }

    //Method that will set the description of a Location
    public void setLocationDescription(String locationDescription)
    {
        this.locationDescription = locationDescription;
    }

    //Method that gets the size of a Location
    public int getSize()
    {
        return size;
    }

    //Method that prints out all the monsters in an area
    public String getMonsters()
    {
        String monsterList;

        monsterList = "Monsters in this Location: " + monsters + "\n";
        for (Monster monster:monsters) //Lists every monster in that location
        {
            monsterList += monster + "\n";
        }
        return monsterList;
    }

    //Method that adds a monster to the Location's ArrayList
    public void addMonster(Monster monster)
    {
        monsters.add(monster);
    }

    //Method that removes a monster from the ArrayList when it is killed
    public void removeMonster(Monster monster)
    {
        monsters.remove(monster);
    }
}//end class Location
