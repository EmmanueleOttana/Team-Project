package payroll;

import employee.EmployeeEntity;

public class PayrollEntity {
    EmployeeEntity employees;
    public boolean presenza; //presence
    public double oreAssenze; //absentHours
    public double oreContratto; //contractHours
    public double oreEffettuate; //hoursWorked
    public double trattenuteStato;
    public double retribuzioneLorda;
    public double retribuzioneNetta;

    public PayrollEntity(EmployeeEntity employee, boolean presenza, double oreAssenze, double oreContratto, double oreEffettuate, double trattenuteStato, double retribuzioneLorda, double retribuzioneNetta) {
        this.employees = employee;
        this.presenza = presenza;
        this.oreAssenze = oreAssenze;
        this.oreContratto = oreContratto;
        this.oreEffettuate = oreEffettuate;
        this.trattenuteStato = trattenuteStato;
        this.retribuzioneLorda = retribuzioneLorda;
        this.retribuzioneNetta = retribuzioneNetta;
    }

    public boolean isPresenza() {
        return presenza;
    }

    public double getOreAssenze() {
        return oreAssenze;
    }

    public double getOreContratto() {
        return oreContratto;
    }

    public double getOreEffettuate() {
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