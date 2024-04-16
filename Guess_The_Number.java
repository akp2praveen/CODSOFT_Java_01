package task_01_Guess_The_Number;

import java.util.Scanner;
import java.util.Random;

public class Guess_The_Number {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);

		int rounds = 3;
		int maxAttempts = 5;
		int totalScore = 0;
		System.out.println("   *** Guess the Number ***");
		for (int round = 1; round <= rounds; round++) {
			int numberToGuess = rand.nextInt(100) + 1;
			int numberOfTries = 0;
			boolean hasGuessedCorrectly = false;

			System.out.println("\nGuess the number between 1 and 100.\n You have " + maxAttempts + " attempts."
					+ "\n\nRound " + round + ". ");

			while (!hasGuessedCorrectly && numberOfTries < maxAttempts) {
				System.out.print("\nEnter your guess: ");
				int userGuess = scanner.nextInt();
				numberOfTries++;

				if (userGuess < 1 || userGuess > 100) {
					System.out.println("Please guess a number between 1 and 100.");
				} else if (userGuess < numberToGuess) {
					System.out.println("Higher! Attempts left: " + (maxAttempts - numberOfTries));
				} else if (userGuess > numberToGuess) {
					System.out.println("Lower! Attempts left: " + (maxAttempts - numberOfTries));
				} else {
					hasGuessedCorrectly = true;
					int roundScore = calculateScore(numberOfTries, maxAttempts);
					totalScore += roundScore;
					System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " tries.");
					System.out.println("Round score: " + roundScore);
					System.out.println("Total score: " + totalScore);
				}
			}

			if (!hasGuessedCorrectly) {
				System.out.println(" \n \n You've run out of attempts. \n The number was " + numberToGuess
						+ " \n Your total score is " + totalScore + ".");
			}
		}
	}

	// Function to calculate score based on number of attempts
	private static int calculateScore(int attempts, int maxAttempts) {
		// Example formula: score = maxAttempts - attempts + 1
		return maxAttempts - attempts + 1;
	}
}
