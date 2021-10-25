package model.entity;

import java.util.Objects;

public class Department {

    /*public int number_of_directors = 1;//all departments has only 1 directors by default
    public int number_of_managers;
    public int number_of_workers;*/
    public int id;
    public String name;
    public int default_director_salary = 20000;
    public int default_manager_salary = 10000;
    public int default_worker_salary = 7000;

    //    public Employee[] Employee;
    int salary_fond;
    public Director director;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void countSalary() {

    }

    public Director getDirector() {
        return director;
    }

    public int getDefault_director_salary() {
        return default_director_salary;
    }

    public int getDefault_manager_salary() {
        return default_manager_salary;
    }

    public int getDefault_worker_salary() {
        return default_worker_salary;
    }

    public int getSalary_fond() {
        return salary_fond;
    }

    public void setDefault_director_salary(int default_director_salary) {
        this.default_director_salary = default_director_salary;
    }

    public void setDefault_manager_salary(int default_manager_salary) {
        this.default_manager_salary = default_manager_salary;
    }

    public void setDefault_worker_salary(int default_worker_salary) {
        this.default_worker_salary = default_worker_salary;
    }

    public void setSalary_fond(int salary_fond) {
        this.salary_fond = salary_fond;
    }

    public int getNumber_of_managers() {
        Objects.requireNonNull(this.director.managers,
                "Managers is null! Director id:" + this.director.id);
        return this.director.managers.size();
    }

    public int getNumber_of_workers() {
        int number_of_workers = 0;
        for (Manager manager : this.director.managers) {

            number_of_workers += manager.getNumberOfWorkers();
        }
        return number_of_workers;
    }
}
