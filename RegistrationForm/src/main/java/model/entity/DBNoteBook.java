package model.entity;

public enum DBNoteBook {
    NOTE_ONE("Pavlo", "Zibrov1"),
    NOTE_TWO("Віктор", "Petrovich10012001"),
    NOTE_THREE("Станіслав", "Shpagatov123");


    private final String firstName;
    private final String login;

    DBNoteBook(String firstName, String login) {
        this.firstName = firstName;
        this.login = login;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLogin() {
        return this.login;
    }

    public static boolean checkLoginIsExist(String loginData) {
        for (DBNoteBook note : DBNoteBook.values()) {
            if (note.getLogin().equals(loginData)) {
                return true;
            }
        }
        return false;
    }


}
