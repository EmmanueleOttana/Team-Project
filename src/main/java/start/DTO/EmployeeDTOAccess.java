package start.DTO;

public class EmployeeDTOAccess {
    private long idDipendente;
    private String nome;
    private String cognome;
    private String tipoDiContratto;
    private String durataContratto;
    private String accessoBadge;


    public long getIdDipendente() {
        return idDipendente;
    }

    public void setIdDipendente(long idDipendente) {
        this.idDipendente = idDipendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTipoDiContratto() {
        return tipoDiContratto;
    }

    public void setTipoDiContratto(String tipoDiContratto) {
        this.tipoDiContratto = tipoDiContratto;
    }

    public String getAccessoBadge() {
        return accessoBadge;
    }

    public void setAccessoBadge(String accessoBadge) {
        this.accessoBadge = accessoBadge;
    }

    public String getDurataContratto() {
        return durataContratto;
    }

    public void setDurataContratto(String durataContratto) {
        this.durataContratto = durataContratto;
    }
}
