package lesson30.homework;

import java.util.ArrayList;

import java.util.Date;

public class Firm {
    private Date dateCreated;
    private ArrayList<Department> departments;
    private ArrayList <Customer> customers;

    public Firm(Date dateCreated) {
        this.dateCreated = dateCreated;

    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
