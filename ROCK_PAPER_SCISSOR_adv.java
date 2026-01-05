import java.util.Random;
import java.util.Scanner;

public class ROCK_PAPER_SCISSOR_adv {
    // ANSI color codes
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // ANSI text formatting
    public static final String BOLD = "\u001B[1m";
    public static final String LARGE = "\u001B[5;1h"; // Larger text
    public static final String NORMAL = "\u001B[0;1h"; // Normal text
    public static final String SMALL = "\u001B[2;1h"; // Smaller text

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};
        int userScore = 0;
        int computerScore = 0;
        int roundsPlayed = 0;
        final int ROUNDS_TO_WIN = 3; // Best of 5 means first to 3 wins

        System.out.println(LARGE + PURPLE + "Welcome to Rock Paper Scissors - Best of 5!" + RESET + NORMAL);
        System.out.println(CYAN + "First player to win 3 rounds wins the game!" + RESET);

        while (userScore < ROUNDS_TO_WIN && computerScore < ROUNDS_TO_WIN) {
            roundsPlayed++;
            System.out.println("\n" + LARGE + YELLOW + "ROUND " + roundsPlayed + RESET + NORMAL);
            System.out.println(BLUE + "Current Score - You: " + userScore + " Computer: " + computerScore + RESET);
            System.out.println("\nEnter your choice:");
            System.out.println(BOLD + CYAN + "1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors" + RESET);

            // Simple input validation
            int userChoice;
            do {
                userChoice = scanner.nextInt();
                if (userChoice < 1 || userChoice > 3) {
                    System.out.println(SMALL + RED + "Please enter 1, 2, or 3 only!" + RESET + NORMAL);
                }
            } while (userChoice < 1 || userChoice > 3);

            // Generate computer's choice (0-2)
            int computerChoice = random.nextInt(3);

            // Display choices
            System.out.println("\n" + BOLD + PURPLE + "You chose: " + choices[userChoice - 1] + RESET);
            System.out.println(BOLD + PURPLE + "Computer chose: " + choices[computerChoice] + RESET);

            // Determine round winner
            if (userChoice - 1 == computerChoice) {
                System.out.println(LARGE + YELLOW + "This round is a tie! No points awarded." + RESET + NORMAL);
                roundsPlayed--; // Don't count ties as a round
            } else if ((userChoice - 1 == 0 && computerChoice == 2) ||
                    (userChoice - 1 == 1 && computerChoice == 0) ||
                    (userChoice - 1 == 2 && computerChoice == 1)) {
                System.out.println(LARGE + GREEN + "You win this round!" + RESET + NORMAL);
                userScore++;
            } else {
                System.out.println(LARGE + RED + "Computer wins this round!" + RESET + NORMAL);
                computerScore++;
            }

            // Display current score after each round
            System.out.println("\n" + BOLD + BLUE + "SCORE:" + RESET);
            System.out.println(CYAN + "You: " + userScore + " | Computer: " + computerScore + RESET);
        }

        // Game over - Display final results
        System.out.println("\n" + LARGE + YELLOW + "=== GAME OVER ===" + RESET + NORMAL);
        System.out.println(BLUE + "Final Score - You: " + userScore + " Computer: " + computerScore + RESET);
        if (userScore > computerScore) {
            System.out.println(LARGE + GREEN + "Congratulations! You won the game!" + RESET + NORMAL);
        } else {
            System.out.println(LARGE + RED + "Computer wins the game! Better luck next time!" + RESET + NORMAL);
        }

        scanner.close();
    }
}