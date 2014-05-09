import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class lottoGame
{
    private static int gamePlays[][];
    private static final int MIN_POWERBALL_NUM = 1;
    private static final int MAX_PICK_NUM = 5;
    private static final int MAX_WHITEPOWERBALL_NUM = 59;
    private static final int MAX_REDPOWERBALL_NUM = 35;
    private static final int powerBallPricePerPlay = 3; // Normal price is $2 per play, we're including PowerPlay here
    private static int userWallet;

    private static final int MIN_MEGABALL_NUM = 1;
    private static final int MIN_MEGAPICK_NUM = 5;
    private static final int MAX_MEGAPICK_NUM = 75;
    // Reference: http://www.lottery.ok.gov/howtoplay_megamillions.asp
    private static final int MAX_MEGABALL_NUM = 5; // The old numbers were 1-46, now it's changing to 1-15

    private static final int MIN_HOTLOTTO_NUM = 1;
    private static final int MIN_HOTPLAY_NUM = 5;
    private static final int MAX_HOTLOTTO_NUM = 47;
    private static final int MAX_HOTBALL_NUM = 19;

    protected static int[][] getGamePlays()
    {
        return gamePlays;
    }

    protected static void setGamePlays(int[][] array)
    {
        gamePlays = array;
    }

    // ----------------------------------------------------------------------------------------

    protected static final int getMAX_PICK_NUM()
    {
        return MAX_PICK_NUM;
    }

    protected static final int getMIN_POWERBALL_NUM()
    {
        return MIN_POWERBALL_NUM;
    }

    protected static final int getMAX_WHITEPOWERBALL_NUM()
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

    // -----------------------------------------------------------------------------------------

    protected static final int getMIN_MEGAPICK_NUM()
    {
        return MIN_MEGAPICK_NUM;
    }

    protected static final int getMAX_MEGAPICK_NUM()
    {
        return MAX_MEGAPICK_NUM;
    }

    protected static final int getMIN_MEGABALL_NUM()
    {
        return MIN_MEGABALL_NUM;
    }

    protected static final int getMAX_MEGABALL_NUM()
    {
        return MAX_MEGABALL_NUM;
    }

    // -----------------------------------------------------------------------------------------

    protected static final int getMIN_HOTLOTTO_NUM()
    {
        return MIN_HOTLOTTO_NUM;
    }

    protected static final int getMIN_HOTPLAY_NUM()
    {
        return MIN_HOTPLAY_NUM;
    }

    protected static final int getMAX_HOTLOTTO_NUM()
    {
        return MAX_HOTLOTTO_NUM;
    }

    protected static final int getMAX_HOTBALL_NUM()
    {
        return MAX_HOTBALL_NUM;
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
