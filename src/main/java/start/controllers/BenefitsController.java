package start.controllers;

import start.entities.Benefits;
import start.repositories.BenefitsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefits")
public class BenefitsController {
    private final BenefitsRepository repository;

    public BenefitsController(BenefitsRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<Benefits> getAllBenefits() {
        return repository.findAll();
    }

    @PostMapping
    private Benefits newBenefit(@RequestBody Benefits newBenefit){
        return repository.save(newBenefit);
    }

    @GetMapping("/{id}")
    public Benefits getSingleBenefit(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    public void deleteBenefit(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
