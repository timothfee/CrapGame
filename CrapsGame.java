import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps, game over.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural, you win.");
            } else {
                System.out.println("The point is now " + sum + ". Trying for point.");
                boolean pointMade = false;

                while (!pointMade) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int newSum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + newSum);

                    if (newSum == sum) {
                        System.out.println("You made the point. You win.");
                        pointMade = true;
                    } else if (newSum == 7) {
                        System.out.println("You rolled a 7, you lose.");
                        pointMade = true;
                    } else {
                        System.out.println("Trying for point.");
                    }
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            continuePlaying = response.equals("y");
        }

        scanner.close();
    }
}

