import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int attemptsLimit = 5;
        boolean playAgain = true;
        int totalScore = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain) {
            int numberToGuess = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("\nI'm thinking of a number between " + min + " and " + max + ".");
            System.out.println("You have " + attemptsLimit + " attempts to guess it!");
            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempt(s).");
                    int roundScore = 100 - (attempts - 1) * 10;
                    if (roundScore < 10) {
                        roundScore = 10;
                    }
                    totalScore += roundScore;
                    System.out.println("You earned " + roundScore + " points this round.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts. The number was: " + numberToGuess);
                System.out.println("You earned 0 points this round.");
            }
            System.out.println("Your total score: " + totalScore + " points.");
            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Game Over! Final score: " + totalScore + " points.");
            }
        }
        scanner.close();
    }
}
