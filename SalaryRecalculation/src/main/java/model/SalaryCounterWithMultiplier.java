package model;

import model.entity.Department;

public class SalaryCounterWithMultiplier {
    public float standart_director_multiplier = 0.5f; // multiplier divided between all workers with same rank
    public float standart_manager_multiplier = 0.3f;
    public float standart_worker_multiplier = 0.2f;

    public float current_director_multiplier;
    public float current_manager_multiplier;
    public float current_worker_multiplier;

    public int salary_fond;

    public SalaryCounterWithMultiplier(int salary_fond){
        this.salary_fond = salary_fond;
    }

    public void countSalaryForDepartment(Department department){

    }



    public void countCurrentMult(int number_of_directors, int number_of_managers,
                                 int number_of_workers){
        current_director_multiplier = standart_director_multiplier/number_of_directors;
        current_manager_multiplier = standart_manager_multiplier/number_of_managers;
        current_worker_multiplier = standart_worker_multiplier/number_of_workers;
    }


}
