package service;

import entity.BenefitsEntity;

public class BenefitsService {
    public BenefitsEntity benefitsEntity;
    public double calculateTotalBenefits(){
        double totalBenefits = benefitsEntity.getAwardsProduction() + benefitsEntity.getBenefitsCorporateMaterials();
        return totalBenefits;
    }
}
