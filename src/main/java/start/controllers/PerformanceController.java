package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Performance;
import org.springframework.web.bind.annotation.*;
import start.services.PerformanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/performance")
public class PerformanceController {
    @Autowired
    PerformanceService performanceService;
    @GetMapping
    List<Performance> getAllPerformances() throws Exception{
        return performanceService.getAllPerformances();
    }

    @PostMapping
    Performance newPerformance(@RequestBody Performance newPerformance)throws Exception{
        return performanceService.newPerformance(newPerformance);
    }

    @GetMapping("/{id}")
    Optional<Performance> getSinglePerformance(@PathVariable Long id)throws Exception{
        return performanceService.getPerformanceById(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deletePerformance(@PathVariable Long id) throws Exception{
        performanceService.deletePerformance(id);
    }
}
