package lesson30.homework;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO {

    Employee kirril = new Employee("Kirril", "Bogdanov", new Date(), Position.ANALYST, new DepartmentDAO().getAnalyst());
    Employee oleg = new Employee("Oleg", "Ivanov", new Date(), Position.DESIGNER, new DepartmentDAO().getDeveloper());
    Employee serg = new Employee("Serg", "Sergeev", new Date(), Position.DEVELOPER, new DepartmentDAO().getFinance());
    Employee anton = new Employee("Anton", "Antonov", new Date(), Position.LEAD_DESIGNER, new DepartmentDAO().getFinance());
    Employee bogdan = new Employee("Bogdan", "Trump", new Date(), Position.MANAGER, new DepartmentDAO().getManager());
    Employee denis = new Employee("Denis", "Denisov", new Date(), Position.ANALYST, new DepartmentDAO().getFinance());




    public EmployeeDAO() {

        ProjectDAO projectDAO = new ProjectDAO();
        ArrayList<Project> projectsKirill = new ArrayList<>();
        projectsKirill.add(projectDAO.getProjectForBilly());
        projectsKirill.add(projectDAO.getProjectForJack());
        kirril.setProjects(projectsKirill);

        ArrayList<Project> projectsOleg = new ArrayList<>();
        projectsOleg.add(projectDAO.getProjectForJack());
        projectsOleg.add(projectDAO.getProjectForGarry()) ;
        oleg.setProjects(projectsOleg);

        ArrayList<Project> projectsSerg = new ArrayList<>();
        projectsSerg.add(projectDAO.getProjectForGarry());
        serg.setProjects(projectsSerg);

        ArrayList<Project> projectsAnton = new ArrayList<>();
        projectsAnton.add(projectDAO.getProjectForJack());
        projectsAnton.add(projectDAO.getProjectForGarry()) ;
        projectsAnton.add(projectDAO.getProjectForBilly()) ;
        anton.setProjects(projectsAnton);

        //        DepartmentDAO departmentDAO = new DepartmentDAO();
//
//        departmentDAO.add();


    }


    public Employee getKirril() {
        return kirril;
    }

    public Employee getOleg() {
        return oleg;
    }

    public Employee getSerg() {
        return serg;
    }

    public Employee getAnton() {
        return anton;
    }

    public Employee getBogdan() {
        return bogdan;
    }

    public Employee getDenis() {
        return denis;
    }

    public ArrayList<Employee> getAll() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(kirril);
        list.add(oleg);
        list.add(anton);
        list.add(serg);
        list.add(bogdan);
        list.add(denis);
        return list;
    }

    @Override
    public String toString() {
        return "EmployeeDAO{" +
                "kirril=" + kirril +
                ", oleg=" + oleg +
                ", serg=" + serg +
                ", anton=" + anton +
                ", bogdan=" + bogdan +
                '}';
    }
}