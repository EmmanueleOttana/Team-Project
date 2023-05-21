package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.DTO.PayrollDTO;
import start.entities.Payroll;
import start.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import start.services.PayrollService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    List<Payroll> getAllPayrolls() throws Exception {
        return payrollService.getAllPayrolls();
    }

    @PostMapping
    Payroll newPayroll(@RequestBody Payroll newPayroll) throws Exception {
        return payrollService.newPayroll(newPayroll);
    }

    @GetMapping("/{id}")
    Optional<Payroll> getSinglePayroll(@PathVariable Long id)throws Exception{
        return payrollService.getSinglePayrollByID(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deletePayroll(@PathVariable Long id) throws Exception {
        payrollService.deletePayrollByID(id);
    }

    /**
     * Crea busta paga tramite id employee
     * @param id
     * @return
     */
    @PostMapping("/create/{id}")
    public String calculatePayroll(@PathVariable long id)throws Exception {
        return payrollService.calculatePayrollByID(id);
    }

}
