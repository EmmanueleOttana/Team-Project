package controllers;

import entities.TypeOfWork;
import org.springframework.web.bind.annotation.*;
import repositories.TypeOfWorkRepository;

import java.util.List;

@RestController
@RequestMapping("/typeOfWork")
public class TypeOfWorkController {
    private final TypeOfWorkRepository repository;

    TypeOfWorkController(TypeOfWorkRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<TypeOfWork> getAllTypeOfWorks() {
        return repository.findAll();
    }

    @PostMapping("")
    TypeOfWork newTypeOfWork(@RequestBody TypeOfWork newTypeOfWork){
        return repository.save(newTypeOfWork);
    }

    @GetMapping("/{id}")
    TypeOfWork getSingleTypeOfWork(@PathVariable Long id)throws Exception{
        return repository.findById(id)
                .orElseThrow(() -> new Exception("ID not found: "+id));
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteTypeOfWork(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
