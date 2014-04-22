import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class lottoGame
{
    private static int gamePlays[][];
    private static final int MAX_PICK_NUM = 5;
    private static final int MIN_POWERBALL_NUM = 1;
    private static final int MAX_POWERBALL_NUM = 59;
    private static final int MAX_REDPOWERBALL_NUM = 35;

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
        return MAX_POWERBALL_NUM;
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
