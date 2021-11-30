import java.util.Scanner;

public class Driver
{
    public static void main(String[] args)
    {
        Game myGame = new Game();

        myGame.StartGame();

        Character player = new Character();
        ReadFile.loadPlayer(myGame.getGameMap(), player);
        System.out.println(player.getName() + "\n" +
                player.getType().value + "\n" +
                player.getCurrentLocation().getLocationName() + "\n" +
                player.getHealth() + "\n" +
                player.getDefense() + "\n" +
                player.getAttackBoost() + "\n" +
                player.getDefenseBoost() + "\n");
        player.Inventory();
        //myGame.PlayGame();
        //Character player = new Character("Logan", CharacterType.ARCHER, 100, 10);
        //Location location = new Location("test", "test", 0);
        //player.setCurrentLocation(location);
        //WriteFile.SavePlayer(player);
    }//end main method
}//end class Driver
