/*
 * -------------------------------------------------------------------------------
 * File name: Dice.java
 * Project name: Semester Project
 * -------------------------------------------------------------------------------
 * Author's name and email: Logan Wilson wilsonlt@etsu.edu
 * Course-Section: CSCI-1250-900
 * Creation Date: Nov 12, 2021
 * Last modified: Logan Wilson wilsonlt@etsu.edu Nov 29, 2021
 * -------------------------------------------------------------------------------
 */

/*
 * Class Name: Dice<br>
 * Class Purpose:  The class is used for random number generation for monster spawning and attacking<br>
 *
 * <hr>
 * Date created: Nov 14, 2021<br>
 * Last modified: Nov 29, 2021
 * @author Logan Wilson
 */
import java.util.Random;

public class Dice
{
    private static Random randNum = new Random();

    /*
     * Method Name: rollDiceSix<br>
     * Method Purpose: This method generates a random number between 1 and 6 inclusively.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns random generated integer between 1 and 6
     */
    public static int rollDiceSix()
    {
        //Generates random number between 1 and 6.
        return (randNum.nextInt(6) + 1);
    }//end rollDiceSix

    /*
     * Method Name: rollDiceTwenty<br>
     * Method Purpose: This method generates a random number between 1 and 20 inclusively.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param none
     * @returns random generated integer between 1 and 20
     */
    public static int rollDiceTwenty()
    {
        //Generates random number between 1 and 20.
        return (randNum.nextInt(20) + 1);
    }//end rollDiceTwenty

    /*
     * Method Name: generateRandomNum<br>
     * Method Purpose: This method generates a random number between 0 and the integer value passed in not including
     * the limit.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param limit: integer that is the upper limit of what can be generated.
     * @returns random generated integer between 0 and limit not inclusive
     */
    public static int generateRandomNum(int limit)
    {
        //This method will be used to generate a random number between 0 and the limit.
        return randNum.nextInt(limit);
    }//end generateRandomNum

    /*
     * Method Name: RandomRange<br>
     * Method Purpose: This method generates a random number between the lower and upper value passed in inclusively.<br>
     *
     * <hr>
     * Date created: Nov 14, 2021<br>
     * Date last modified: Nov 29, 2021<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     * @param1 lower: integer for lower limit
     * @param2 upper: integer for upper limit
     * @returns random generated integer between lower and upper inclusive
     */
    public static int RandomRange(int lower, int upper)
    {
        //Generates a random number between the upper and lower limits inclusively.
        return ((int)(Math.random() * (upper - lower + 1)) + lower);
    }//end RandomRange
}//end class Dice
