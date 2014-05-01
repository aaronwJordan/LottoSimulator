import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class PowerBall extends lottoGame
{
    public PowerBall(int plays[][])
    {
        super(plays);
    }

    private static int [][] whiteBallPicks = new int[getMAX_PICK_NUM()][getMAX_PICK_NUM()];
    private static int [][] powerBallPicks = new int[getMAX_PICK_NUM()][1];

    public static void playGame()
    {   int[] fiveSelect = new int[getMAX_PICK_NUM()];
        int playCounter = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nWelcome to Powerball! How many plays today? (Up to 5): ");
        int numberOfPlays = Integer.parseInt(userInput.nextLine());

        System.out.print("Would you like to use EASY PICK? [The computer chooses for you] (y/n): ");
        String easyPickChoice = String.valueOf(userInput.nextLine());

        if (easyPickChoice.equals("Y") || easyPickChoice.equals("y"))
        {
            for (int j = 0; j < numberOfPlays; j++)
            {

                fiveSelect[j] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_POWERBALL_NUM());
                whiteBallPicks[playCounter][0] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_REDPOWERBALL_NUM());
                timeToDraw(fiveSelect);
                playCounter++;
            }
        }
        else if (easyPickChoice.equals("N") || easyPickChoice.equals("n"))
        {
            int tempCounter = 1;
            for (int k = 0; k < numberOfPlays; k++)
            {
                System.out.print("Play " + (tempCounter) + " of 5");
                userSelectNumbers(fiveSelect, playCounter);
                tempCounter++;
                playCounter++;
            }
        }
        else
        {
            System.out.println("You did not specify yes or no, play again to restart");
        }
    }

    public static void userSelectNumbers(int[] fiveSelect, int counter)
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println("\nEnter five numbers between (1-59): ");
        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            System.out.print((i + 1) + ".) ");
            fiveSelect[i] = Integer.parseInt(userInput.nextLine());
        }

        System.out.print("Pick your PowerBall number (1-35): ");
        powerBallPicks[counter][0] = Integer.parseInt(userInput.nextLine());

        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            whiteBallPicks[counter][i] = fiveSelect[i];
        }

        System.out.println("Okay! Your numbers are now selected.");
        System.out.print("\nYour numbers for your first play are: ");
        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            System.out.print(fiveSelect[i] + ", ");
        }
        System.out.println("with a PowerBall of: " + powerBallPicks[0][0]);

        timeToDraw(fiveSelect);

        //Debug purposes
        /*for (int[] arr: whiteBallPicks)
        {
            System.out.print("\n");
            System.out.println(Arrays.toString(arr));
        }

        for (int[] arr: powerBallPicks)
        {
            System.out.println(Arrays.toString(arr));
        }*/
    }

    public static void timeToDraw(int[] fiveSelect)
    {
        int[] drawCompare = new int[getMAX_PICK_NUM()];

        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            drawCompare[i] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_POWERBALL_NUM());
        }

        System.out.println("\nTime to check your numbers!");
        System.out.print("The computer has drawn: ");

        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            System.out.print(drawCompare[i] + ", ");
        }

        System.out.print("with a PowerBall of ");
    }
}
