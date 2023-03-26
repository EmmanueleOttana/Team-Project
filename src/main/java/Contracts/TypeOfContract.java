package Contracts;

public enum TypeOfContract {
    AGENCY_WORK("Contratto a somministrazione"),
    APPRENTICESHIP("Contratto di apprendistato"),
    FIXED_TERM("Contratto a tempo determinato"),
    FULL_TIME("Contratto full Time"),
    INTERNSHIP("Contratto di stage"),
    OCCASIONAL_PROFESSIONAL_SERVICE("Contratto a Prestazioni Occasionali"),
    ON_CALL_CONTRACT("Contratto Intermittente"),
    OPEN_ENDED("Contratto a tempo indeterminato"),
    PART_TIME("Contratto part Time"),
    SELF_EMPLOYMENT("Contratto di lavoro autonomo"),
    TERM_CONTRACT("Contratto Co Co Co");

    private String displayType;

    public String getDisplayType() { return displayType; }

    TypeOfContract(String typeOfContract) {
        this.displayType = typeOfContract;
    }

}