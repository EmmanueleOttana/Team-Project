package start.services;

import start.entities.Benefits;

public class BenefitsService {
    public Benefits benefits;
    public String calculateTotalBenefits(){
        return benefits.getAwardsProduction()
                +" "+ benefits.getBenefitsCorporateMaterials();
    }
}
