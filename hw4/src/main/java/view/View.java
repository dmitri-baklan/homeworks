package view;
import java.util.Locale;
import java.util.ResourceBundle;

import static view.TextConstant.INPUT_STRING_DATA;
import static view.TextConstant.INPUT_WRONG_DATA;


public class View {

    static String MESSAGES_BUNDLE_NAME = "messages";

    public View(){
        System.out.println();
    }

    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
//                    new Locale("ua", "UA"));
                    new Locale ("en"));

    public void printMessage(String... message){

        System.out.println(concatenateString(message));
    }

    public String concatenateString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String str: message ){
            concatString = concatString.append(str);
        }
        return new String(concatString);
    }

    public void printStringInput(String message){
        printMessage(concatenateString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));

    }

    public void printWrongStringInput(String message){
        printMessage(concatenateString(
                bundle.getString(INPUT_WRONG_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }



}
