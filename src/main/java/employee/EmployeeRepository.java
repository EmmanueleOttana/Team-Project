package Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    List<EmployeeEntity> employees = new ArrayList<>();

    public void saveEmployees (EmployeeEntity employee){
        employees.add(employee);
        System.out.println(employee.toString());
    }

}
