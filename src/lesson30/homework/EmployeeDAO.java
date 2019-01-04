package lesson30.homework;

import java.util.*;

public class EmployeeDAO {

    private  ArrayList<Employee> allEmployees;

    public EmployeeDAO(ArrayList<Employee> Employees) {
        this.allEmployees = Employees;
    }


//
    public  ArrayList<Employee> employeesByProject(String projectName){
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < allEmployees.size(); i++) {
            if (allEmployees.get(i).getProjects() != null) {
                for (int j = 0; j < allEmployees.get(i).getProjects().size(); j++) {
                    if (projectName.equals(allEmployees.get(i).getProjects().get(j).getName()))
                        employees.add(allEmployees.get(i));

                }
            }
        }
        return employees;
    }

    public ArrayList<Employee> employeesWithoutProject() {

        ArrayList<Employee> all = allEmployees;
        ArrayList<Employee> res = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getProjects() == null)
                res.add(all.get(i));
        }
        return res;
    }

    public Set<Employee> employeesByTeamLead(Employee lead) {



        ArrayList<Project> projects = lead.getProjects();


        return findRes(projects);
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee){
        Set<Employee> res = new HashSet<>();
        ArrayList<Project> projects = employee.getProjects();

        for (int i = 0; i < projects.size(); i++) {
            ArrayList<Employee> employees = employeesByProject(projects.get(i).getName());
            for (int j = 0; j < employees.size(); j++){
                if (employees.get(j).getPosition().equals(Position.TEAM_LEAD))
                    res.add(employees.get(j));
            }
        }

        return res;
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee){
        ArrayList<Project> projects = employee.getProjects();

        return findRes(projects);
    }




    public Set<Employee> findRes(ArrayList<Project> projects){
        Set<Employee> res = new HashSet<>();
        for (int i = 0; i < projects.size(); i++){
            ArrayList<Employee> employees = employeesByProject(projects.get(i).getName());
            for (int j = 0; j < employees.size(); j++){
                res.add(employees.get(j));
            }
        }
        return res;

    }





}