package start.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class PeoplePower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String Agency;
    @Column
    private String descriptionOfApp;
    @Column
    private String NationalContract;

    public PeoplePower(long id, String agency, String descriptionOfApp, String nationalContract){
        this.id=id;
        this.Agency = agency;
        this.descriptionOfApp = descriptionOfApp;
        this.NationalContract = nationalContract;
    }
    public PeoplePower(){}

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
