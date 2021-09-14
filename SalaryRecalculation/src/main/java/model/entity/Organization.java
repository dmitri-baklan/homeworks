package model.entity;

import model.SalaryCounterWithMultiplier;

import java.util.ArrayList;

public class Organization {
//    public int number_of_employee;
    public int number_of_directors;
    public int number_of_managers;
    public int number_of_workers;



    public SalaryCounterWithMultiplier salaryCounterWithMultiplier;
    public ArrayList<Department> departments;
    public ArrayList<Worker> fired_workers;

    public boolean isGeneralSalaryFond = true; // salary fond is general for all workers by default

    private int salary_fond;
    private int bonus = 1000;   //default bonus for birthday

    public Organization(){
        this.salaryCounterWithMultiplier = new SalaryCounterWithMultiplier();

    }

    public void setSalaryForAllEmployee(){

        int number_of_depatments = departments.size();
        if(isGeneralSalaryFond && (number_of_depatments != 0)){    //if fond is general all departments get equal parts
            int fond_part = salary_fond / departments.size();
            for(Department department : departments){
                department.setSalary_fond(fond_part);
                salaryCounterWithMultiplier.getSalaryForDepartment(
                        department, number_of_directors,
                        number_of_managers,number_of_workers);
            }

        }

        else{
            for(Department department : departments){
                salaryCounterWithMultiplier.getSalaryForDepartment(
                        department, 1,                           //in this case each department has its
                        department.getNumber_of_managers(),                      // own multiplier for workers
                        department.getNumber_of_workers());
            }
        }
    }

    public void countSalary(){

    }

    public void setSalary_fond(int salary_fond){
        this.salary_fond = salary_fond;
    }


}
