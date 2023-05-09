package start.repositories;

import start.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Map<String, LocalTime> workingHours = new HashMap<>();

    default Map<String, String> getHoursAllEmployees() {
        Map<String, String> hoursEmployees = new HashMap<>();
        for (String key : workingHours.keySet()) {
            String newFormat = String.valueOf(workingHours.get(key)).replaceAll(":", "h");
            hoursEmployees.put(key, newFormat + "'");
        }
        return hoursEmployees;
    }

    default String getHoursEmployee(Employee employee) {
        Map<String, String> hoursEmployee = new HashMap<>();
        String valueKey = employee.getSurname() + employee.getName() + employee.getId();
        for ( String key : getHoursAllEmployees().keySet() ) {
            if( key.contains(valueKey) ){
                hoursEmployee.put(valueKey, getHoursAllEmployees().get(key));
                return hoursEmployee.toString();
            }
        }
        return valueKey + " ha effettuato il primo accesso della giornata!";
    }




}