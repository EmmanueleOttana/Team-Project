package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Dismissal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private LocalDate dataLicenziamento;
    @Column
    private String reasonsOfDismissal;
    @Column
    private int ExperienceLevel;

    public Dismissal(long id, String dataLicenziamento, String reasonsOfDismissal, int experienceLevel) {
        this.id=id;
        this.dataLicenziamento = LocalDate.parse(dataLicenziamento);
        this.reasonsOfDismissal = reasonsOfDismissal;
        ExperienceLevel = experienceLevel;
    }
    public Dismissal(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataLicenziamento() {
        return dataLicenziamento;
    }

    public void setDataLicenziamento(String dataLicenziamento) {
        this.dataLicenziamento = LocalDate.parse(dataLicenziamento);
    }

    public String getReasonsOfDismissal() {
        return reasonsOfDismissal;
    }

    public void setReasonsOfDismissal(String reasonsOfDismissal) {
        this.reasonsOfDismissal = reasonsOfDismissal;
    }

    public int getExperienceLevel() {
        return ExperienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        ExperienceLevel = experienceLevel;
    }
}
