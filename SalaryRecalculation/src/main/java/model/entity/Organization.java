package model.entity;

import model.SalaryCounterWithMultiplier;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Organization {
    private int counter_id = 0;
//    public int number_of_employee;
    public int number_of_directors;
    public int number_of_managers;
    public int number_of_workers;



    public SalaryCounterWithMultiplier salaryCounterWithMultiplier;
    public ArrayList<Department> departments;
    public ArrayList<Employee> fired_workers;

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
                department = salaryCounterWithMultiplier.getSalaryForDepartment(
                        department, number_of_directors,
                        number_of_managers,number_of_workers);
            }

        }

        else{
            for(Department department : departments){
                department = salaryCounterWithMultiplier.getSalaryForDepartment(
                        department, 1,                           //in this case each department has its
                        department.getNumber_of_managers(),                      // own multiplier for workers
                        department.getNumber_of_workers());
            }
        }
    }


    public void setSalary_fond(int salary_fond){
        this.salary_fond = salary_fond;
    }

    public Employee getEmployeeById(int id){
        for(Department department : departments){
            if(department.director.id == id){
                return department.director;
            }
            else for(Manager manager : department.director.managers){
                if(manager.id == id){
                    return manager;
                }
                else for(Worker worker : manager.workers){
                    if(worker.id == id){
                        return worker;
                    }
                }
            }
        }
        return new Employee();
    }

    public int addNewDirector(Director director, int department_id){
        Objects.requireNonNull(director, "New director is null!");
        for(Department department : departments){
            if(department.id == department_id){
                department.director = director;
                number_of_directors++;
                return director.id;
            }
        }
        return -1;
    }
    public int addNewManager(Manager manager, int director_id){
        Objects.requireNonNull(manager, "New manager is null!");
        for(Department department : departments){
            if(department.director.id == director_id){
                department.director.managers.add(manager);
                number_of_managers++;
                return manager.id;
            }
        }
        return -1;
    }
    public int addNewWorker(Worker worker, int manager_id){
        Objects.requireNonNull(worker, "New worker is null!");
        for(Department department : departments){
            for(Manager manager : department.director.managers){
                if(manager.id == manager_id){
                    manager.workers.add(worker);
                    number_of_workers++;
                    return worker.id;
                }
            }
        }
        return -1;
    }
    public int addNewDepartment(Department department){
        Objects.requireNonNull(department, "New department is null!");
        departments.add(department);
        return department.id;
    }

    public int updateDirectorById(Director new_director, int director_id){
        Objects.requireNonNull(new_director, "Updated director is null!");
        for(Department department : departments){
            if(department.director.id == director_id){
                department.director.name = new_director.name;
                department.director.middle_name = new_director.middle_name;
                department.director.surname = new_director.surname;
                department.director.birth_date = new_director.birth_date;
                department.director.employment_date = new_director.employment_date;
                department.director.description = new_director.description;
                return new_director.id;
            }
        }
        return -1;

    }
    public int updateManagerById(Manager new_manager, int manager_id){
        Objects.requireNonNull(new_manager, "New manager is null!");
        for(Department department : departments){
            for(Manager manager : department.director.managers){
                if(manager.id == manager_id){
                    manager.name = new_manager.name;
                    manager.middle_name = new_manager.middle_name;
                    manager.surname = new_manager.surname;
                    manager.birth_date = new_manager.birth_date;
                    manager.employment_date = new_manager.employment_date;
                    return manager.id;
                }
            }
        }
        return -1;
    }
    public int updateWorkerById(Worker new_woker, int worker_id){
        for(Department department : departments){
            for(Manager manager : department.director.managers){
                for(Worker worker : manager.workers){
                    if(worker.id == worker_id){
                        worker.name = new_woker.name;
                        worker.middle_name = new_woker.middle_name;
                        worker.surname = new_woker.surname;
                        worker.birth_date = new_woker.birth_date;
                        worker.employment_date = new_woker.employment_date;
                        return worker.id;
                    }
                }
            }
        }
        return -1;
    }

    public int replaceDirectorById(Director new_director, int replace_director_id){
        Objects.requireNonNull(new_director, "New director is null!");
        for(Department department : departments){
            if(department.director.id == replace_director_id){
                new_director.managers = department.director.managers;
                department.director.managers.clear();
                fired_workers.add(department.director);
                department.director = new_director;
                return new_director.id;
            }
        }
        return -1;
    }
    public int removeManagerById(int manager_id){
        for(Department department : departments){
            for(Manager manager : department.director.managers){
                if(manager.id == manager_id){
                    department.director.managers.remove(manager);
                    department.director.managers = distributeManagerWorkers(
                            department.director.managers, manager.workers);
                    manager.workers.clear();
                    fired_workers.add(manager);
                    number_of_managers--;
                    return manager_id;
                }
            }
        }
        return -1;
    }
    public int removeWorkerById(int worker_id){
        for(Department department : departments){
            for (Manager manager : department.director.managers){
                for(Worker worker : manager.workers){
                    if(worker.id == worker_id){
                        manager.workers.remove(worker);
                        fired_workers.add(worker);
                        number_of_workers--;
                    }
                }
            }
        }
        return -1;
    }

    public ArrayList<Manager> distributeManagerWorkers(ArrayList<Manager> managers,
                                         ArrayList<Worker> workers){
        int index = 0;
        for(Worker worker : workers){
            if(index == managers.size()){
                index = 0;
            }
            managers.get(index++).workers.add(worker);
        }
        return managers;
    }

    public Department createNewDepartment(String name){
        int new_id = getNewId();
        Department department = new Department(new_id, name);
        return department;

    }

    public Director createNewDirector(String name, String middle_name,
                                      String surname, Date birth_date,
                                      Date employment_date, String description){

        int new_id = getNewId();
        Director director = new Director(new_id, name, middle_name,
                                        surname, birth_date,
                                        employment_date, description);
        return director;
    }

    public Manager createNewManager(String name, String middle_name, String surname,
                                    Date birth_date, Date employment_date){
        int new_id = getNewId();
        Manager manager = new Manager(new_id, name, middle_name, surname,
                                    birth_date, employment_date);

        return manager;
    }

    public Worker createNewWorker(String name, String middle_name, String surname,
                                  Date birth_date, Date employment_date){
        int new_id = getNewId();
        Worker worker = new Worker(new_id, name, middle_name, surname,
                birth_date, employment_date);

        return worker;

    }

    private int getNewId(){
        int new_id = counter_id++;
        return new_id;
    }
}
