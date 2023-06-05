package start.entities;

public enum ContractDuration {
    FULL_TIME("Contratto Full Time",160),
    PART_TIME("Contratto Part Time",80);

    private String displayType;
    private int oreDaContratto;

    ContractDuration(String displayType, int oreDaContratto) {
        this.displayType = displayType;
        this.oreDaContratto = oreDaContratto;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public int getOreDaContratto() {
        return oreDaContratto;
    }

    public void setOreDaContratto(int oreDaContratto) {
        this.oreDaContratto = oreDaContratto;
    }


}
