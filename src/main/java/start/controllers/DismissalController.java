package start.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Dismissal;
import org.springframework.web.bind.annotation.*;
import start.services.DismissalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dismissal")
public class DismissalController {
    @Autowired
    private DismissalService service;

    @GetMapping("/employee/{id}")
    String getDismissal(@RequestBody Dismissal newDismissal){
        return service.printInfo();
    }

    @GetMapping
    List<Dismissal> getAllDismissals()throws Exception {
        return service.getAllDismissals();
    }

    @PostMapping
    Dismissal newDismissal(@RequestBody Dismissal newDismissal)throws Exception{
        return service.newDismissal(newDismissal);
    }

    @GetMapping("/{id}")
    Optional<Dismissal> getSingleDismissal(@PathVariable Long id)throws Exception{
        return service.getDismissalById(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteDismissal(@PathVariable Long id)throws Exception {
        service.deleteDismissalByID(id);
    }
}