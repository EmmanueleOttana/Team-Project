import HumanResources.Employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDB {
    List<Employees> employees = new ArrayList<>();

    public EmployeesDB(String name, String surname, int ID, String codiceFiscale, String typeOfWork, String typeOfContract, String dateOfBirth, List<Employees> employees) {
        this.employees = employees;
    }
    public void saveEmployees (Employees employee){
        employees.add(employee);
        System.out.println(employee);
    }

}