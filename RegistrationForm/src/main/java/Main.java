import controller.*;
import view.*;
import model.*;

import java.util.ArrayList;
import java.util.Objects;


public class Main {


    public static void main(String[] args) {
        int x = 60000;
        int y = 7;
        int c = (x/y);
        System.out.println(c);

        View view = new View();
//        Objects.requireNonNull(view.in, "View:"+view.MESSAGES_BUNDLE_NAME);
//        System.out.println(view.in);
        /*Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();*/
    }

}
