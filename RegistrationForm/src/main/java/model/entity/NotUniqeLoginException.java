package model.entity;

public class NotUniqeLoginException extends Exception {

    private String loginData;

    public String getLoginData() {
        return this.loginData;
    }

    public NotUniqeLoginException(String message, String loginData) {
        super(message);
        this.loginData = loginData;

    }

}
