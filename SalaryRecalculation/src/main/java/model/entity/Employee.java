package model.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Employee {     //basic class for all workers
    public int id;
    public String name;
    public String middle_name;
    public String surname;
    public String birth_date;
    public String employment_date;
    public boolean isActive = false;       //if employee is fired it`s false
    private int salary;
    private int premium;
    public Employee(int id, String name, String middle_name, String surname,
                    String birth_date, String employment_date){
        this.id = id;
        this.name = name;
        this.middle_name = middle_name;
        this. surname = surname;
        this.birth_date = birth_date;
        this.employment_date = employment_date;
        this.isActive = true;

    }
    public int getId(){return id;}
    public int getSalary(){ return this.salary;}
    public void setSalary(int salary){ this.salary = salary;}
    public int getPremium(){ return this.premium;}
    public void setPremium(int premium){ this.premium = premium;}

    public void addToSalary(int addition){
        this.salary += addition;
    }

    /*public int getNumberOfEmployees(ArrayList<Employee> employees){
        Objects.requireNonNull(employees, "Employees is null at: "+this.id);
        return employees.size();
    }*/

}
