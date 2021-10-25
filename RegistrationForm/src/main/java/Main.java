import controller.*;
import view.*;
import model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class Main {


    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }


}
