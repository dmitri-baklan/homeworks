package model;

import model.entity.Department;
import model.entity.Director;
import model.entity.Manager;
import model.entity.Worker;

import java.util.ArrayList;
import java.util.Objects;

public class SalaryCounterWithMultiplier extends SalaryCounter{
    public float standart_manager_multiplier = 0.3f;
    public float standart_director_multiplier = 0.5f; // multiplier divided between all workers with same rank
    public float standart_worker_multiplier = 0.2f;

    public float current_director_multiplier;
    public float current_manager_multiplier;
    public float current_worker_multiplier;


    @Override
    public Department getSalaryForDepartment(Department department,
                                       int number_of_directors,
                                       int number_of_managers,
                                       int number_of_workers){

        department = assignSalaryForDepartment(department);
        countCurrentMult(number_of_directors,
                        number_of_managers,
                        number_of_workers);
        department = getAdditionSalaryForDepartment(department);
        return department;
    }


    @Override
    public Department getAdditionSalaryForDepartment(Department department){

        assignDirectorAdditionalSalary(department.director,
                getDirectorAddition());

        if(department.getNumber_of_managers() != 0){
            assignManagersAdditionalSalary(department.director.managers,
                    getManagerAddition());
        }

        for(Manager manager : department.director.managers){
            if(manager.getNumberOfWorkers()!= 0){
                assignWorkersAdditionalSalary(manager.workers,
                        getWorkerAddition());
            }
        }
        return department;
    }

    public void countCurrentMult(int number_of_directors,
                                 int number_of_managers,
                                 int number_of_workers){
        current_director_multiplier =
                standart_director_multiplier/number_of_directors;

        current_manager_multiplier =
                standart_manager_multiplier/number_of_managers;

        current_worker_multiplier =
                standart_worker_multiplier/number_of_workers;
    }

    public int getDirectorAddition(){
        return (int)(salary_fond * current_director_multiplier);
    }
    public int getManagerAddition(){
        return (int)(salary_fond * current_manager_multiplier);
    }
    public int getWorkerAddition(){
        return (int)(salary_fond * current_worker_multiplier);
    }
}
