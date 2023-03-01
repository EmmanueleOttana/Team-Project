import HumanResources.Employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDB extends Employees{
    List<Employees> employees = new ArrayList<>();

    public EmployeesDB(){

    }

    public EmployeesDB(String name, String surName, int ID, String codiceFiscale, String typeOfWork, String typeOfContract, String dateOfBirth, List<Employees> employees) {
        super(name, surName, ID, codiceFiscale, typeOfWork, typeOfContract, dateOfBirth);
        this.employees = employees;
    }
    public void saveEmployees (Employees employee){
        employees.add(employee);
        System.out.println(employee);
    }

}
