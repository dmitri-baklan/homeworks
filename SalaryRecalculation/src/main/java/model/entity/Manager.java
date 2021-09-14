package model.entity;

import java.util.ArrayList;

public class Manager extends Employee{

    public ArrayList<Worker> workers;

    public Manager(int id, String name, String middle_name, String surname, String birth_date, String employment_date) {
        super(id, name, middle_name, surname, birth_date, employment_date);
    }

    public int getNumberOfWorkers(){
        return this.workers.size();
    }

}
