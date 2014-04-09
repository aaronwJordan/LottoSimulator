import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class PowerBall extends lottoGame
{
    public PowerBall(int plays[])
    {
        super(plays);
    }

    public static void playGame()
    {
        int[] fiveSelect = new int[lottoGame.getMAX_PLAYS()]; // THIS IS WRONG, DO NOT USE MAX PLAYS
        // Maxplays is for all 5 plays, not the 5 numbers you're picking INSIDE a single play, change that
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Powerball! How many plays today? (Up to 5): ");
        int numberOfPlays = Integer.parseInt(userInput.nextLine());

        System.out.println("Would you like to use EASY PICK? (y/n): ");
        String easyPickChoice = String.valueOf(userInput.nextLine());

        if (easyPickChoice.equals("Y") || easyPickChoice.equals("y"))
        {
            for (int i = 0; i < 5; i++)
            {
                fiveSelect[i] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_POWERBALL_NUM());
            }
        }
        else if (easyPickChoice.equals("N") || easyPickChoice.equals("n"))
        {
            //send to another method letting user select specific numbers
        }
        else
        {
            System.out.println("You did not specify yes or no, play again to restart");
        }
    }

    public static int generateRandomIntegers(final int MIN, final int MAX)
    {
        Random rand = new Random();
        int randomInteger = rand.nextInt((MAX - MIN) + 1) + MIN;

        return randomInteger;
    }
}
