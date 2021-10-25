package controller;

import model.entity.NotUniqeLoginException;
import model.entity.Note;
import view.View;

import java.util.Scanner;

import static view.TextConstant.FIRST_NAME;
import static view.TextConstant.LOGIN_DATA;
import static view.TextConstant.PHONE_NUMBER_DATA;

public class InputNoteNoteBook {
    String REGEX_NAME_LAT = "^[A-z][a-z]{1,20}$";
    String REGEX_NAME_UA = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_LOGIN = "^[A-Za-z0-9_-]{6,20}$";
    String REGEX_PHONE_NUMBER = "^(\\+?380)?[\\d]{9}";

    private View view;
    private Scanner sc;

    private String firstName;
    private String login;
    private String localeData;
    UtilityController utilityController;

    public InputNoteNoteBook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
        this.utilityController = new UtilityController(this.sc, this.view);
    }

    public void InputNote() {
        setLocaleData();
        InputFirstName();
        InputLoginData();
//        this.note.phoneNumber = utilityController.InputStringValueWithScanner(PHONE_NUMBER_DATA, REGEX_PHONE_NUMBER);
    }

    public void setLocaleData() {
        localeData = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_NAME_UA : REGEX_NAME_LAT;
    }

    public void InputFirstName() {
        firstName = utilityController.InputStringValueWithScanner(
                FIRST_NAME, localeData);
    }

    public void InputLoginData() {
        login = utilityController.InputStringValueWithScanner(
                LOGIN_DATA, REGEX_LOGIN);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }
}


