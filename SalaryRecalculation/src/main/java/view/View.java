package view;

public class View {
    static final String OBJECT_NAME = "Name";
    static final String BIRTH_DATE = "Date of birth";
    static final String EMPLOYMENT_DATE = "Date of employment";
    static final String POSITION_IN_OFFICE = "Position";
    public static final String INPUT = "Input: ";
    public static final String SPACES = "       ";      //2 tabs


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
}
