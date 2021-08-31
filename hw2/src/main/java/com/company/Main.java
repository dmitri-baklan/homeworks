package main.java.com.company;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
         controller.startGame();
	// write your code here
    }
}
