import HumanResources.Employees;

import java.util.Date;

public class Licenziamento extends Employees {
    public Date dataLicenziamento;
    public String reasonsOfDismissal;
    public int ExperienceLevel;

    public Licenziamento(String name, String surName, int ID, String codiceFiscale, String typeOfWork, String typeOfContract, String dateOfBirth, Date dataLicenziamento, String reasonsOfDismissal, int experienceLevel) {
        super(name, surName, ID, codiceFiscale, typeOfWork, typeOfContract, dateOfBirth);
        this.dataLicenziamento = dataLicenziamento;
        this.reasonsOfDismissal = reasonsOfDismissal;
        ExperienceLevel = experienceLevel;
    }

    public Date getDataLicenziamento() {
        return dataLicenziamento;
    }

    public void setDataLicenziamento(Date dataLicenziamento) {
        this.dataLicenziamento = dataLicenziamento;
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
