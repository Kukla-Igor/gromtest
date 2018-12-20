package lesson30.homework;

import java.util.ArrayList;

public class DepartmentDAO {
    public Department developer = new Department(DepartmentType.DEVELOPER);
    public Department finance = new Department(DepartmentType.FINANCE);
    public Department analyst = new Department(DepartmentType.ANALYST);
    public Department manager = new Department(DepartmentType.MANAGER);

    public void add(){
        ArrayList<Employee> developerListEmployee = new ArrayList<>();
        ArrayList<Employee> financeListEmployee = new ArrayList<>();
        ArrayList<Employee> analystListEmployee = new ArrayList<>();
        ArrayList<Employee> managerListFinance = new ArrayList<>();


        EmployeeDAO employeeDAO = new EmployeeDAO();

        developerListEmployee.add(employeeDAO.getAnton());
        financeListEmployee.add(employeeDAO.getKirril());
        analystListEmployee.add(employeeDAO.getOleg());
        analystListEmployee.add(employeeDAO.getDenis());
        managerListFinance.add(employeeDAO.getSerg());
        managerListFinance.add(employeeDAO.getBogdan());

        developer.setEmployees(developerListEmployee);
        finance.setEmployees(financeListEmployee);
        analyst.setEmployees(analystListEmployee);
        manager.setEmployees(managerListFinance);



    }

    public Department getDeveloper() {
        return developer;
    }

    public Department getFinance() {
        return finance;
    }

    public Department getAnalyst() {
        return analyst;
    }

    public Department getManager() {
        return manager;
    }

    public ArrayList<Department> getAll() {
        ArrayList<Department> all = new ArrayList<>();
        all.add(developer);
        all.add(finance);
        all.add(analyst);
        all.add(manager);
        return all;
    }

    @Override
    public String toString() {
        return "DepartmentDAO{" +
                "developer=" + developer +
                ", finance=" + finance +
                ", analyst=" + analyst +
                ", manager=" + manager +
                '}';
    }
}
