import java.util.Scanner;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class MegaMillion extends lottoGame {
    public MegaMillion(int plays[][])
    {
        super(plays);
    }

    private static int [][] whiteBallPicks = new int[getMIN_MEGABALL_NUM()][getMIN_MEGABALL_NUM()];
    private static int [][] megaBallPicks = new int[getMIN_MEGABALL_NUM()][1];

    public static void playGame()
    {
        int[] fiveSelect = new int[getMIN_MEGAPICK_NUM()];
        int playCounter = 0;
        int numberOfPlays;
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nWelcome to MegaMillions!! Each play is $2.00 and each panel is a separate play.");
        System.out.println("Add a MegaPlay for $1.00 more to multiply your winnings! (MegaPlay is always attached to each play)");
        System.out.print("How many plays today? (Up to 5): ");

        try{numberOfPlays = Integer.parseInt(userInput.nextLine());}
        catch (NumberFormatException e)
        {
            System.out.println("\nPlease enter only numbers.");
            return;
        }
        if (numberOfPlays < getMIN_MEGABALL_NUM() || numberOfPlays > getMIN_MEGAPICK_NUM())
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
                setUserWallet(getUserWallet() - getPowerBallPricePerPlay());
                for (int k = 0; k < getMIN_MEGAPICK_NUM(); k++)
                {
                    fiveSelect[k] = generateRandomIntegers(getMIN_MEGABALL_NUM(), getMAX_MEGAPICK_NUM());
                }
                megaBallPicks[computerCounter][0] = generateRandomIntegers(getMIN_MEGAPICK_NUM(), getMAX_MEGABALL_NUM());
                numbersNowSelected(fiveSelect, computerCounter);
                computerCounter++;
            }
        }
        else if (easyPickChoice.equals("N") || easyPickChoice.equals("n"))
        {
            int tempCounter = 1;
            for (int k = 0; k < numberOfPlays; k++)
            {
                setUserWallet(getUserWallet() - getPowerBallPricePerPlay());
                System.out.print("\nPlay " + (tempCounter) + " of 5");
                userSelectNumbers(fiveSelect, playCounter);
                tempCounter++;
                playCounter++;
            }
        }
        else
        {
            System.out.println("You did not specify yes or no, play again to restart");
        }

        System.out.println("\nYour current wallet amount: $" + getUserWallet());
    }

    public static void userSelectNumbers(int[] fiveSelect, int counter)
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println("\nEnter five numbers between (1-75): ");
        for (int i = 0; i < getMIN_MEGAPICK_NUM(); i++)
        {
            System.out.print((i + 1) + ".) ");
            fiveSelect[i] = Integer.parseInt(userInput.nextLine());
        }

        System.out.print("Pick your MegaBall number (1-5): ");
        megaBallPicks[counter][0] = Integer.parseInt(userInput.nextLine());

        numbersNowSelected(fiveSelect, counter);
    }

    public static void numbersNowSelected(int[] fiveSelect, int counter)
    {
        for (int i = 0; i < getMIN_MEGAPICK_NUM(); i++)
        {
            whiteBallPicks[counter][i] = fiveSelect[i];
            //counter++;
        }

        System.out.println("\nOkay! Your numbers are now selected.");
        System.out.print("\nYour numbers for play #" + (counter + 1) + ": ");
        for (int i = 0; i < getMIN_MEGAPICK_NUM(); i++)
        {
            System.out.print(whiteBallPicks[counter][i] + ", ");
        }
        System.out.println("with a MegaBall of: " + megaBallPicks[counter][0]);

        timeToDraw();
    }

    public static void timeToDraw()
    {
        int[] drawCompare = new int[getMIN_MEGAPICK_NUM()];

        for (int i = 0; i < getMIN_MEGAPICK_NUM(); i++)
        {
            drawCompare[i] = generateRandomIntegers(getMIN_MEGABALL_NUM(), getMAX_MEGAPICK_NUM());
        }


        System.out.println("\nTime to check your numbers!");
        System.out.print("The computer has drawn: ");

        for (int i = 0; i < getMIN_MEGAPICK_NUM(); i++)
        {
            System.out.print(drawCompare[i] + ", ");
        }

        int tempPowerBall = generateRandomIntegers(getMIN_MEGABALL_NUM(), getMAX_MEGABALL_NUM());
        System.out.printf("with a MegaBall of %d", tempPowerBall);

        anyMatching(drawCompare, tempPowerBall);
    }

    public static void anyMatching(int[] compareTo, int computerPowerBall)
    {
        boolean powerBallHit = false;
        int matchHit = 0;
        int rowCounter = 0;
        int powerBallCounter = 0;
        for (int i = 0; i < getMIN_MEGAPICK_NUM(); i++)
        {
            for (int k = 0; k < getMIN_MEGAPICK_NUM(); k++)
            {
                if (compareTo[k] == whiteBallPicks[rowCounter][i])
                {
                    matchHit++;
                    whiteBallPicks[rowCounter][i] = 0; // Setting each element to 0 so they don't get counted again
                    break;
                }
            }

            if (computerPowerBall == megaBallPicks[powerBallCounter][0])
            {
                //matchHit++; don't want the user to think they got x matching AND a powerball matching
                powerBallHit = true;
            }
            powerBallCounter++;
        }

        System.out.println("\nYou have " + matchHit + " matching number(s)!");
        if (powerBallHit)
        {
            System.out.println("You have a matching MegaBall!");
        }

        switch (matchHit)
        {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                setUserWallet(getUserWallet() + 5);
                System.out.print("You won $5.00!");
                break;
            case 4:
                setUserWallet(getUserWallet() + 500);
                System.out.print("You won $500.00!");
                break;
            case 5:
                setUserWallet(getUserWallet() + 1000000);
                System.out.print("You won $1,000,000!");
                break;
            default:
                System.out.println("Defaulted!");
                break;
        }

        // Can't use booleans inside switches, otherwise I would have
        if (powerBallHit)
        {
            setUserWallet(getUserWallet() + 1);
            System.out.print("You won $1.00!");
        }
        else if (powerBallHit && matchHit == 1)
        {
            setUserWallet(getUserWallet() + 2);
            System.out.print("You won $2.00!");
        }
        else if (powerBallHit && matchHit == 2)
        {
            setUserWallet(getUserWallet() + 5);
            System.out.print("You won $5.00!");
        }
        else if (powerBallHit && matchHit == 3)
        {
            setUserWallet(getUserWallet() + 50);
            System.out.print("You won $50.00!");
        }
        else if (powerBallHit && matchHit == 4)
        {
            setUserWallet(getUserWallet() + 5000);
            System.out.print("You won $5,000!");
        }
        else if (powerBallHit && matchHit == 5)
        {
            int grandPrize = generateRandomIntegers(2000000, 1000000000); // Between 1,000,000 and 1,000,000,000
            System.out.print("YOU WON THE GRAND PRIZE!!!!" + grandPrize);
        }
    }
}
