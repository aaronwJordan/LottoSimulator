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
        int[] fiveSelect = new int[getMAX_PLAYS()];
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to Powerball! How many plays today? (Up to 5): ");
        int numberOfPlays = Integer.parseInt(userInput.nextLine());

        System.out.println("Would you like to use EASY PICK? [The computer chooses for you] (y/n): ");
        String easyPickChoice = String.valueOf(userInput.nextLine());

        if (easyPickChoice.equals("Y") || easyPickChoice.equals("y"))
        {
            for (int i = 0; i < numberOfPlays; i++)
            {
                fiveSelect[i] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_POWERBALL_NUM());
            }
        }
        else if (easyPickChoice.equals("N") || easyPickChoice.equals("n"))
        {
            userSelectNumbers();
        }
        else
        {
            System.out.println("You did not specify yes or no, play again to restart");
        }
    }

    public static void userSelectNumbers()
    {

    }
}
