package start.services;

import org.springframework.stereotype.Service;
import start.entities.Benefits;

@Service
public class BenefitsService {
    public Benefits benefits;
    public String calculateTotalBenefits(){
        return benefits.getAwardsProduction()
                +" "+ benefits.getBenefitsCorporateMaterials();
    }
}
