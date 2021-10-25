package model.counters;

import model.entity.*;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class SalaryCounter {
    private int addition_to_salary; //addition is equal for all employee
    Date today;

    protected int salary_fond;
    int birthday_bonus = 1000;  //default bonus
    int premium;

    public Department getSalaryForDepartment(Department department,
                                             int number_of_directors,
                                             int number_of_managers,
                                             int number_of_workers) {

        this.salary_fond = department.getSalary_fond();
        department = assignSalaryForDepartment(department);
        countCurrentAddition(number_of_directors,
                number_of_managers,
                number_of_workers,
                this.salary_fond);
        department = getAdditionSalaryForDepartment(department);
        return department;

    }


    public Department assignSalaryForDepartment(Department department) {

        Objects.requireNonNull(department,
                "Department is null!");
        Objects.requireNonNull(department.director,
                "Director is null!");
        this.today = new Date();

        this.salary_fond = department.getSalary_fond();
        assignDirectorDefaultSalary(department.director,
                department.default_director_salary);


        if (department.getNumber_of_managers() != 0) {
            assignManagersDefaultSalary(department.director.managers,
                    department.default_manager_salary);
        }

        for (Manager manager : department.director.managers) {
            if (manager.getNumberOfWorkers() != 0) {
                assignWorkersDefaultSalary(manager.workers,
                        department.default_worker_salary);
            }
        }
        return department;

    }


    public Department getAdditionSalaryForDepartment(Department department) {


        assignDirectorAdditionalSalary(department.director,
                addition_to_salary);

        if (department.getNumber_of_managers() != 0) {
            assignManagersAdditionalSalary(department.director.managers,
                    addition_to_salary);
        }

        for (Manager manager : department.director.managers) {
            if (manager.getNumberOfWorkers() != 0) {
                assignWorkersAdditionalSalary(manager.workers,
                        addition_to_salary);
            }
        }
        return department;
    }

    public void assignDirectorDefaultSalary(Director director,
                                            int default_director_salary) {
        director.setSalary(default_director_salary);
        this.salary_fond -= default_director_salary;
        if (checkIsBirthday(director)) {
            director.setBirthdayBonus(this.birthday_bonus);
        }
    }

    public void assignManagersDefaultSalary(ArrayList<Manager> managers,
                                            int default_manager_salary) {
        for (Manager manager : managers) {
            manager.setSalary(default_manager_salary);
            this.salary_fond -= default_manager_salary;

            if (checkIsBirthday(manager)) {
                manager.setBirthdayBonus(this.birthday_bonus);
            }
            manager.setPremium(getManagerPremium(manager.workers.size()));
        }

    }

    public void assignWorkersDefaultSalary(ArrayList<Worker> workers,
                                           int default_worker_salary) {
        for (Worker worker : workers) {
            worker.setSalary(default_worker_salary);
            this.salary_fond -= default_worker_salary;
            if (checkIsBirthday(worker)) {
                worker.setBirthdayBonus(this.birthday_bonus);
            }
        }

    }

    public void assignDirectorAdditionalSalary(Director director,
                                               int director_additional_salary) {
        director.addToSalary(director_additional_salary);
        this.salary_fond -= director_additional_salary;
    }

    public void assignManagersAdditionalSalary(ArrayList<Manager> managers,
                                               int manager_additional_salary) {
        for (Manager manager : managers) {
            manager.addToSalary(manager_additional_salary);
            this.salary_fond -= manager_additional_salary;
        }

    }

    public void assignWorkersAdditionalSalary(ArrayList<Worker> workers,
                                              int worker_additional_salary) {
        for (Worker worker : workers) {
            worker.setSalary(worker_additional_salary);
            this.salary_fond -= worker_additional_salary;
        }

    }


    public void countCurrentAddition(int number_of_directors,
                                     int number_of_managers,
                                     int number_of_workers,
                                     int rest_of_salary) {

        int number_of_employee = (number_of_directors +
                number_of_managers + number_of_workers);

        this.addition_to_salary = (rest_of_salary / number_of_employee);
    }

    public boolean checkIsBirthday(Employee employee) {
        if (employee.birth_date.equals(this.today)) {
            return true;
        }
        return false;
    }

    public int getManagerPremium(int number_of_workers) {
        return number_of_workers * premium;
    }

    public int getSalary_fond() {
        return salary_fond;
    }

    public void setSalary_fond(int salary_fond) {
        this.salary_fond = salary_fond;
    }

    public void setBirthdayBonus(int birthday_bonus) {
        this.birthday_bonus = birthday_bonus;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }
}
