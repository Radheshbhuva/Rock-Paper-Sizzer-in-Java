import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ROCK_PAPER_SCISSOR_adv {

    static final String HISTORY_FILE = "game_history.txt";
    static int getGameCount() {
        int count = 0;
        try {
            File file = new File(HISTORY_FILE);
            if (file.exists()) {
                Scanner fs = new Scanner(file);
                while (fs.hasNextLine()) {
                    fs.nextLine();
                    count++;
                }
                fs.close();
            }
        } catch (Exception e) {
            System.out.println(RED + "Error reading game history." + RESET);
        }
        return count;
    }
    static void saveGameHistory(int gameNo, int userScore, int computerScore, String winner) {
        try {
            FileWriter writer = new FileWriter(HISTORY_FILE, true); // append mode
            writer.write("Game " + gameNo + " | ");
            writer.write("User: " + userScore + " | ");
            writer.write("Computer: " + computerScore + " | ");
            writer.write("Winner: " + winner + " | ");
            writer.write("Time: " + LocalDateTime.now() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(RED + "Error writing game history." + RESET);
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int gameNumber = getGameCount() + 1;

        String[] choices = {"Rock", "Paper", "Scissors"};
        int userScore = 0;
        int computerScore = 0;
        final int ROUNDS_TO_WIN = 3;

        System.out.println(PURPLE + BOLD + "Rock Paper Scissors - Best of 5" + RESET);
        System.out.println(CYAN + "Game History Logging Enabled" + RESET);
        System.out.println(BLUE + "Game Number: " + gameNumber + RESET);

        while (userScore < ROUNDS_TO_WIN && computerScore < ROUNDS_TO_WIN) {

            System.out.println("\nChoose:");
            System.out.println("1. Rock\n2. Paper\n3. Scissors");

            int userChoice;
            do {
                userChoice = scanner.nextInt();
                if (userChoice < 1 || userChoice > 3) {
                    System.out.println(RED + "Enter 1, 2, or 3 only!" + RESET);
                }
            } while (userChoice < 1 || userChoice > 3);

            int computerChoice = random.nextInt(3);

            System.out.println("You chose: " + choices[userChoice - 1]);
            System.out.println("Computer chose: " + choices[computerChoice]);

            if (userChoice - 1 == computerChoice) {
                System.out.println(YELLOW + "Tie!" + RESET);
            } else if ((userChoice - 1 == 0 && computerChoice == 2) ||
                    (userChoice - 1 == 1 && computerChoice == 0) ||
                    (userChoice - 1 == 2 && computerChoice == 1)) {
                System.out.println(GREEN + "You win this round!" + RESET);
                userScore++;
            } else {
                System.out.println(RED + "Computer wins this round!" + RESET);
                computerScore++;
            }

            System.out.println("Score → You: " + userScore + " | Computer: " + computerScore);
        }
        String winner;
        if (userScore > computerScore) {
            winner = "User";
            System.out.println(GREEN + "\nYou won the match!" + RESET);
        } else {
            winner = "Computer";
            System.out.println(RED + "\nComputer won the match!" + RESET);
        }

        saveGameHistory(gameNumber, userScore, computerScore, winner);

        scanner.close();
    }
}
