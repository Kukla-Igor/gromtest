package lesson30.homework;


import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args){

        Firm adidas = new Firm(new Date());
        Firm nike = new Firm(new Date());

        Customer billy = new Customer("Billy", "USA", 1000);
        Customer garry = new Customer("Garry", "Ukraine", 1500);
        Customer jack = new Customer("Jack", "Germany", 500);

        Project projectForBilly = new Project("ProjectForBilly", billy);
        Project projectForGarry = new Project("ProjectForGarry", garry);
        Project projectForJack = new Project("ProjectForJack", jack);
        ArrayList <Project> projects = new ArrayList<>();
        projects.add(projectForBilly);
        projects.add(projectForGarry);
        projects.add(projectForJack);
        ProjectDAO projectDAO = new ProjectDAO(projects);

        Department analyst = new Department(DepartmentType.ANALYST);
        Department developer = new Department(DepartmentType.DEVELOPER);
        Department finance = new Department(DepartmentType.FINANCE);
        Department manager = new Department(DepartmentType.MANAGER);


        Employee kirril = new Employee("Kirril", "Bogdanov", new Date(), Position.ANALYST, new Department(DepartmentType.ANALYST), projects);
        Employee oleg = new Employee("Oleg", "Ivanov", new Date(), Position.DESIGNER, new Department(DepartmentType.DEVELOPER), null);
        Employee serg = new Employee("Serg", "Sergeev", new Date(), Position.DEVELOPER, new Department(DepartmentType.FINANCE), projects);
        Employee anton = new Employee("Anton", "Antonov", new Date(), Position.TEAM_LEAD, new Department(DepartmentType.FINANCE), projects);
        Employee bogdan = new Employee("Bogdan", "Trump", new Date(), Position.MANAGER, new Department(DepartmentType.MANAGER), projects);
        Employee denis = new Employee("Denis", "Denisov", new Date(), Position.ANALYST, new Department(DepartmentType.FINANCE), null);
        ArrayList <Employee> employees = new ArrayList<>();
        employees.add(kirril);
        employees.add(oleg);
        employees.add(serg);
        employees.add(anton);
        employees.add(bogdan);
        employees.add(denis);

        analyst.setEmployees(new ArrayList<Employee>(employees));

        ArrayList<Department> departments = new ArrayList<>();
        departments.add(analyst);

        DepartmentDAO departmentDAO = new DepartmentDAO(departments);

        EmployeeDAO employeeDAO = new EmployeeDAO(employees);





        Controller controller = new Controller();



        System.out.println(controller.employeesByProject("ProjectForBilly", employeeDAO));


        System.out.println(controller.projectsByEmployee(oleg, projectDAO));
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.ANALYST, departmentDAO));

        System.out.println(controller.employeesWithoutProject(employeeDAO));
        System.out.println(controller.employeesByTeamLead(anton, employeeDAO));
        System.out.println(controller.teamLeadsByEmployee(bogdan, employeeDAO));
        System.out.println(controller.employeesByProjectEmployee(bogdan, employeeDAO));

        System.out.println(controller.projectsByCustomer(billy, projectDAO));

        System.out.println(controller.employeesByCustomerProject(billy, projectDAO, employeeDAO));







    }
}
