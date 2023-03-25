package Payroll;

import employee.EmployeeEntity;

public class PayrollEntity {
    EmployeeEntity employees;
    public boolean presenza; //presence
    public int oreAssenze; //absentHours
    public int oreContratto; //contractHours
    public int oreEffettuate; //hoursWorked
    public double trattenuteStato;
    public double retribuzioneLorda;
    public double retribuzioneNetta;



    /** Net salary */
    private double net;
    /** IRPEF Tax */
    private double irpef;
    /** INPS Tax */
    private double inps;
    /** TFR Tax */
    private double tfr;
    public void divideAll(int months){
        this.net /= months;
        this.irpef /= months;
        this.inps /= months;
        this.tfr /= months;
    }


    public void add(PayrollEntity payrollEntity) {
        this.net += payrollEntity.getNet();
        this.irpef += payrollEntity.getIrpef();
        this.inps += payrollEntity.getInps();
        this.tfr += payrollEntity.getTfr();
    }

    public PayrollEntity(){

    }
    public PayrollEntity(boolean presenza, int oreAssenze, int oreContratto, int oreEffettuate, double trattenuteStato, double retribuzioneLorda, double retribuzioneNetta) {
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
    public EmployeeEntity getEmployees() {
        return employees;
    }

    public void setEmployees(EmployeeEntity employees) {
        this.employees = employees;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public double getIrpef() {
        return irpef;
    }

    public void setIrpef(double irpef) {
        this.irpef = irpef;
    }

    public double getInps() {
        return inps;
    }

    public void setInps(double inps) {
        this.inps = inps;
    }

    public double getTfr() {
        return tfr;
    }

    public void setTfr(double tfr) {
        this.tfr = tfr;
    }
}
