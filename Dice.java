/*
 * -------------------------------------------------------------------------------
 * File name: Dice.java
 * Project name: Dice
 * -------------------------------------------------------------------------------
 * Author's name and email: Logan Wilson wilsonlt@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Oct 27, 2021
 * Last modified: Logan Wilson wilsonlt@etsu.edu Oct 27, 2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Dice<br>
 * Class Purpose:  <br>
 *
 * <hr>
 * Date created: Oct 27, 2021<br>
 * Last modified: Oct 27, 2021
 * @author Logan Wilson
 */
import java.util.Random;

public class Dice
{
    private static Random randNum = new Random();

    public static int rollDiceSix()
    {
        //Generates random number between 1 and 6.
        return (randNum.nextInt(6) + 1);
    }

    public static int rollDiceTwenty()
    {
        //Generates random number between 1 and 20.
        return (randNum.nextInt(20) + 1);
    }
    
    public static int generateRandomNum(int limit)
    {
        //This method will be used to generate a random number between 0 and the limit or 1 and the limit.
        return randNum.nextInt(limit);
    }

    public static int RandomRange(int lower, int upper)
    {
        //Generates a random number between the upper and lower limits inclusively.
        return ((int)(Math.random() * (upper - lower + 1)) + lower);
    }
}//end class Dice
