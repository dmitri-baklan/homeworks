package view;
import java.util.Locale;
import java.util.ResourceBundle;



public class View {
    public String INPUT_STRING_DATA = "input.string.data";
    public String FIRST_NAME = "input.first.name.data";
    public String LOGIN_DATA = "input.login.data";
    public String INPUT_WRONG_DATA = "input.wrong.data";
    static String MESSAGES_BUNDLE_NAME = "message";

    public static final ResourceBundle bundle =
            ResourceBundle.getBundle("message",
//                    new Locale("ua"));
                    new Locale ("en"));

    public void printMessage(String message){
        System.out.println(message);
    }

    public String concatenateString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String str: message ){
            concatString = concatString.append(message);
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
