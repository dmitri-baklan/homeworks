package model.entity;

import java.util.Date;

public class Worker extends Employee{


    public Worker(int id, String name, String middle_name, String surname,
                  Date birth_date, Date employment_date) {

        super(id, name, middle_name, surname, birth_date, employment_date);

    }
}
