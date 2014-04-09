import java.util.Scanner;

/**
 * Created by AaronJordan on 4/7/14.
 */
public class Control
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String playAgain = "";

        do
        {
            System.out.println("1.) PowerBall");
            System.out.println("2.) MegaMillion");
            System.out.println("3.) HotLotto");
            System.out.print("Enter the number of the game you would like to play: ");
            int userChoice = Integer.parseInt(userInput.nextLine());

            switch (userChoice)
            {
                case 1:
                    PowerBall.playGame();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("DEFAULTED!!");
                    break;
            }

            System.out.print("\nWould you like to play again? (Y/N): ");
            playAgain = userInput.nextLine();
        }
        while (playAgain.equals("Y") || playAgain.equals("y"));
        System.out.print("Exiting..");
    }
}
