package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Benefits;
import start.entities.Contracts;
import start.repositories.ContractsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContractsService {
    @Autowired
    ContractsRepository contractsRepository;

    public List<Contracts> getAllContracts() throws Exception{
        List<Contracts> allContractsFromDB = contractsRepository.findAll();
        if (allContractsFromDB.isEmpty()){
            throw new Exception("No Contracts found!");
        }
        return allContractsFromDB;
    }

    public Contracts newContracts(Contracts contracts)throws Exception{
        try {
            if (contracts==null) return null;
            return contractsRepository.saveAndFlush(contracts);
        }catch (Exception e){
            throw new Exception("Contracts not found");
        }
    }
    public Optional<Contracts> getContractsById(long id) throws Exception{
        try {
            return contractsRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public void deleteContract(long id)throws Exception{
        try {
            contractsRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

}
