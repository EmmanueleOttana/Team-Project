package Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    List<EmployeeEntity> employees = new ArrayList<>();

    public EmployeeRepository(){

    }

    public EmployeeRepository(String name, String surName, int ID, String codiceFiscale, String typeOfWork, String typeOfContract, String dateOfBirth, List<EmployeeEntity> employees) {
        super();
        this.employees = employees;
    }
    public void saveEmployees (EmployeeEntity employee){
        employees.add(employee);
        System.out.println(employee);
    }

}
