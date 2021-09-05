package controller;
import view.View;
import model.Model;

import java.util.Scanner;


public class UtilityController {

    private View view;
    private Scanner scanner;

    public UtilityController(Scanner scanner, View view){
        this.scanner = scanner;
        this.view = view;
    }

//    String InputStringValueWithScanner(String message, String regex){
//        String res;
//        view.printStringInput(message);
//        while (!(scanner.hasNext() && (res = scanner.next()).matches(regex))){
//            view.printWrongStringInput(message);
//        }
//        if(res == null)view.printMessage("RES IS NULL");
//        return res;
//    }
    String InputStringValueWithScanner(String message, String regex) {
        String res;
        view.printStringInput(message);
        while( !(scanner.hasNext() && (res = scanner.next()).matches(regex))) {
            view.printWrongStringInput(message);
        }
        return res;
    }

}
