package lesson30.homework;

import java.util.ArrayList;
import java.util.Date;

public class FirmDAO {


    Firm adidas = new Firm(new Date());
    Firm nike = new Firm(new Date());

    public FirmDAO(){
        ArrayList<Department> adidasListDepartment = new ArrayList<>();
        ArrayList<Department> nikeListDepartment = new ArrayList<>();

        ArrayList<Customer> adidasListCustomer = new ArrayList<>();
        ArrayList<Customer> nikeListCustomer = new ArrayList<>();

        CustomerDAO customerDAO = new CustomerDAO();

        adidasListCustomer.add(customerDAO.getBilly());
        adidasListCustomer.add(customerDAO.getGarry());
        nikeListCustomer.add(customerDAO.getJack());

        DepartmentDAO departmentDAO = new DepartmentDAO();


        adidasListDepartment.add(departmentDAO.getFinance());
        nikeListDepartment.add(departmentDAO.getAnalyst());

        adidas.setCustomers(adidasListCustomer);
        nike.setCustomers(nikeListCustomer);

        adidas.setDepartments(adidasListDepartment);
        nike.setDepartments(nikeListDepartment);


    }




}
