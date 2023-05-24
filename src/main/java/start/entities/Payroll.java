package start.entities;
import jakarta.persistence.*;
import start.DTO.PayrollDTO;

@Entity
@Table
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Employee employees;
    /*
    @Column
    private boolean presenza; //presence
    @Column
    private double oreAssenze; //absentHours
     */
    @Enumerated(EnumType.STRING)
    private TypeOfContract typeOfContract;
    @Column
    private double oreContratto; //contractHours
    @Column
    private double oreEffettuate; //hoursWorked
    @Column
    private double trattenuteStato;
    @Column
    private double retribuzioneLorda;
    @Column
    private double retribuzioneNetta;
    @Transient
    private PayrollDTO payrollDTO = new PayrollDTO();

    public Payroll(Employee employee, double trattenuteStato, double retribuzioneLorda, double retribuzioneNetta) {
        this.employees = employee;
        this.typeOfContract = employee.getTypeOfContract();
        this.oreContratto = employee.getContractDuration().getOreDaContratto();
        this.trattenuteStato = trattenuteStato;
        this.retribuzioneLorda = retribuzioneLorda;
        this.retribuzioneNetta = retribuzioneNetta;
    }

    public Payroll(){}

    public long getId() {
        return id;
    }
/*
    public boolean isPresenza() {
        return presenza;
    }

    public double getOreAssenze() {
        return oreAssenze;
    }

    public double getOreContratto() {
        return oreContratto;
    }
*/
    public double getOreEffettuate() {
        return oreEffettuate;
    }

    /*public double getTrattenuteStato() {
        return trattenuteStato;
    }

    public void setTrattenuteStato(double trattenuteStato) {
        this.trattenuteStato = trattenuteStato;
        this.retribuzioneNetta = this.retribuzioneLorda - trattenuteStato;
    }*/

    public double getRetribuzioneLorda() {
        return retribuzioneLorda;
    }



    public double getRetribuzioneNetta() {
        return retribuzioneNetta;
    }

    public void setRetribuzioneNetta(double retribuzioneNetta) {
        this.retribuzioneNetta = retribuzioneNetta;
    }
/*
    public void setPresenza(boolean presenza) {
        this.presenza = presenza;
    }

    // Metodo per inserire le ore di assenza
    public void setOreAssenze(int oreAssenze) {
        this.oreAssenze = oreAssenze;
    }
*/
    // Metodo per inserire le ore di contratto
    public void setOreContratto(int oreContratto) {
        this.oreContratto = oreContratto;
    }

    public void setOreEffettuate(double oreEffettuate) {
        this.oreEffettuate = oreEffettuate;
    }

    public PayrollDTO getPayrollDTO() {
        return payrollDTO;
    }

    public PayrollDTO assignPayrollDTO() {
        this.payrollDTO.setIdBustaPaga(this.getId());
        this.payrollDTO.setRetribuzioneLorda(this.retribuzioneLorda);
        this.payrollDTO.setTrattenuteDelloStato(this.trattenuteStato);
        this.payrollDTO.setRetribuzioneNetta(this.retribuzioneNetta);
        return this.payrollDTO;
    }
}
