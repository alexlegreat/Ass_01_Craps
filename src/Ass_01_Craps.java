import java.util.Random;
import java.util.Scanner;

public class Ass_01_Craps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain;

        do {

            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int crapsRoll = die1 + die2;


            System.out.printf("You rolled: %d + %d = %d%n", die1, die2, crapsRoll);


            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Craps! You crapped out.");
            } else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Natural! You win!");
            } else {

                int point = crapsRoll;
                System.out.printf("The point is now %d. Keep rolling!%n", point);


                boolean continueRolling = true;
                while (continueRolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    crapsRoll = die1 + die2;
                    System.out.printf("You rolled: %d + %d = %d%n", die1, die2, crapsRoll);

                    if (crapsRoll == point) {
                        System.out.println("You made your point! You win!");
                        continueRolling = false;
                    } else if (crapsRoll == 7) {
                        System.out.println("You rolled a seven! You lose.");
                        continueRolling = false;
                    } else {
                        System.out.println("Trying for point...");
                    }
                }
            }


            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
