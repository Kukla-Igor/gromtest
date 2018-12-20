package lesson30.homework;


public class Demo {
    public static void main(String[] args) {
        Controller controller = new Controller();

        EmployeeDAO employeeDAO = new EmployeeDAO();
        DepartmentDAO departmentDAO = new DepartmentDAO();
        Employee employee = employeeDAO.getSerg();
        System.out.println(controller.employeesByProject("ProjectForBilly"));
        System.out.println(controller.projectsByEmployee(employee));


        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.MANAGER));
        System.out.println(controller.employeesWithoutProject());


    }
}
