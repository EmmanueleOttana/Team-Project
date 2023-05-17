package start.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import start.repositories.PeoplePowerRepository;
import start.services.PeoplePowerService;

@RestController
@RequestMapping("/peoplePower")
public class PeoplePowerController {
    @Autowired
    PeoplePowerService peoplePowerService;

    /**
     * TODO API Calls to do or something else.
     */
}
