package contracts;

import static contracts.ContractsEntity.Contracts.*;

public class ContractsService {
    ContractsEntity contractsEntity;
    /**
     * Added Class method getTypeOfContract for switch
     * @param contract of the single employee
     */
    public void getTypeOfContract(ContractsEntity contract) {
        contractsEntity.setTypeOfContract(contract);
        if (contract.equals(DETERMINATO)) {
            System.out.println("Contratto a tempo determinato");
        } else if (contract.equals(INDETERMINATO)) {
            System.out.println("Contratto a tempo indeterminato");
        } else if (contract.equals(PART_TIME)) {
            System.out.println("Contratto Part Time");
        } else if (contract.equals(APPRENDISTATO)) {
            System.out.println("Contratto di apprendistato");
        } else if (contract.equals(STAGE)) {
            System.out.println("Contratto di Stage");
        } else if (contract.equals(INTERMITTENTE)) {
            System.out.println("Contratto Intermittente");
        } else if (contract.equals(PRESTAZIONI_OCCASIONALI)) {
            System.out.println("Contratto a Prestazioni Occasionali");
        } else if (contract.equals(AUSILIARIO)) {
            System.out.println("Contratto di tipo Ausiliario");
        } else if (contract.equals(CO_CO_CO)) {
            System.out.println("Contratto Co Co Co");
        } else if (contract.equals(SOMMINISTRAZIONE)) {
            System.out.println("Contratto a Somministrazione");
        }
    }
}