package start.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import start.entities.Benefits;
import start.entities.Employee;
import start.repositories.BenefitsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BenefitsService {
    @Autowired
    private BenefitsRepository benefitsRepository;


    public Benefits benefits;
    public String calculateTotalBenefits(){
        return benefits.getAwardsProduction()
                +" "+ benefits.getBenefitsCorporateMaterials();
    }
    public List<Benefits> getAllBenefits() throws Exception{
        List<Benefits> allBenefitsFromDB = benefitsRepository.findAll();
        if (allBenefitsFromDB.isEmpty()){
            throw new Exception("No Benefits found!");
        }
        return allBenefitsFromDB;
    }

    public Benefits newBenefits(Benefits benefits)throws Exception{
        try {
            if (benefits==null) return null;
            return benefitsRepository.saveAndFlush(benefits);
        }catch (Exception e){
            throw new Exception("Benefits not found");
        }
    }
    public Optional<Benefits> getBenefitsById(long id) throws Exception{
        try {
            return benefitsRepository.findById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }

    public void deleteBenefit(long id)throws Exception{
        try {
            benefitsRepository.deleteById(id);
        }catch (Exception e){
            throw new Exception("ID not found");
        }
    }
}
