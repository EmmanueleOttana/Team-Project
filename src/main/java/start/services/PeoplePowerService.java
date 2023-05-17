package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Dismissal;
import start.entities.PeoplePower;
import start.repositories.PeoplePowerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeoplePowerService {
    @Autowired
    PeoplePowerRepository peoplePowerRepository;


    public PeoplePower newPeoplePower(PeoplePower newPeoplePower)throws Exception{
        try {
            if (newPeoplePower==null) return null;
            return peoplePowerRepository.saveAndFlush(newPeoplePower);
        }catch (Exception e){
            throw new Exception("PeoplePower not found");
        }
    }
}
