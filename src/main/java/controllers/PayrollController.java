package controllers;

import entities.Payroll;
import org.springframework.web.bind.annotation.*;
import repositories.PayrollRepository;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollRepository repository;

    PayrollController(PayrollRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Payroll> getAllPayrolls() {
        return repository.findAll();
    }

    @PostMapping("")
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
}
