package contracts;

public class ContractsEntity {
    public enum Contracts{
        DETERMINATO,
        INDETERMINATO,
        PART_TIME,
        APPRENDISTATO,
        STAGE,
        INTERMITTENTE,
        PRESTAZIONI_OCCASIONALI,
        AUSILIARIO,
        CO_CO_CO,
        SOMMINISTRAZIONE
    }
    public ContractsEntity typeOfContract;
    public double durationTime;
    public double wage;
    public boolean trialPeriod;
    public boolean internshipAlreadyDone;
    public int levelOfContract;

    public ContractsEntity(double durationTime, double wage, boolean trialPeriod, boolean internshipAlreadyDone, int levelOfContract) {
        this.durationTime = durationTime;
        this.wage = wage;
        this.trialPeriod = trialPeriod;
        this.internshipAlreadyDone = internshipAlreadyDone;
        this.levelOfContract = levelOfContract;
    }
    public ContractsEntity getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(ContractsEntity typeOfContract) {
        this.typeOfContract = typeOfContract;
    }

    public double getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(double durationTime) {
        this.durationTime = durationTime;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public boolean isTrialPeriod() {
        return trialPeriod;
    }

    public void setTrialPeriod(boolean trialPeriod) {
        this.trialPeriod = trialPeriod;
    }

    public boolean isInternshipAlreadyDone() {
        return internshipAlreadyDone;
    }

    public void setInternshipAlreadyDone(boolean internshipAlreadyDone) {
        this.internshipAlreadyDone = internshipAlreadyDone;
    }

    public int getLevelOfContract() {
        return levelOfContract;
    }

    public void setLevelOfContract(int levelOfContract) {
        this.levelOfContract = levelOfContract;
    }


}
