package model.entity;

public class Director extends Employee{

    public Manager[] managers;
    public String discription;

    public Director(int id, String name, String middle_name, String surname, String birth_date,
                    String employment_date, String discription) {
        super(id, name, middle_name, surname, birth_date, employment_date);
        this.discription = discription;

    }


}
