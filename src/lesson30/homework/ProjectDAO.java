package lesson30.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ProjectDAO {

    private ArrayList<Project> projects;

    public ProjectDAO(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> projectsByEmployee(Employee employee) {

        return employee.getProjects();
    }

    public ArrayList<Project> projectsByCustomer(Customer customer) {

        ArrayList<Project> res = new ArrayList<>();

        for (int i = 0; i < projects.size(); i++) {
            if (customer.equals(projects.get(i).getCustomer()))
                res.add(projects.get(i));
        }


        return res;
    }

    public Set<Employee> employeesByCustomerProject(Customer customer, EmployeeDAO employeeDAO) {

        ArrayList<Project> projects = projectsByCustomer(customer);


        return employeeDAO.findRes(projects);
    }


}

