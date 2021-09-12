import controller.*;
import view.*;
import model.*;



public class Main {


    public static void main(String[] args) {
        float x = 0.5f;
        int v = 3;
        float j = x/v;
        int y = 60000;
        int c = (int)(float)(y*j);
        System.out.println(c);

        /*View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();*/
    }

}
