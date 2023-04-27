package controllers;

import entities.Benefits;
import org.springframework.web.bind.annotation.*;
import repositories.BenefitsRepository;

import java.util.List;

@RestController
@RequestMapping("/benefits")
public class BenefitsController {
    private final BenefitsRepository repository;

    BenefitsController(BenefitsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Benefits> getAllBenefits() {
        return repository.findAll();
    }

    @PostMapping("")
    Benefits newBenefit(@RequestBody Benefits newBenefit){
        return repository.save(newBenefit);
    }

    @GetMapping("/{id}")
    Benefits getSingleBenefit(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteBenefit(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
