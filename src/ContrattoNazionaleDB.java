//renderlo interfacce
public class ContrattoNazionaleDB {
    public Contracts typeOfContract;
    public double durationTime;
    public double wage;
    public boolean trialPeriod;
    public boolean internshipAlreadyDone;
    public int levelOfContract; //da vedere
    public ContrattoNazionaleDB(double durationTime, double wage, boolean trialPeriod, boolean internshipAlreadyDone, int levelOfContract) {
        this.durationTime = durationTime;
        this.wage = wage;
        this.trialPeriod = trialPeriod;
        this.internshipAlreadyDone = internshipAlreadyDone;
        this.levelOfContract = levelOfContract;
    }
    /**
     * Added void method printContracts for switch
     * @param contract of the single employee
     */
    public static void printContracts(Contracts contract){
        switch(contract){
            case DETERMINATO:
                System.out.println("Contratto a tempo determinato");
                break;
            case INDETERMINATO:
                System.out.println("Contratto a tempo indeterminato");
                break;
            case PART_TIME:
                System.out.println("Contratto Part Time");
                break;
            case APPRENDISTATO:
                System.out.println("Contratto di apprendistato");
                break;
            case STAGE:
                System.out.println("Contratto di Stage");
                break;
            case INTERMITTENTE:
                System.out.println("Contratto Intermittente");
                break;
            case PRESTAZIONI_OCCASIONALI:
                System.out.println("Contratto a Prestazioni Occasionali");
                break;
            case AUSILIARIO:
                System.out.println("Contratto di tipo Ausiliario");
                break;
            case CO_CO_CO:
                System.out.println("Contratto Co Co Co");
                break;
            case SOMMINISTRAZIONE:
                System.out.println("Contratto a Somministrazione");
                break;
        }
    }
    public Contracts getTypeOfContract() {
        return typeOfContract;

    }

}
