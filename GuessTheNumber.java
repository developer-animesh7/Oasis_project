import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumber {
    public static void main(String[] args) {
        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 100;
        final int MAX_ATTEMPTS = 5;
        int score = 0;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");
        
        while (true) {
            int randomNumber = generateRandomNumber(MIN_NUMBER, MAX_NUMBER);
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < MAX_ATTEMPTS) {
                String input = JOptionPane.showInputDialog("Guess the number between "
                        + MIN_NUMBER + " and " + MAX_NUMBER + ":");
                
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game exited. Your score: " + score);
                    return;
                }

                int guessedNumber = Integer.parseInt(input);
                attempts++;

                if (guessedNumber == randomNumber) {
                    guessedCorrectly = true;
                    score += (MAX_ATTEMPTS - attempts) * 10; // Score based on remaining attempts
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in "
                            + attempts + " attempts. Your score: " + score);
                    break;
                } else if (guessedNumber < randomNumber) {
                    JOptionPane.showMessageDialog(null, "Try a higher number!");
                } else {
                    JOptionPane.showMessageDialog(null, "Try a lower number!");
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry, you didn't guess the number. It was: " + randomNumber);
            }

            int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
            if (playAgain == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for playing. Your final score: " + score);
                break;
            }
        }
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
