package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Employee employees;
    private boolean presenza; //presence
    private double oreAssenze; //absentHours
    private double oreContratto; //contractHours
    private double oreEffettuate; //hoursWorked
    private double trattenuteStato;
    private double retribuzioneLorda;
    private double retribuzioneNetta;

    public Payroll(long id, Employee employee, boolean presenza, double oreAssenze, double oreContratto, double oreEffettuate, double trattenuteStato, double retribuzioneLorda, double retribuzioneNetta) {
        this.id=id;
        this.employees = employee;
        this.presenza = presenza;
        this.oreAssenze = oreAssenze;
        this.oreContratto = oreContratto;
        this.oreEffettuate = oreEffettuate;
        this.trattenuteStato = trattenuteStato;
        this.retribuzioneLorda = retribuzioneLorda;
        this.retribuzioneNetta = retribuzioneNetta;
    }
    public Payroll(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
