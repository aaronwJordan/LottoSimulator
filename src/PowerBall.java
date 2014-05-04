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
    {
        int[] fiveSelect = new int[getMAX_PICK_NUM()];
        int playCounter = 0;
        int numberOfPlays;
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nWelcome to PowerBall! How many plays today? (Up to 5): ");

        try{numberOfPlays = Integer.parseInt(userInput.nextLine());}
        catch (NumberFormatException e)
        {
            System.out.println("\nPlease enter only numbers.");
            return;
        }
        if (numberOfPlays < getMIN_POWERBALL_NUM() || numberOfPlays > getMAX_PICK_NUM())
        {
            System.out.println("\nPlease enter only a valid number of plays.");
            return;
        }

        System.out.print("Would you like to use EASY PICK? [The computer chooses for you] (y/n): ");
        String easyPickChoice = String.valueOf(userInput.nextLine());

        if (easyPickChoice.equals("Y") || easyPickChoice.equals("y"))
        {
            int computerCounter = 0;
            for (int j = 0; j < numberOfPlays; j++)
            {
                for (int k = 0; k < getMAX_PICK_NUM(); k++)
                {
                    fiveSelect[k] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_POWERBALL_NUM());
                }
                powerBallPicks[computerCounter][0] = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_REDPOWERBALL_NUM());
                numbersNowSelected(fiveSelect, computerCounter);
                //timeToDraw(fiveSelect);
                computerCounter++;
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

        numbersNowSelected(fiveSelect, counter);
    }

    public static void numbersNowSelected(int[] fiveSelect, int counter)
    {
        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            whiteBallPicks[counter][i] = fiveSelect[i];
            //counter++;
        }

        System.out.println("Okay! Your numbers are now selected.");
        System.out.print("\nYour numbers for your first play are: ");
        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            System.out.print(whiteBallPicks[0][i] + ", ");
        }
        System.out.println("with a PowerBall of: " + powerBallPicks[0][0]);

        timeToDraw(fiveSelect);
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

        int tempPowerBall = generateRandomIntegers(getMIN_POWERBALL_NUM(), getMAX_REDPOWERBALL_NUM());
        System.out.printf("with a PowerBall of %d", tempPowerBall);

        anyMatching(fiveSelect, drawCompare, tempPowerBall);
    }

    public static void anyMatching(int[] fiveSelect, int[] compareTo, int computerPowerBall)
    {
        boolean powerBallHit = false;
        int matchHit = 0;
        int rowCounter = 0;
        int powerBallCounter = 0;
        for (int i = 0; i < getMAX_PICK_NUM(); i++)
        {
            for (int k = 0; k < getMAX_PICK_NUM(); k++)
            {
                if (compareTo[k] == whiteBallPicks[rowCounter][i])
                {
                    matchHit++;
                    whiteBallPicks[rowCounter][i] = 0; // Setting each element to 0 so they don't get counted again
                    break;
                }
            }

            if (computerPowerBall == powerBallPicks[powerBallCounter][0])
            {
                //matchHit++; don't want the user to think they got x matching AND a powerball matching
                powerBallHit = true;
            }

            //rowCounter++;
            powerBallCounter++;
        }

        System.out.println("\nYou have " + matchHit + " matching number(s)!");
        if (powerBallHit)
            System.out.println("You have a matching PowerBall!");
    }
}



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