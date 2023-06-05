package start.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    private TypeOfContract typeOfContract;

    @Column
    private double durationTime;
    @Column
    private double wage;
    @Column
    private boolean trialPeriod;
    @Column
    private boolean internshipAlreadyDone;
    @Column
    private int levelOfContract;
    @Column
    private int hoursContract;


    public Contracts(TypeOfContract typeOfContract,
                     double durationTime, double wage, boolean trialPeriod,
                     boolean internshipAlreadyDone, int levelOfContract) {

        this.typeOfContract = typeOfContract;
        this.durationTime = durationTime;
        this.wage = wage;
        this.trialPeriod = trialPeriod;
        this.internshipAlreadyDone = internshipAlreadyDone;
        this.levelOfContract = levelOfContract;
    }
    /*public Contracts(Contracts typeOfContract, double durationTime, double wage, boolean trialPeriod, boolean internshipAlreadyDone, int levelOfContract) {
        this.typeOfContract = typeOfContract;
        this.durationTime = durationTime;
        this.wage = wage;
        this.trialPeriod = trialPeriod;
        this.internshipAlreadyDone = internshipAlreadyDone;
        this.levelOfContract = levelOfContract;
    }*/
    public Contracts(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeOfContract getTypeOfContract() {
        return typeOfContract;
    }

    public void setTypeOfContract(TypeOfContract typeOfContract) {
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

    public int getHoursContract() {
        return hoursContract;
    }

    public void setHoursContract(int hoursContract) {
        this.hoursContract = hoursContract;
    }
}
