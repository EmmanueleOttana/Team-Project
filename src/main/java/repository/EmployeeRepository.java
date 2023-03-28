package repository;

import entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    List<EmployeeEntity> employees = new ArrayList<>();

    public List<EmployeeEntity> getEmployees() { return employees; }

    public void saveEmployees (EmployeeEntity employee){
        employees.add(employee);
    }


}
