import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RPS_Difficulty_Winperc {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BOLD = "\u001B[1m";

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

    static final DateTimeFormatter CUSTOM_TIME_FORMAT =
            DateTimeFormatter.ofPattern("yy/MM/dd 'Time:' HH:mm:ss.SSS");

    static void saveGameHistory(int gameNo, int userScore, int computerScore,
                                String winner, String difficulty, double winPercent) {
        try {
            FileWriter writer = new FileWriter(HISTORY_FILE, true);

            String formattedTime =
                    LocalDateTime.now().format(CUSTOM_TIME_FORMAT);

            writer.write("Game " + gameNo +
                    " | Difficulty: " + difficulty +
                    " | User: " + userScore +
                    " | Computer: " + computerScore +
                    " | Winner: " + winner +
                    " | Win%: " + String.format("%.2f", winPercent) +
                    " | Time: " + formattedTime + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println(RED + "Error writing game history." + RESET);
        }
    }

    static int getComputerChoice(int difficulty, int userChoice, Random random) {

        // Easy → fully random
        if (difficulty == 1) {
            return random.nextInt(3);
        }

        // Medium → 50% smart
        if (difficulty == 2 && random.nextBoolean()) {
            return (userChoice + 1) % 3;
        }

        // Hard → 80% smart
        if (difficulty == 3 && random.nextInt(10) < 8) {
            return (userChoice + 1) % 3;
        }

        return random.nextInt(3);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int gameNumber = getGameCount() + 1;

        String[] choices = {"Rock", "Paper", "Scissors"};
        int userScore = 0;
        int computerScore = 0;
        int totalRounds = 0;
        final int ROUNDS_TO_WIN = 3;

        System.out.println(PURPLE + BOLD + "Select Difficulty:" + RESET);
        System.out.println("1. Easy\n2. Medium\n3. Hard");

        int difficulty;
        do {
            difficulty = scanner.nextInt();
        } while (difficulty < 1 || difficulty > 3);

        String difficultyName =
                difficulty == 1 ? "Easy" :
                        difficulty == 2 ? "Medium" : "Hard";

        System.out.println(CYAN + "Difficulty Selected: " + difficultyName + RESET);
        
        while (userScore < ROUNDS_TO_WIN && computerScore < ROUNDS_TO_WIN) {

            System.out.println("\n1. Rock\n2. Paper\n3. Scissors");
            int userChoice;
            do {
                userChoice = scanner.nextInt();
            } while (userChoice < 1 || userChoice > 3);

            int computerChoice = getComputerChoice(difficulty, userChoice - 1, random);

            System.out.println("You chose: " + choices[userChoice - 1]);
            System.out.println("Computer chose: " + choices[computerChoice]);

            totalRounds++;

            if (userChoice - 1 == computerChoice) {
                System.out.println(YELLOW + "Tie!" + RESET);
            } else if ((userChoice - 1 == 0 && computerChoice == 2) ||
                    (userChoice - 1 == 1 && computerChoice == 0) ||
                    (userChoice - 1 == 2 && computerChoice == 1)) {
                userScore++;
                System.out.println(GREEN + "You win this round!" + RESET);
            } else {
                computerScore++;
                System.out.println(RED + "Computer wins this round!" + RESET);
            }

            System.out.println("Score → You: " + userScore + " | Computer: " + computerScore);
        }

        String winner = userScore > computerScore ? "User" : "Computer";
        double winPercentage = ((double) userScore / totalRounds) * 100;

        System.out.println(BLUE + "\nFinal Win Percentage: " +
                String.format("%.2f", winPercentage) + "%" + RESET);

        saveGameHistory(gameNumber, userScore, computerScore,
                winner, difficultyName, winPercentage);

        scanner.close();
    }
}
