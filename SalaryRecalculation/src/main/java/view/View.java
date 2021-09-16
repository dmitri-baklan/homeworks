package view;

public class View {
    public static final String OBJECT_NAME = "Name";
    public static final String MIDDLE_NAME = "Middle name";
    public static final String SURNAME = "Surname";
    public static final String BIRTH_DATE = "Date of birth";
    public static final String EMPLOYMENT_DATE = "Date of employment";
    public static final String DESCRIPTION = "Description";
    public static final String ORGANIZATION = "Organization";
    public static final String DEPARTMENT = "Department";
    public static final String DIRECTOR = "Director";
    public static final String MANAGER = "Manager";
    public static final String WORKER = "Worker";
    public static final String CREATE_ENTITY = "Create new";
    public static final String REMOVE_ENTITY = "Remove";
    public static final String UPDATE_ENTITY = "Update";
    public static final String INPUT = "Input";
    public static final String ID = "ID";
    public static final String NUMBER = "number to";

    public void printMessage(String... message){

        System.out.println(concatenateString(message));
    }

    public String concatenateString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String str: message ){
            concatString = concatString.append(str+" ");
        }
        return new String(concatString);
    }
}
