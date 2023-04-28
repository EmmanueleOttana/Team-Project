package start.controllers;

import start.entities.Admin;
import start.repositories.AdminRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminRepository repository;

    AdminController(AdminRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Admin> getAllAdmins() {
        return repository.findAll();
    }

    @PostMapping("")
    Admin newAdmin(@RequestBody Admin newAdmin){
        return repository.save(newAdmin);
    }

    @GetMapping("/{id}")
    Admin getSingleAdmin(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteAdmin(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
