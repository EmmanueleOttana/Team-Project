package entity;
import java.util.List;
public class BenefitsEntity {
    EmployeeEntity employee;
    public double awardsProduction;
    List<String> benefitsCorporateMaterials;
    private boolean healthInsurance;
    private boolean retirementPlan;
    private int vacationDays;
    private int sickDays;
    public BenefitsEntity(EmployeeEntity employee, double awardsProduction, List<String> benefitsCorporateMaterials) {
        this.employee = employee;
        this.awardsProduction = awardsProduction;
        this.benefitsCorporateMaterials = benefitsCorporateMaterials;
    }
        public double getAwardsProduction () {
            return awardsProduction;
        }
        public void setAwardsProduction( double awardsProduction){
            this.awardsProduction = awardsProduction;
        }
        public List<String> getBenefitsCorporateMaterials () {
            return benefitsCorporateMaterials;
        }
        public void setBenefitsCorporateMaterials (List < String > beneficiMaterialiAziendali) {
            this.benefitsCorporateMaterials = benefitsCorporateMaterials;
        }
        public boolean isHealthInsurance() {
        return healthInsurance;
        }
    public void setHealthInsurance(boolean healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
    public boolean isRetirementPlan() {
        return retirementPlan;
    }
    public void setRetirementPlan(boolean retirementPlan) {
        this.retirementPlan = retirementPlan;
    }
    public int getVacationDays() {
        return vacationDays;
    }
    public void setVacationDays(){
        this.vacationDays=vacationDays;
    }
    public int getSickDays() {
        return sickDays;
    }
    public void setSickDays(int sickDays) {
        this.sickDays = sickDays;
    }
}
