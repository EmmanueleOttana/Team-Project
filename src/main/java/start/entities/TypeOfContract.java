package start.entities;

public enum TypeOfContract {
    AGENCY_WORK("Contratto a somministrazione",160),
    APPRENTICESHIP("Contratto di apprendistato"),
    FIXED_TERM("Contratto a tempo determinato"),
    FULL_TIME("Contratto full Time",160),
    INTERNSHIP("Contratto di stage"),
    OCCASIONAL_PROFESSIONAL_SERVICE("Contratto a Prestazioni Occasionali"),
    ON_CALL_CONTRACT("Contratto Intermittente",160),
    OPEN_ENDED("Contratto a tempo indeterminato",160),
    PART_TIME("Contratto part Time"),
    SELF_EMPLOYMENT("Contratto di lavoro autonomo"),
    TERM_CONTRACT("Contratto Co Co Co");

    private String displayType;
    private int oreDaContratto;

    public String getDisplayType() { return displayType; }

    public int getOreDaContratto() {
        return oreDaContratto;
    }

    TypeOfContract(String typeOfContract, int oreMensili) {
        this.displayType = typeOfContract;
        this.oreDaContratto = oreMensili;
    }

    TypeOfContract(String typeOfContract) {
        this.displayType = typeOfContract;
    }

}