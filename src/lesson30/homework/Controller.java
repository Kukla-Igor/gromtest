package lesson30.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    public  ArrayList<Employee> employeesByProject(String projectName, EmployeeDAO employeeDAO){
        return employeeDAO.employeesByProject(projectName);
    }

  public ArrayList<Project> projectsByEmployee(Employee employee, ProjectDAO projectDAO) {
        return projectDAO.projectsByEmployee(employee);

    }

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType, DepartmentDAO departmentDAO) {
        return departmentDAO.employeesByDepartmentWithoutProject(departmentType);
    }

    public ArrayList<Employee> employeesWithoutProject(EmployeeDAO employeeDAO) {
        return employeeDAO.employeesWithoutProject();
    }

    public Set<Employee> employeesByTeamLead(Employee lead, EmployeeDAO employeeDAO) {
        return employeeDAO.employeesByTeamLead(lead);

    }
//
    public Set<Employee> teamLeadsByEmployee(Employee employee, EmployeeDAO employeeDAO){
        return employeeDAO.teamLeadsByEmployee(employee);
    }

    public Set<Employee> employeesByProjectEmployee(Employee employee, EmployeeDAO employeeDAO){
        return employeeDAO.employeesByProjectEmployee(employee);
    }


    public ArrayList<Project> projectsByCustomer (Customer customer, ProjectDAO projectDAO){
        return projectDAO.projectsByCustomer(customer);
}

    public Set<Employee> employeesByCustomerProject(Customer customer, ProjectDAO projectDAO, EmployeeDAO employeeDAO){
     return projectDAO.employeesByCustomerProject(customer, employeeDAO);
    }
//


    }
