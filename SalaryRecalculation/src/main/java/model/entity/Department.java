package model.entity;

public class Department {

    public int number_of_directors = 1;//all departments has only 1 directors by default
    public int number_of_managers;
    public int number_of_workers;

    public int default_director_salary = 20000;
    public int default_manager_salary = 10000;
    public int default_worker_salary = 7000;

    public Employee[] Employee;
    int salary_fond;
    Director director;

    public Department(Director director){

    }
    public void countSalary(){

    }

    public Director getDirector() {return director;}

    public int getDefault_director_salary() {
        return default_director_salary;
    }

    public int getDefault_manager_salary() {
        return default_manager_salary;
    }

    public int getDefault_worker_salary() {
        return default_worker_salary;
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
}
