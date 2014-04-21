import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class lottoGame
{
    private static int plays[];
    private static final int MAX_PLAYS = 5;
    private static final int MIN_POWERBALL_NUM = 1;
    private static final int MAX_POWERBALL_NUM = 59;

    protected static int[] getPlays()
    {
        return plays;
    }

    protected static final int getMAX_PLAYS()
    {
        return MAX_PLAYS;
    }

    protected static final int getMIN_POWERBALL_NUM()
    {
        return MIN_POWERBALL_NUM;
    }

    protected static final int getMAX_POWERBALL_NUM()
    {
        return MAX_POWERBALL_NUM;
    }

    public lottoGame(int plays[])
    {
        plays = new int[MAX_PLAYS];
    }

    public static void foo()
    {

    }

    public static int generateRandomIntegers(final int MIN, final int MAX)
    {
        Random rand = new Random();
        int randomInteger = rand.nextInt((MAX - MIN) + 1) + MIN;

        return randomInteger;
    }
}
