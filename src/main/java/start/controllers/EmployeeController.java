package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Employee;
import start.entities.TypeOfContract;
import start.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import start.services.EmployeeService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repoEmployees;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getall")
    List<Employee> getAllEmployees() {
        return repoEmployees.findAll();
    }

    @PostMapping("create")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repoEmployees.saveAndFlush(newEmployee);
    }

    @GetMapping("/{id}")
    Employee getSingleEmployee(@PathVariable Long id) throws Exception {
        return repoEmployees.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    @PutMapping("/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repoEmployees.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setTypeOfWork(newEmployee.getTypeOfWork());
                    return repoEmployees.saveAndFlush(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repoEmployees.saveAndFlush(newEmployee);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repoEmployees.deleteById(id);
    }

    @PutMapping("/badge/{id}")
    public String badge(@PathVariable long id) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        Employee employee = repoEmployees.findById(id).orElseThrow(() -> new Exception("ID not found: "+id));
        if(employee.getAccessBadge() == null) {
            employee.setAccessBadge(now);
            repoEmployees.saveAndFlush(employee);
        }else {
            employee.setWorkHours( (int) ChronoUnit.MINUTES.between(employee.getAccessBadge(),now));
            employeeService.resetBadge(employee);
            repoEmployees.saveAndFlush(employee);
        }
        return repoEmployees.getHoursEmployee(employee);
    }

    @GetMapping("hours")
    public Map<String, String> getHoursEmployees(){
        return repoEmployees.getHoursAllEmployees();
    }

    @Deprecated
    @PostMapping("/fake")
    public String createEmployeesFake(){
        Employee employee1 = new Employee("Harry", "Potter", "PTTHRY80L31E098E", "Programmatore", TypeOfContract.OPEN_ENDED, "1980-07-31");
        Employee employee2 = new Employee("Hermione", "Granger", "GRNHMN79P59F158S", "Professoressa", TypeOfContract.AGENCY_WORK, "1979-09-19");
        Employee employee3 = new Employee("User", "Fake", "USEFAK80L31E098E", "Programmatore", TypeOfContract.ON_CALL_CONTRACT, "1991-04-14");
        repoEmployees.saveAndFlush(employee1);
        repoEmployees.saveAndFlush(employee2);
        repoEmployees.saveAndFlush(employee3);
        return "Fake employees are created!";
    }




}