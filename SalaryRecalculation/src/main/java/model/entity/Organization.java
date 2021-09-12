package model.entity;

import model.SalaryCounterWithMultiplier;

public class Organization {
//    public int number_of_employee;
//    public int number_of_directors;
//    public int number_of_managers;
//    public int number_of_workers;



    public SalaryCounterWithMultiplier salaryCounterWithMultiplier;

    public Department[] departments;

    public boolean isGeneralSalaryFond = true; // salary fond is general for all workers by default

    private int salary_fond;
    private int bonus = 1000;   //default bonus for birthday



    public void setSalaryForAll(){
        int number_of_depatments = departments.length;
        if(isGeneralSalaryFond){

        }
    }

    public void countSalary(){

    }

    public void setSalary_fond(int salary_fond){
        this.salary_fond = salary_fond;
    }


}
