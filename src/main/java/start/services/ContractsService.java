package start.services;

import entity.ContractsEntity;

public class ContractsService {
    public ContractsEntity contractsEntity;
    public String getContractType() {
        String type;
        if (this.contractsEntity.getTypeOfContract().equals("determinato")) {
            type = "Contratto a tempo determinato";
        } else if (this.contractsEntity.getTypeOfContract().equals("indeterminato")) {
            type = "Contratto a tempo indeterminato";
        } else if (this.contractsEntity.getTypeOfContract().equals("part-time")) {
            type = "Contratto a tempo parziale";
        } else if (this.contractsEntity.getTypeOfContract().equals("apprendistato")) {
            type = "Contratto di apprendistato";
        } else {
            type = "Tipologia di contratto non identificata";
        }
        return type;
    }
}
