package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Payroll;
import start.repositories.EmployeeRepository;
import start.repositories.PayrollRepository;
import org.springframework.web.bind.annotation.*;
import start.services.PayrollService;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollRepository repository;
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private EmployeeRepository employeeRepository;

    PayrollController(PayrollRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<Payroll> getAllPayrolls() {
        return repository.findAll();
    }

    @PostMapping
    Payroll newPayroll(@RequestBody Payroll newPayroll){
        return repository.save(newPayroll);
    }

    @GetMapping("/{id}")
    Payroll getSinglePayroll(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deletePayroll(@PathVariable Long id) {
        repository.deleteById(id);
    }

    /**
     * Crea busta paga tramite id employee
     * @param id
     * @return
     */
    @PostMapping("/create/{id}")
    public Payroll testPayroll(@PathVariable long id){
        return payrollService.calculatePayRoll(employeeRepository.findById(id).get());
    }

}
