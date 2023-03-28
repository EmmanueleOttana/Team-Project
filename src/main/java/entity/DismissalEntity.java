package entity;

import java.time.LocalDate;

public class DismissalEntity {
    public LocalDate dataLicenziamento;
    public String reasonsOfDismissal;
    public int ExperienceLevel;

    public DismissalEntity(String dataLicenziamento, String reasonsOfDismissal, int experienceLevel) {
        this.dataLicenziamento = LocalDate.parse(dataLicenziamento);
        this.reasonsOfDismissal = reasonsOfDismissal;
        ExperienceLevel = experienceLevel;
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
