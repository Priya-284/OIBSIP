import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int lowervalue = 1;
        int Uppervalue = 100;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number!");

        while (true) {
            int targetNumber = random.nextInt(Uppervalue - lowervalue + 1) + lowervalue;
            int No_of_attempts = 0;
            int max_No_of_attempts = 20;

            JOptionPane.showMessageDialog(null,
                    "I've generated a number between " + lowervalue + " and " + Uppervalue + ". Try to guess it!");

            while (No_of_attempts < max_No_of_attempts) {
                String GuessString = JOptionPane.showInputDialog("Enter your guess:");
                int Guess;

                try {
                    Guess = Integer.parseInt(GuessString);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                    continue;
                }

                No_of_attempts++;

                if (Guess == targetNumber) {
                    JOptionPane.showMessageDialog(null,
                            "Congratulations! You guessed the number in " + No_of_attempts + " No_of_attempts.");
                    score += max_No_of_attempts - No_of_attempts + 1;
                    break;
                } else if (Guess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Try a higher number.");
                } else {
                    JOptionPane.showMessageDialog(null, "Try a lower number.");
                }
            }

            JOptionPane.showMessageDialog(null, "Your current score: " + score);

            String playAgain = JOptionPane.showInputDialog("Do you want to play again? (yes/no)");

            if (playAgain == null || !playAgain.equalsIgnoreCase("yes")) {
                JOptionPane.showMessageDialog(null, "Thanks for playing! Your final score: " + score);
                break;
            }
        }
    }
}