import java.util.ArrayList;
import java.util.Scanner;

//import java.com.company.Model;
//import java.com.company.View;

//import com.company.Model;
//import com.company.View;

public class Controller {

    Model model;
    View view;


    ArrayList<Object> attempts = new ArrayList<Object>();


    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void startGame(){
        int input = -1;
        model.generateRandNumber();

        do{
            Scanner sc = new Scanner(System.in);
            view.printMessage(view.GREETING_MESSAGE);
            view.displayCurrentBoundaries(model.getMinBoundary(), model.getMaxBoundary());
            view.printMessage(view.USER_INPUTS);
            view.displayAttempts(attempts);


            //view.printMessage(Integer.toString(model.getX_value()));

            if(!sc.hasNextInt()){
                view.printMessage(view.INCORRECT_INPUT_MESSAGE);
                continue;
            }
            input = sc.nextInt();

            if(!model.checkInputInRange(input)){
                view.printMessage(view.OUT_OF_RANGE_MESSAGE);
                continue;
            }


            attempts.add(input);

            if(model.checkWin(input)){
                view.printMessage(view.WINNING_MESSAGE + model.getX_value());
                return;
            }
            if(model.checkIsBiggerThanX(input)){
                model.setMaxBoundary(input);
                view.printMessage("\""+input+"\""+view.INPUT_BIGGER_MESSAGE);
                continue;
            }
            else{
                model.setMinBoundary(input);
                view.printMessage("\""+input+"\""+view.INPUT_LESS_MESSAGE);
                continue;
            }

        }while(!model.checkWin(input));

    }

}
