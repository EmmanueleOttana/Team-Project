package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.Contracts;
import start.repositories.ContractsRepository;
import org.springframework.web.bind.annotation.*;
import start.services.ContractsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
public class ContractsController {
    @Autowired
    ContractsService contractsService;

    @GetMapping
    List<Contracts> getAllContracts() throws Exception{
        return contractsService.getAllContracts();
    }

    @PostMapping
    Contracts newContract(@RequestBody Contracts newContract)throws Exception{
        return contractsService.newContracts(newContract);
    }

    @GetMapping("/{id}")
    Optional<Contracts> getSingleContract(@PathVariable Long id)throws Exception{
        return contractsService.getContractsById(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteContract(@PathVariable Long id) throws Exception{
        contractsService.deleteContract(id);
    }
}
