package contracts;

import static contracts.TypeOfContract.*;

public class ContractsService {
    ContractsEntity contractsEntity;
    /**
     * Added Class method getTypeOfContract for switch
     * @param contract of the single employee
     */
    public void getTypeOfContract(ContractsEntity contract) {
        contractsEntity.setTypeOfContract(contract);
        if (contract.equals(FIXED_TERM)) {
            System.out.println("Contratto a tempo determinato");
        } else if (contract.equals(OPEN_ENDED)) {
            System.out.println("Contratto a tempo indeterminato");
        } else if (contract.equals(PART_TIME)) {
            System.out.println("Contratto part Time");
        }else if (contract.equals(FULL_TIME)) {
            System.out.println("Contratto full Time");
        } else if (contract.equals(APPRENTICESHIP)) {
            System.out.println("Contratto di apprendistato");
        } else if (contract.equals(INTERNSHIP)) {
            System.out.println("Contratto di stage");
        } else if (contract.equals(ON_CALL_CONTRACT)) {
            System.out.println("Contratto Intermittente");
        } else if (contract.equals(OCCASIONAL_PROFESSIONAL_SERVICE)) {
            System.out.println("Contratto a Prestazioni Occasionali");
        } else if (contract.equals(AUXILIARY)) {
            System.out.println("Contratto di tipo Ausiliario");
        } else if (contract.equals(TERM_CONTRACT)) {
            System.out.println("Contratto Co Co Co");
        } else if (contract.equals(ADMINISTRATION)) {
            System.out.println("Contratto a Somministrazione");
        }
    }

}