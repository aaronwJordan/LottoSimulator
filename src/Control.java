import java.util.*;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class Control
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String playAgain;
        final int onTheHouse = 100; // The House is so generous
        int userChoice;

        System.out.println("\nWelcome to Aaron's Lottery Simulator!");
        System.out.println("The house has kindly given you $100.00 to start out with. Be prudent! It's all you will get.");
        lottoGame.setUserWallet(onTheHouse);
        System.out.println("Current wallet amount: $" + lottoGame.getUserWallet());
        System.out.println("---------");

        do
        {
            System.out.println("1.) PowerBall");
            System.out.println("2.) MegaMillion");
            System.out.println("3.) HotLotto");
            System.out.print("Enter the number of the game you would like to play: ");

            try {userChoice = Integer.parseInt(userInput.nextLine());}
            catch (NumberFormatException e)
            {
                System.out.println("\nPlease enter only a valid number. Restart to play again.");
                break;
            }

            switch (userChoice)
            {
                case 1:
                    PowerBall.playGame();
                    break;
                case 2:
                    MegaMillion.playGame();
                    break;
                case 3:
                    HotLotto.playGame();
                    break;
                default:
                    System.out.println("You did not enter a valid number, play again to restart.");
                    break;
            }

            System.out.print("\nWould you like to play again? (Y/N): ");
            playAgain = userInput.nextLine();
        }
        while (playAgain.equals("Y") || playAgain.equals("y"));

        System.out.println("You have left today with $" + lottoGame.getUserWallet());
        System.out.print("\nExiting..");
    }
}
