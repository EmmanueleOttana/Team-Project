package entity;

import jakarta.persistence.*;

@Entity
@Table
public class PeoplePowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Agency;
    private String descriptionOfApp;
    private String NationalContract;

    public PeoplePowerEntity(long id,String agency, String descriptionOfApp, String nationalContract){
        this.id=id;
        this.Agency = agency;
        this.descriptionOfApp = descriptionOfApp;
        this.NationalContract = nationalContract;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
