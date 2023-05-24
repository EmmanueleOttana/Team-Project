package start.entities;

public enum ContractDuration {
    FULL_TIME("Contratto Full Time",160),
    PART_TIME("Contratto Part Time",80);

    private String diplayType;
    private int oreDaContratto;

    ContractDuration(String diplayType, int oreDaContratto) {
        this.diplayType = diplayType;
        this.oreDaContratto = oreDaContratto;
    }

    public String getDiplayType() {
        return diplayType;
    }

    public void setDiplayType(String diplayType) {
        this.diplayType = diplayType;
    }

    public int getOreDaContratto() {
        return oreDaContratto;
    }

    public void setOreDaContratto(int oreDaContratto) {
        this.oreDaContratto = oreDaContratto;
    }


}
