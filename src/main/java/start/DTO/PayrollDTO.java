package start.DTO;

public class PayrollDTO {

    private long idBustaPaga;
    private EmployeeDTO dipendente = new EmployeeDTO();
    private double retribuzioneLorda;
    private double trattenuteDelloStato;
    private double retribuzioneNetta;

    public long getIdBustaPaga() {
        return idBustaPaga;
    }

    public EmployeeDTO getDipendente() {
        return dipendente;
    }

    public double getRetribuzioneLorda() {
        return retribuzioneLorda;
    }

    public double getRetribuzioneNetta() {
        return retribuzioneNetta;
    }

    public double getTrattenuteDelloStato() {
        return trattenuteDelloStato;
    }

    public PayrollDTO() {
    }

    public void setTrattenuteDelloStato(double trattenuteDelloStato) {
        this.trattenuteDelloStato = trattenuteDelloStato;
    }

    public void setIdBustaPaga(long idBustaPaga) {
        this.idBustaPaga = idBustaPaga;
    }

    public void setRetribuzioneLorda(double retribuzioneLorda) {
        this.retribuzioneLorda = retribuzioneLorda;
    }

    public void setRetribuzioneNetta(double retribuzioneNetta) {
        this.retribuzioneNetta = retribuzioneNetta;
    }

    public void setDipendente(EmployeeDTO dipendente) {
        this.dipendente = dipendente;
    }

    @Override
    public String toString() {
        return "{" +
                "\nID_Busta_Paga : " + this.idBustaPaga +
                "\nID_Dipendente : " + this.dipendente.getIdDipendente() +
                "\nNome : " + this.dipendente.getNome() +
                "\nCognome : " + this.dipendente.getCognome() +
                "\nTipo_Di_Contratto : " + this.dipendente.getTipoDiContratto() +
                "\nRetribuzione_Lorda : " + this.retribuzioneLorda +
                "\nRetribuzione_Netta : " + this.retribuzioneNetta +
                "\n}";
    }
}
