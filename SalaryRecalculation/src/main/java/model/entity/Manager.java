package model.entity;

public class Manager extends Employee{
    public Worker[] workers;

    public Manager(int id, String name, String middle_name, String surname, String birth_date, String employment_date) {
        super(id, name, middle_name, surname, birth_date, employment_date);
    }
}