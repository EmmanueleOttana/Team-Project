package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Employee;
import start.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import start.services.EmployeeService;
import start.services.PayrollService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository repoEmployee;
    @Autowired
    private PayrollService payrollService = new PayrollService();


    @GetMapping("/getAll")
    List<Employee> getAllEmployees() throws Exception {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/create")
    Employee newEmployee(@RequestBody Employee newEmployee) throws Exception{
        return employeeService.newEmployee(newEmployee);
    }

    @GetMapping("/{id}")
    Optional<Employee> getSingleEmployee(@PathVariable Long id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public Employee replaceEmployee(@PathVariable Long id) {
        return employeeService.getReplaceEmployee(id);
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) throws Exception {
        employeeService.deleteEmployee(id);
    }

    /**
     * @param id
     * @return Le ore lavorative che sta effettuando un employee
     * @throws Exception
     */
    @PutMapping("/badge/{id}")
    public Map<String, String> badge(@PathVariable long id) throws Exception {
        return employeeService.setBadge(id);
    }

    /**
     * @return Le ore di tutti i dipendenti di tutto il mese
     */
    @GetMapping("/hours")
    public Map<String, String> getHoursEmployees(){
        return employeeService.mapConverter(EmployeeRepository.workingHours);
    }

    /**
     * ritorna una Map<String,String> di tutte le ore dell'Employee
     * @param id
     * @return Le ore di un singolo employee tramite l'id
     */
    @GetMapping("/hours/{id}")
    public Map<String, String> getAllHoursEmployee(@PathVariable long id) throws Exception {
        return employeeService.getAllHoursEmployee(id);
    }
    @GetMapping("/totalHours/{id}")
    public String totalHoursEmployee(@PathVariable long id){
        Employee employee = repoEmployee.findById(id).orElseThrow();
        return employee.assignUserName()+", ha effettuato in totale: "+
                payrollService.calculateHours(id)+" ore di lavoro mensile!";
    }

    @Deprecated
    @PostMapping("/dummies")
    public String createEmployeesDummies() throws Exception {
        return employeeService.createDummiesEmployees();
    }



}