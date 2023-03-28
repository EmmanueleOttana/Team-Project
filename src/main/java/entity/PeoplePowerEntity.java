package entity;

public class PeoplePowerEntity {
    private String Agency;
    private String descriptionOfApp;
    private String NationalContract;

    public PeoplePowerEntity(String agency, String descriptionOfApp, String nationalContract){
        this.Agency = agency;
        this.descriptionOfApp = descriptionOfApp;
        this.NationalContract = nationalContract;
    }
    public String getAgency() {
        return Agency;
    }
    public void setAgency(String agency) {
        Agency = agency;
    }
    public String getDescriptionOfApp() {
        return descriptionOfApp;
    }
    public void setDescriptionOfApp(String descriptionOfApp) {
        this.descriptionOfApp = descriptionOfApp;
    }
    public String getNationalContract() {
        return NationalContract;
    }
    public void setNationalContract(String nationalContract) {
        NationalContract = nationalContract;
    }



}
