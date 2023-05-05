package start.controllers;

import start.entities.Employee;
import start.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @PostMapping("")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }
    @GetMapping("/{id}")
    Employee getSingleEmployee(@PathVariable Long id) throws Exception {

        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }
    @PutMapping("/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setTypeOfWork(newEmployee.getTypeOfWork());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
