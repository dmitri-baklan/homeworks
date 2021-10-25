import java.util.ArrayList;

public class View {
    public final String GREETING_MESSAGE = "Try to guess X:";
    public final String INPUT_BIGGER_MESSAGE = " bigger than X!";
    public final String INPUT_LESS_MESSAGE = " less than X! ";
    public final String USER_INPUTS = "Your inputs history:\n";
    public final String WINNING_MESSAGE = "Congratulate, You win!\n X= ";
    public final String OUT_OF_RANGE_MESSAGE = "Incorrect number! Value should be in range: ";
    public final String INCORRECT_INPUT_MESSAGE = "Incorrect input! Enter a number, please: ";

    View() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void displayAttempts(ArrayList<Object> attempts) {// all previously inputs
        for (int i = 0; i < attempts.size(); i++) {
            System.out.print("[" + (i + 1) + "]" + attempts.get(i) + " ");
        }
        System.out.println("");
    }

    public void displayCurrentBoundaries(int min, int max) {
        System.out.println(min + "<=X<=" + max);
    }


}
