import HumanResources.Employees;

public class Payroll {
    public boolean presenza; //presence
    public int oreAssenze; //absentHours
    public int oreContratto; //contractHours
    public int oreEffettuate; //hoursWorked
    public double trattenuteStato;
    public double retribuzioneLorda;
    public double retribuzioneNetta;

    public Payroll(boolean presenza, int oreAssenze, int oreContratto, int oreEffettuate, double trattenuteStato, double retribuzioneLorda, double retribuzioneNetta) {
        this.presenza = presenza;
        this.oreAssenze = oreAssenze;
        this.oreContratto = oreContratto;
        this.oreEffettuate = oreEffettuate;
        this.trattenuteStato = trattenuteStato;
        this.retribuzioneLorda = retribuzioneLorda;
        this.retribuzioneNetta = retribuzioneNetta;
    }
    Employees employees=new Employees();

    public boolean isPresenza() {
        return presenza;
    }

    public int getOreAssenze() {
        return oreAssenze;
    }

    public int getOreContratto() {
        return oreContratto;
    }

    public int getOreEffettuate() {
        return oreEffettuate;
    }

    public double getTrattenuteStato() {
        return trattenuteStato;
    }

    public void setTrattenuteStato(double trattenuteStato) {
        this.trattenuteStato = trattenuteStato;
        this.retribuzioneNetta = this.retribuzioneLorda - trattenuteStato;
    }

    public double getRetribuzioneLorda() {
        return retribuzioneLorda;
    }

    public void setRetribuzioneLorda(double retribuzioneLorda) {
        this.retribuzioneLorda = retribuzioneLorda;
        this.retribuzioneNetta = retribuzioneLorda - this.trattenuteStato;
    }

    public double getRetribuzioneNetta() {
        return retribuzioneNetta;
    }

    public void setRetribuzioneNetta(double retribuzioneNetta) {
        this.retribuzioneNetta = retribuzioneNetta;
    }

    public void setPresenza(boolean presenza) {
        this.presenza = presenza;
    }

    // Metodo per inserire le ore di assenza
    public void setOreAssenze(int oreAssenze) {
        this.oreAssenze = oreAssenze;
    }

    // Metodo per inserire le ore di contratto
    public void setOreContratto(int oreContratto) {
        this.oreContratto = oreContratto;
    }

    // Metodo per inserire le ore effettuate
    public void setOreEffettuate(int oreEffettuate) {
        this.oreEffettuate = oreEffettuate;
    }
}
