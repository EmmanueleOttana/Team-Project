package start.repositories;

import start.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import start.services.EmployeeService;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    /**
     * É un HashMap<String, LocalTime>() con tutte le ore di lavoro effettuate da tutti gli employees
     */
    Map<String, LocalTime> workingHours = new HashMap<>();

    /**
     * @param employee
     * @return Le ore effettuate da un singolo dipendente nella giornata.
     */
    default Map<String, String> getHoursEmployee(Employee employee) {
        EmployeeService service = new EmployeeService();
        Map<String, String> hoursEmployee = new HashMap<>();
        String valueKey = employee.getSurname() + employee.getName() + employee.getId();
        for (String key : service.mapConverter(workingHours).keySet() ) {
            if (key.contains(valueKey)) {
                hoursEmployee.put(valueKey, service.mapConverter(workingHours).get(key));
                return hoursEmployee;
            }
        }
        hoursEmployee.put(valueKey, "ha effettuato il primo accesso della giornata!");
        return hoursEmployee;
    }
    /**
     * @param employee
     * @return Tutte le ore effettuate da un singolo dipendente nel mese corrente.
     */
    default Map<String, LocalTime> getSingleEmployeeHours(Employee employee) {
        Map<String, LocalTime> employeeHours = new HashMap<>();
        String valueKey = employee.getSurname() + employee.getName() + employee.getId();
        String currentMonth = LocalDate.now().getYear() + "-" +
                (LocalDate.now().getMonthValue() < 10 ? "0" + LocalDate.now().getMonthValue() : LocalDate.now().getMonthValue());
        for (String key : workingHours.keySet()) {
            String keyMonth = key.substring(0,7);
            if (key.contains(valueKey) && keyMonth.equals(currentMonth)) {
                employeeHours.put(key, workingHours.get(key));
            }
        }
        return employeeHours;
    }

}