package start.repositories;

import start.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> employees = new ArrayList<>();
    Map<String, LocalTime> workingHours = new HashMap<>();

    static void saveEmployees(Employee employee){
        employees.add(employee);
    }

    static Map<String, String> printHoursEmployees() {
        Map<String, String> hoursEmployees = new HashMap<>();
        for ( String key : workingHours.keySet() ) {
            String newFormat = String.valueOf(workingHours.get(key)).replaceAll(":","h");
            hoursEmployees.put(key,newFormat+"'");
        }
    return hoursEmployees;
    }


}
