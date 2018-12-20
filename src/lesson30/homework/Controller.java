package lesson30.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    public ArrayList<Employee> employeesByProject(String projectName) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ArrayList<Employee> allEmployees = employeeDAO.getAll();
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

    public ArrayList<Project> projectsByEmployee(Employee employee) {

        return employee.getProjects();
    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.add();
        ArrayList<Department> all = departmentDAO.getAll();
        ArrayList<Employee> res = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (departmentType.equals(all.get(i).getType()))
                for (int j = 0; j < all.get(i).getEmployees().size(); j++) {
                    if (all.get(i).getEmployees().get(j).getProjects() == null) {
                        res.add(all.get(i).getEmployees().get(j));
                    }
                }
        }
        return res;
    }

    public ArrayList<Employee> employeesWithoutProject() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ArrayList<Employee> all = employeeDAO.getAll();
        ArrayList<Employee> res = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getProjects() == null)
                res.add(all.get(i));
        }
        return res;
    }

    public Set<Employee> employeesByTeamLead(Employee lead) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        ArrayList<Employee> all = employeeDAO.getAll();

        ArrayList<Project> projects = projectsByEmployee(lead);


        return findRes(projects);
    }

    public Set<Employee> teamLeadsByEmployee(Employee employee){
        Set<Employee> res = new HashSet<>();
        ArrayList<Project> projects = projectsByEmployee(employee);

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
      ;
        ArrayList<Project> projects = projectsByEmployee(employee);

        return findRes(projects);
    }


    public ArrayList<Project> projectsByCustomer (Customer customer){
        ProjectDAO projectDAO = new ProjectDAO();
        ArrayList<Project> projects = projectDAO.getAll();
        ArrayList<Project> res = new ArrayList<>();

        for (int i = 0; i < projects.size(); i++){
            if (customer.equals(projects.get(i).getCustomer()))
                res.add(projects.get(i));
        }


        return res;
    }

    public Set<Employee> employeesByCustomerProject(Customer customer){

        ArrayList<Project> projects = projectsByCustomer(customer);

        return findRes(projects);
    }

    private Set<Employee> findRes(ArrayList<Project> projects){
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
