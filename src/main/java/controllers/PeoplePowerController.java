package controllers;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.PeoplePowerRepository;

@RestController
@RequestMapping("/peoplePower")
public class PeoplePowerController {
    private final PeoplePowerRepository repository;

    PeoplePowerController(PeoplePowerRepository repository) {
        this.repository = repository;
    }

    /**
     * TODO API Calls to do or something else.
     */
}
