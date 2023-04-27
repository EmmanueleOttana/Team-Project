package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Contracts typeOfContract;
    private double durationTime;
    private double wage;
    private boolean trialPeriod;
    private boolean internshipAlreadyDone;
    private int levelOfContract;

    public Contracts(long id, Contracts typeOfContract, double durationTime, double wage, boolean trialPeriod, boolean internshipAlreadyDone, int levelOfContract) {
        this.id = id;
        this.typeOfContract = typeOfContract;
        this.durationTime = durationTime;
        this.wage = wage;
        this.trialPeriod = trialPeriod;
        this.internshipAlreadyDone = internshipAlreadyDone;
        this.levelOfContract = levelOfContract;
    }
    public Contracts(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contracts getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(Contracts typeOfContract) {
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
