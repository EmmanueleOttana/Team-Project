package start.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Dismissal;
import start.repositories.DismissalRepository;
import org.springframework.web.bind.annotation.*;
import start.services.DismissalService;

import java.util.List;

@RestController
@RequestMapping("/dismissal")
public class DismissalController {
    @Autowired
    private DismissalRepository repository;
    @Autowired
    private DismissalService service;

    @GetMapping("/employee/{id}")
    String getDismissal(@RequestBody Dismissal newDismissal){
        return service.printInfo();
    }

    @GetMapping
    List<Dismissal> getAllDismissals() {
        return repository.findAll();
    }

    @PostMapping
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