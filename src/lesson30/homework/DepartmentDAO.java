package lesson30.homework;

import java.util.ArrayList;

public class DepartmentDAO {

    private ArrayList<Department> departments;

    public DepartmentDAO(ArrayList<Department> departments) {
        this.departments = departments;
    }




    public ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Department> all = departments;
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

}
