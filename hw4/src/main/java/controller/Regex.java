package controller;

public interface Regex {
    String REGEX_NAME_LAT = "^[A-z][a-z]{1-20}$";
    String REGEX_NAME_UA = "^[А-ЩЬЮЯЇЄҐ][а-щьюяїєґ]{1-20}$";
    String REGEX_LOGIN = "^[A-Za-z0-9_-]{6-20}$";
    String REGEX_PHONE_NUMBER = "^(\\+?380)?[\\d]{9}";


}
