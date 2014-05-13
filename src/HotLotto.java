import java.util.Scanner;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class HotLotto extends lottoGame {
    public HotLotto(int plays[][])
    {
        super(plays);
    }

    private static int [][] whiteBallPicks = new int[getMIN_HOTPLAY_NUM()][getMIN_HOTPLAY_NUM()];
    private static int [][] hotBallPicks = new int[getMIN_HOTPLAY_NUM()][1];

    public static void playGame()
    {
        int[] fiveSelect = new int[getMAX_HOTBALL_NUM()];
        int playCounter = 0;
        int numberOfPlays;
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nWelcome to HotLotto!! Each play is $2.00 and each panel is a separate play.");
        System.out.println("Add a HotBall for $1.00 more to multiply your winnings! (HotPlay is always attached to each play)");
        System.out.print("How many plays today? (Up to 5): ");

        try{numberOfPlays = Integer.parseInt(userInput.nextLine());}
        catch (NumberFormatException e)
        {
            System.out.println("\nPlease enter only numbers.");
            return;
        }
        if (numberOfPlays < getMIN_HOTLOTTO_NUM() || numberOfPlays > getMAX_HOTBALL_NUM())
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
                for (int k = 0; k < getMAX_HOTBALL_NUM(); k++)
                {
                    fiveSelect[k] = generateRandomIntegers(getMIN_HOTLOTTO_NUM(), getMAX_HOTLOTTO_NUM());
                }
                hotBallPicks[computerCounter][0] = generateRandomIntegers(getMIN_HOTLOTTO_NUM(), getMAX_HOTBALL_NUM());
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
        for (int i = 0; i < getMAX_HOTBALL_NUM(); i++)
        {
            System.out.print((i + 1) + ".) ");
            fiveSelect[i] = Integer.parseInt(userInput.nextLine());
        }

        System.out.print("Pick your HotBall number (1-5): ");
        hotBallPicks[counter][0] = Integer.parseInt(userInput.nextLine());

        numbersNowSelected(fiveSelect, counter);
    }

    public static void numbersNowSelected(int[] fiveSelect, int counter)
    {
        for (int i = 0; i < getMAX_HOTBALL_NUM(); i++)
        {
            whiteBallPicks[counter][i] = fiveSelect[i];
            //counter++;
        }

        System.out.println("\nOkay! Your numbers are now selected.");
        System.out.print("\nYour numbers for play #" + (counter + 1) + ": ");
        for (int i = 0; i < getMAX_HOTBALL_NUM(); i++)
        {
            System.out.print(whiteBallPicks[counter][i] + ", ");
        }
        System.out.println("with a HotBall of: " + hotBallPicks[counter][0]);

        timeToDraw();
    }

    public static void timeToDraw()
    {
        int[] drawCompare = new int[getMAX_HOTBALL_NUM()];

        for (int i = 0; i < getMAX_HOTBALL_NUM(); i++)
        {
            drawCompare[i] = generateRandomIntegers(getMIN_HOTLOTTO_NUM(), getMAX_HOTLOTTO_NUM());
        }

        System.out.println("\nTime to check your numbers!");
        System.out.print("The computer has drawn: ");

        for (int i = 0; i < getMAX_HOTBALL_NUM(); i++)
        {
            System.out.print(drawCompare[i] + ", ");
        }

        int tempPowerBall = generateRandomIntegers(getMIN_HOTLOTTO_NUM(), getMAX_HOTBALL_NUM());
        System.out.printf("with a HotBall of %d", tempPowerBall);

        anyMatching(drawCompare, tempPowerBall);
    }

    public static void anyMatching(int[] compareTo, int computerPowerBall)
    {
        boolean powerBallHit = false;
        int matchHit = 0;
        int rowCounter = 0;
        int powerBallCounter = 0;
        for (int i = 0; i < getMAX_HOTBALL_NUM(); i++)
        {
            for (int k = 0; k < getMAX_HOTBALL_NUM(); k++)
            {
                if (compareTo[k] == whiteBallPicks[rowCounter][i])
                {
                    matchHit++;
                    whiteBallPicks[rowCounter][i] = 0; // Setting each element to 0 so they don't get counted again
                    break;
                }
            }

            if (computerPowerBall == hotBallPicks[powerBallCounter][0])
            {
                //matchHit++; don't want the user to think they got x matching AND a powerball matching
                powerBallHit = true;
            }
            powerBallCounter++;
        }

        System.out.println("\nYou have " + matchHit + " matching number(s)!");
        if (powerBallHit)
        {
            System.out.println("You have a matching HotBall!");
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
                setUserWallet(getUserWallet() + 6);
                System.out.print("You won $6.00!");
                break;
            case 4:
                setUserWallet(getUserWallet() + 100);
                System.out.print("You won $100.00!");
                break;
            case 5:
                setUserWallet(getUserWallet() + 30000);
                System.out.print("You won $30,000!");
                break;
            default:
                System.out.println("Defaulted!");
                break;
        }

        // Can't use booleans inside switches, otherwise I would have
        if (powerBallHit)
        {
            setUserWallet(getUserWallet() + 2);
            System.out.print("You won $2.00!");
        }
        else if (powerBallHit && matchHit == 1)
        {
            setUserWallet(getUserWallet() + 3);
            System.out.print("You won $3.00!");
        }
        else if (powerBallHit && matchHit == 2)
        {
            setUserWallet(getUserWallet() + 6);
            System.out.print("You won $6.00!");
        }
        else if (powerBallHit && matchHit == 3)
        {
            setUserWallet(getUserWallet() + 50);
            System.out.print("You won $50.00!");
        }
        else if (powerBallHit && matchHit == 4)
        {
            setUserWallet(getUserWallet() + 3000);
            System.out.print("You won $3,000!");
        }
        else if (powerBallHit && matchHit == 5)
        {
            int grandPrize = generateRandomIntegers(1000000, 1000000000); // Between 1,000,000 and 1,000,000,000
            System.out.print("YOU WON THE GRAND PRIZE!!!!" + grandPrize);
        }
    }
}
