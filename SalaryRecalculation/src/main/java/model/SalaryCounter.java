package model;

import model.entity.Department;
import model.entity.Director;
import model.entity.Manager;
import model.entity.Worker;

import java.util.ArrayList;
import java.util.Objects;

public class SalaryCounter{
    private int addition_to_salary; //addition is equal for all employee


    private int salary_fond;

    public void getSalaryForDepartment(Department department,
                                       int number_of_directors,
                                       int number_of_managers,
                                       int number_of_workers){
        assignSalaryForDepartment(department);
        countCurrentAddition(number_of_directors,
                number_of_managers,
                number_of_workers,
                this.salary_fond);
        getAdditionSalaryForDepartment(department);
    }


    public void assignSalaryForDepartment(Department department){


        Objects.requireNonNull(department,
                "Department is null!");
        Objects.requireNonNull(department.director,
                "Director is null!");

        this.salary_fond = department.getSalary_fond();
        assignDirectorDefaultSalary(department.director,
                department.default_director_salary);

        if(department.getNumber_of_managers() != 0){
            assignManagersDefaultSalary(department.director.managers,
                    department.default_manager_salary);
        }

        for(Manager manager : department.director.managers){
            if(manager.getNumberOfWorkers()!= 0){
                assignWorkersDefaultSalary(manager.workers,
                        department.default_worker_salary);
            }
        }

    }
    public void getAdditionSalaryForDepartment(Department department){


        assignDirectorAdditionalSalary(department.director,
                addition_to_salary);

        if(department.getNumber_of_managers() != 0){
            assignManagersAdditionalSalary(department.director.managers,
                    addition_to_salary);
        }

        for(Manager manager : department.director.managers){
            if(manager.getNumberOfWorkers()!= 0){
                assignWorkersAdditionalSalary(manager.workers,
                        addition_to_salary);
            }
        }
    }

    public void assignDirectorDefaultSalary(Director director,
                                            int default_director_salary){
        director.setSalary(default_director_salary);
        this.salary_fond -= default_director_salary;
    }
    public void assignManagersDefaultSalary(ArrayList<Manager> managers,
                                            int default_manager_salary){
        for(Manager manager : managers){
            manager.setSalary(default_manager_salary);
            this.salary_fond -= default_manager_salary;
        }

    }

    public void assignWorkersDefaultSalary(ArrayList<Worker> workers,
                                           int default_worker_salary){
        for(Worker worker : workers){
            worker.setSalary(default_worker_salary);
            this.salary_fond -= default_worker_salary;
        }

    }

    public void assignDirectorAdditionalSalary(Director director,
                                               int director_additional_salary){
        director.addToSalary(director_additional_salary);
        this.salary_fond -= director_additional_salary;
    }

    public void assignManagersAdditionalSalary(ArrayList<Manager> managers,
                                               int manager_additional_salary){
        for(Manager manager : managers){
            manager.addToSalary(manager_additional_salary);
            this.salary_fond -= manager_additional_salary;
        }

    }

    public void assignWorkersAdditionalSalary(ArrayList<Worker> workers,
                                              int worker_additional_salary){
        for(Worker worker : workers){
            worker.setSalary(worker_additional_salary);
            this.salary_fond -= worker_additional_salary;
        }

    }




    public void countCurrentAddition(int number_of_directors,
                                     int number_of_managers,
                                     int number_of_workers,
                                     int rest_of_salary){

        int number_of_employee = (number_of_directors +
                number_of_managers + number_of_workers);

        this.addition_to_salary = (rest_of_salary / number_of_employee);
    }


    public int getSalary_fond() {return salary_fond;}

    public void setSalary_fond(int salary_fond) {
        this.salary_fond = salary_fond;
    }
}
