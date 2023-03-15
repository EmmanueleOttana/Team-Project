package contracts;

public class ContractsRepository {
    public ContractsEntity typeOfContract;
    public double durationTime;
    public double wage;
    public boolean trialPeriod;
    public boolean internshipAlreadyDone;
    public int levelOfContract; //da vedere

    public ContractsRepository(double durationTime, double wage, boolean trialPeriod, boolean internshipAlreadyDone, int levelOfContract) {
        this.durationTime = durationTime;
        this.wage = wage;
        this.trialPeriod = trialPeriod;
        this.internshipAlreadyDone = internshipAlreadyDone;
        this.levelOfContract = levelOfContract;
    }

}
