package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.DTO.EmployeeDTO;
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
    public @ResponseBody Employee replaceEmployee(@PathVariable Long id, @RequestBody Employee employee)throws Exception {
        return employeeService.getReplaceEmployee(id,employee);
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
    public EmployeeDTO badge(@PathVariable long id) throws Exception {
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
     * @param id
     * @return Un Map<String,String> di tutte le ore dell'Employee tramite l'id
     */
    @GetMapping("/hours/{id}")
    public Map<String, String> getAllHoursEmployee(@PathVariable long id) throws Exception {
        return employeeService.getAllHoursEmployee(id);
    }
    @GetMapping("/totalHours/{id}")
    public EmployeeDTO totalHoursEmployee(@PathVariable long id){
        Employee employee = repoEmployee.findById(id).orElseThrow();
        employee.assignEmployeeDTO().setOreEffettuate(payrollService.convertFromDouble(payrollService.calculateHours(id)));
        return employee.assignEmployeeDTO();
    }

    @Deprecated
    @PostMapping("/dummies")
    public String createEmployeesDummies() throws Exception {
        return employeeService.createDummiesEmployees();
    }



}