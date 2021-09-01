import com.sun.org.apache.xpath.internal.operations.Mod;
import controller.*;
import view.*;
import model.*;



public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
        // write your code here
    }
}
