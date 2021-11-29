import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        //Game myGame = new Game();

        //myGame.StartGame();

        //myGame.PlayGame();
        Character player = new Character("Logan", CharacterType.ARCHER, 100, 10);
        Location location = new Location("test", "test", 0);
        player.setCurrentLocation(location);
        WriteFile.SavePlayer(player);
    }//end main method
}//end class Driver
