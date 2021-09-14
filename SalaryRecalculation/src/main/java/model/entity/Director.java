package model.entity;

import java.util.ArrayList;

public class Director extends Employee{

    public ArrayList<Manager> managers;
    public String description;

    public Director(int id, String name, String middle_name, String surname, String birth_date,
                    String employment_date, String description) {
        super(id, name, middle_name, surname, birth_date, employment_date);
        this.description = description;

    }


}
