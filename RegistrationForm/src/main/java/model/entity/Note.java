package model.entity;

import java.util.ArrayList;

public class Note {

    public String secondName;
    public String firstName;
    public String login;
    public String middleName;
    public String initials;
    public String nickName;
    public String comment;
    //skipped Users group
    public String phoneNumber;
    public String officeNumber;
    public String email;
    public String skype;
    public String address;

    public class address {
        public int index;
        public String city;
        public String street;
        public String houseNumber;
        public String apartmentNumber;
    }

    public String fullAdress;
    public String dateOfAdded;
    public String dateofChanged;

    public Note(String firstName, String loginData) throws NotUniqeLoginException {
        if (DBNoteBook.checkLoginIsExist(loginData)) {
            throw new NotUniqeLoginException("Login is not uniqe!", loginData);
        }
        this.firstName = firstName;
        this.login = loginData;
    }

}
