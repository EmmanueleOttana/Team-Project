package start.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import start.entities.TypeOfWork;
import start.repositories.TypeOfWorkRepository;
import org.springframework.web.bind.annotation.*;
import start.services.TypeOfWorkService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/typeOfWork")
public class TypeOfWorkController {
    @Autowired
    private TypeOfWorkService typeOfWorkService;
    @GetMapping("")
    List<TypeOfWork> getAllTypeOfWorks() throws Exception{
        return typeOfWorkService.getAllTypeOfWorks();
    }

    @PostMapping("")
    TypeOfWork newTypeOfWork(@RequestBody TypeOfWork newTypeOfWork)throws Exception{
        return typeOfWorkService.newTypeOfWork(newTypeOfWork);
    }

    @GetMapping("/{id}")
    Optional<TypeOfWork> getSingleTypeOfWork(@PathVariable Long id)throws Exception{
        return typeOfWorkService.getTypeOfWorkById(id);
    }

    /**
     * TODO PutMapping to do.
     * @PutMapping("/{id}")
     */

    @DeleteMapping("/{id}")
    void deleteTypeOfWork(@PathVariable Long id) throws Exception{
        typeOfWorkService.deleteTypeOfWork(id);
    }
}
