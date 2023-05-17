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

}