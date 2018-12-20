package lesson30.homework;

import java.util.ArrayList;

public class Controller {
    public ArrayList<Employee> employeesByProject(String projectName) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        ArrayList<Employee> allEmployees = employeeDAO.getAll();
        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < allEmployees.size(); i++){
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

    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        departmentDAO.add();
        ArrayList<Department> all = departmentDAO.getAll();
        ArrayList<Employee> res = new ArrayList<>();
        for (int i = 0; i < all.size(); i++){
            if (departmentType.equals(all.get(i).getType()))
                for (int j = 0; j < all.get(i).getEmployees().size(); j++){
                    if (all.get(i).getEmployees().get(j).getProjects() == null){
                        res.add(all.get(i).getEmployees().get(j));
                    }
                }
        }
        return res;
    }

    public ArrayList<Employee> employeesWithoutProject(){
        DepartmentDAO departmentDAO = new DepartmentDAO();
        ArrayList<Department> all = departmentDAO.getAll();
        ArrayList<Employee> res = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            for (int j = 0; j < all.get(i).getEmployees().size(); j++) {
                if (all.get(i).getEmployees().get(j).getProjects() == null) {
                    res.add(all.get(i).getEmployees().get(j));
                }
            }
        }
        return res;
    }

}
