package controllers;


import entities.Dismissal;
import org.springframework.web.bind.annotation.*;
import repositories.DismissalRepository;

import java.util.List;

public class DismissalController {
    private final DismissalRepository repository;

    DismissalController(DismissalRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Dismissal> getAllDismissals() {
        return repository.findAll();
    }

    @PostMapping("")
    Dismissal newDismissal(@RequestBody Dismissal newDismissal){
        return repository.save(newDismissal);
    }

    @GetMapping("/{id}")
    Dismissal getSingleDismissal(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteDismissal(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
