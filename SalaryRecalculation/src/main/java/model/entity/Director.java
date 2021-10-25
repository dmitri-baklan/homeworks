package model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Director extends Employee {

    public ArrayList<Manager> managers;
    public String description;


    Director(int id, String name, String middle_name,
             String surname, Date birth_date,
             Date employment_date, String description) {

        super(id, name, middle_name, surname, birth_date, employment_date);
        this.description = description;

    }

    public void sortManagersBySurname() {
        for (int i = 0; i < managers.size() - 2; i++) {
            for (int j = 0; j < managers.size() - 2; j++) {
                if (managers.get(i).surname.compareTo(managers.get(i + 1).surname) > 0) {
                    Manager temp = managers.get(i);
                    managers.set(i, managers.get(i + 1));
                    managers.set(i + 1, temp);
                    continue;
                } else break;
            }

        }

    }

    public void sortManagersByEmploymnetDate() {
        for (int i = 0; i < managers.size() - 2; i++) {
            for (int j = 0; j < managers.size() - 2; j++) {
                if (managers.get(i).employment_date.getTime() > managers.get(i + 1).employment_date.getTime()) {
                    Manager temp = managers.get(i);
                    managers.set(i, managers.get(i + 1));
                    managers.set(i + 1, temp);
                    continue;
                } else break;
            }

        }
    }

}
