package model.entity;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee{

    public ArrayList<Worker> workers;
    public int premium;

    public Manager(int id, String name, String middle_name, String surname,
                   Date birth_date, Date employment_date) {

        super(id, name, middle_name, surname, birth_date, employment_date);
    }

    public void sortManagersBySurname(){
        for(int i = 0; i < workers.size() - 2; i++){
            for(int j = 0; j < workers.size() - 2; j++)
            {
                if(workers.get(i).surname.compareTo(workers.get(i+1).surname) > 0 ){
                    Worker temp = workers.get(i);
                    workers.set(i, workers.get(i+1));
                    workers.set(i+1, temp);
                    continue;
                }
                else break;
            }

        }

    }

    public int getPremium() {
        return premium;
    }
    public void setPremium(int premium){
        this.premium = premium;
    }


    public int getNumberOfWorkers(){
        return this.workers.size();
    }

}
