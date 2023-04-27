package controllers;

import entities.Contracts;
import org.springframework.web.bind.annotation.*;
import repositories.ContractsRepository;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractsController {
    private final ContractsRepository repository;

    ContractsController(ContractsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Contracts> getAllContracts() {
        return repository.findAll();
    }

    @PostMapping("")
    Contracts newContract(@RequestBody Contracts newContract){
        return repository.save(newContract);
    }

    @GetMapping("/{id}")
    Contracts getSingleContract(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteContract(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
