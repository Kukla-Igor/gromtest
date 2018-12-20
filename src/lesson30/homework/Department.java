package lesson30.homework;

import java.util.ArrayList;

public class Department {
    private DepartmentType type;
    private ArrayList<Employee> employees;


    public Department(DepartmentType type) {
        this.type = type;
    }

    public DepartmentType getType() {
        return type;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                ", employees=" + employees +
                '}';
    }
}
