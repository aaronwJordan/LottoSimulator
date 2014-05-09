import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class lottoGame
{
    private static int gamePlays[][];
    private static final int MAX_PICK_NUM = 5;
    private static final int MIN_POWERBALL_NUM = 1;
    private static final int MAX_WHITEPOWERBALL_NUM = 59;
    private static final int MAX_REDPOWERBALL_NUM = 35;
    private static final int powerBallPricePerPlay = 3; // Normal price is $2 per play, we're including PowerPlay here
    private static int userWallet;

    protected static int[][] getGamePlays()
    {
        return gamePlays;
    }

    protected static void setGamePlays(int[][] array)
    {
        gamePlays = array;
    }

    protected static final int getMAX_PICK_NUM()
    {
        return MAX_PICK_NUM;
    }

    protected static final int getMIN_POWERBALL_NUM()
    {
        return MIN_POWERBALL_NUM;
    }

    protected static final int getMAX_POWERBALL_NUM()
    {
        return MAX_WHITEPOWERBALL_NUM;
    }

    protected static final int getMAX_REDPOWERBALL_NUM()
    {
        return MAX_REDPOWERBALL_NUM;
    }

    protected static int getUserWallet()
    {
        return userWallet;
    }

    protected static void setUserWallet(int amount)
    {
        userWallet = amount;
    }

    protected static int getPowerBallPricePerPlay()
    {
        return powerBallPricePerPlay;
    }

    public lottoGame(int gamePlays[][])
    {
        gamePlays = new int[MAX_PICK_NUM][MAX_PICK_NUM];
    }

    public static int generateRandomIntegers(final int MIN, final int MAX)
    {
        Random rand = new Random();
        int randomInteger = rand.nextInt((MAX - MIN) + 1) + MIN;

        return randomInteger;
    }
}
