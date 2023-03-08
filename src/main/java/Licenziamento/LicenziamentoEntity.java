package Licenziamento;

import java.util.Date;

public class LicenziamentoEntity {
    public Date dataLicenziamento;
    public String reasonsOfDismissal;
    public int ExperienceLevel;

    public LicenziamentoEntity(Date dataLicenziamento, String reasonsOfDismissal, int experienceLevel) {
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
