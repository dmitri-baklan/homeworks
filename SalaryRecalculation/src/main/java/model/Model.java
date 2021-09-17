package model;

import model.entity.*;

import java.util.Date;

public class Model {

    Organization org;
   // ArrayList<Department> deps = org.departments;

    public Model(){}

    public Organization getOrganization() {
        return org;
    }

    public void calculateGeneralSalary(int general_salary){
        org.setSalary_fond(general_salary);
        org.setGeneralSalaryForAllDepartments();
    }

    public void calculateIndividualSalary(int[] salary_for_departments){
        org.setIndividualSalaryForAllDepartments(salary_for_departments);
    }

    public void setOrganization(Organization organization) {
        this.org = organization;
    }

    public void addNewOrganization(String name){
        Organization org = new Organization(name);
    }

    public int addNewDepartment(String name){
        Department dep = org.createNewDepartment(name);
        return org.addNewDepartment(dep);
    }

    public int addNewDirector(String name, String middle_name,
                              String surname, Date birth_date,
                              Date employment_date, String description,
                              int department_id){

        Director dir = org.createNewDirector(name, middle_name, surname,
                birth_date, employment_date, description);

        return org.addNewDirector(dir, department_id);
    }

    public int addNewManager(String name, String middle_name,
                            String surname, Date birth_date,
                            Date employment_date, int director_id){

        Manager manag = org.createNewManager(name, middle_name, surname,
                birth_date, employment_date);

        return org.addNewManager(manag, director_id);

    }

    public int addNewWorker(String name, String middle_name,
                            String surname, Date birth_date,
                            Date employment_date, int manager_id){
        Manager manag = org.createNewManager(name, middle_name, surname,
                birth_date, employment_date);

        return org.addNewManager(manag, manager_id);
    }

    public int remplaceDirectorById(String name, String middle_name,
                                    String surname, Date birth_date,
                                    Date employment_date, String description,
                                    int replace_director_id){

        Director dir = org.createNewDirector(name, middle_name, surname,
                birth_date, employment_date, description);

        return org.replaceDirectorById(dir, replace_director_id);
    }

    public int removeManagerById(int manager_id){
        return org.removeManagerById(manager_id);
    }

    public int removeWorkerById(int worker_id){
        return org.removeWorkerById(worker_id);
    }

    public int upgradeDirectorById(Director dir, int director_id){
        return org.updateDirectorById(dir, director_id);
    }

    public int upgradeManagerById(Manager manag, int manager_id){
        return org.updateManagerById(manag, manager_id);
    }

    public int upgradeWorkerById(Worker worker, int worker_id){
        return org.updateWorkerById(worker, worker_id);
    }

    public Employee getEmployeeById(int id){
        return org.getEmployeeById(id);
    }

    public void downgradeDirectorToManager(String name, String middle_name,
                                           String surname, Date birth_date,
                                           Date employment_date, String description,
                                           int downgrade_director_id,
                                           int new_director_for_manager_id){
        Director dir = org.createNewDirector(name, middle_name, surname,
                birth_date, employment_date, description);
        org.downgradeDirectorToManager(dir, downgrade_director_id,
                new_director_for_manager_id);
    }

    public void downgradeDirectorToWorker(String name, String middle_name,
                                          String surname, Date birth_date,
                                          Date employment_date, String description,
                                          int downgrade_director_id,
                                          int new_manager_for_worker_id){

        Director dir = org.createNewDirector(name, middle_name, surname,
                birth_date, employment_date, description);

        org.downgradeDirectorToWorker(dir, downgrade_director_id,
                new_manager_for_worker_id);
    }

    public void downgradeManagerToWorker(int downgrade_manager_id,
                                         int new_manager_for_worker_id){
        org.downgradeManagerToWorker(downgrade_manager_id,
                new_manager_for_worker_id);
    }

    public void upgradeManagerToDirector(int upgrade_manager_id,
                                         String manager_description,
                                         int replace_director_id){

        org.upgradeManagerToDirector(upgrade_manager_id,
                manager_description, replace_director_id);
    }

    public void upgradeWorkerToManager(int upgrade_worker_id,
                                       int new_director_for_manager_id){
        org.upgradeWorkerToManager(upgrade_worker_id,
                new_director_for_manager_id);
    }

    public void upgradeWorkerToDirector(int upgrade_worker_id, String worker_description,
                                        int replace_director_id){
        org.upgradeWorkerToDirector(upgrade_worker_id,
                worker_description, replace_director_id);
    }
}
