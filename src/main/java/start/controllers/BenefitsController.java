package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Benefits;
import start.repositories.BenefitsRepository;
import org.springframework.web.bind.annotation.*;
import start.services.BenefitsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/benefits")
public class BenefitsController {
    @Autowired
    BenefitsService benefitsService;



    @GetMapping
    private List<Benefits> getAllBenefits() throws Exception{
        return benefitsService.getAllBenefits();
    }

    @PostMapping
    private Benefits newBenefit(@RequestBody Benefits newBenefit)throws Exception{
        return benefitsService.newBenefits(newBenefit);
    }

    @GetMapping("/{id}")
    public Optional<Benefits> getSingleBenefit(@PathVariable Long id)throws Exception{
        return benefitsService.getBenefitsById(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    public void deleteBenefit(@PathVariable Long id) throws Exception{
        benefitsService.deleteBenefit(id);
    }
}
