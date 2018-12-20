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
        System.out.println(controller.employeesByTeamLead(employeeDAO.getAnton()));


        System.out.println(controller.teamLeadsByEmployee(employeeDAO.getKirril()));
        System.out.println(controller.employeesByProjectEmployee(employeeDAO.getKirril()));

        CustomerDAO customerDAO = new CustomerDAO();

        System.out.println(controller.projectsByCustomer(customerDAO.getBilly()));

        System.out.println(controller.employeesByCustomerProject(customerDAO.getBilly()));




    }
}
