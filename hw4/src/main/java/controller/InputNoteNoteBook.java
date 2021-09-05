package controller;
import view.View;

import java.util.Scanner;

import static view.TextConstant.FIRST_NAME;
import static view.TextConstant.LOGIN_DATA;

public class InputNoteNoteBook {
    String REGEX_NAME_LAT = "^[A-z][a-z]{1,20}$";
    String REGEX_NAME_UA = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_LOGIN = "^[A-Za-z0-9_-]{6,20}$";
    String REGEX_PHONE_NUMBER = "^\\+380[?\\d]{9}";
    private View view;
    private Scanner sc;
    public Note note;
    public InputNoteNoteBook(View view, Scanner sc){
        this.view = view;
        this.sc = sc;
        this.note = new Note();
    }

    public void InputNote(){
        UtilityController utilityController =
                new UtilityController(sc, view);
        String str = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? REGEX_NAME_UA : REGEX_NAME_LAT;
        this.note.firstName = utilityController.InputStringValueWithScanner(FIRST_NAME, str);
        this.note.login = utilityController.InputStringValueWithScanner(LOGIN_DATA, REGEX_LOGIN);
        System.out.println(this.note.firstName);
        System.out.println(this.note.login);
    }

}


