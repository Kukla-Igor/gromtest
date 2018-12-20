package lesson30.homework;

import java.util.ArrayList;

public class ProjectDAO {

    private Project projectForBilly = new Project("ProjectForBilly", new CustomerDAO().getBilly());
    private Project projectForGarry = new Project("ProjectForGarry", new CustomerDAO().getGarry());
    private Project projectForJack = new Project("ProjectForJack", new CustomerDAO().getJack());



    public Project getProjectForBilly() {
        return projectForBilly;
    }

    public Project getProjectForGarry() {
        return projectForGarry;
    }

    public Project getProjectForJack() {
        return projectForJack;
    }



    public ArrayList<Project> getAll() {
        ArrayList<Project> list = new ArrayList<>();
        list.add(projectForBilly);
        list.add(projectForGarry);
        list.add(projectForJack);
        return list;
    }

    @Override
    public String toString() {
        return "ProjectDAO{" +
                "projectForBilly=" + projectForBilly +
                ", projectForGarry=" + projectForGarry +
                ", projectForJack=" + projectForJack +
                '}';
    }
}
