package controllers;

import entities.Performance;
import org.springframework.web.bind.annotation.*;
import repositories.PerformanceRepository;

import java.util.List;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
    private final PerformanceRepository repository;

    PerformanceController(PerformanceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Performance> getAllPerformances() {
        return repository.findAll();
    }

    @PostMapping("")
    Performance newPerformance(@RequestBody Performance newPerformance){
        return repository.save(newPerformance);
    }

    @GetMapping("/{id}")
    Performance getSinglePerformance(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deletePerformance(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
