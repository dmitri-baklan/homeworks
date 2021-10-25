package model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Employee {     //basic class for all workers
    public int id;
    public String name;
    public String middle_name;
    public String surname;
    public Date birth_date;
    public Date employment_date;
    public boolean isActive = false;       //if employee is fired it`s false
    private int salary;
    private int birthday_bonus;
    private int premium;

    public Employee() {
    }

    ;

    public Employee(int id, String name, String middle_name, String surname,
                    Date birth_date, Date employment_date) {
        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.employment_date = employment_date;
        this.isActive = true;

    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBirthdayBonus() {
        return this.birthday_bonus;
    }

    public void setBirthdayBonus(int premium) {
        this.birthday_bonus = premium;
    }

    public void addToSalary(int addition) {
        this.salary += addition;
    }

    /*public int getNumberOfEmployees(ArrayList<Employee> employees){
        Objects.requireNonNull(employees, "Employees is null at: "+this.id);
        return employees.size();
    }*/

}
